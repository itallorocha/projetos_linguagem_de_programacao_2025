import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Gerenciador sistema = new Gerenciador();

        while (true) {
            String escolha = JOptionPane.showInputDialog(
                    "MENU PRINCIPAL:\n" +
                            "1. Novo Setor\n" +
                            "2. Novo Colaborador\n" +
                            "3. Exibir Salários por Setor\n" +
                            "4. Exibir Total de Salários\n" +
                            "5. Encerrar\n" +
                            "Digite a opção desejada:"
            );

            if (escolha == null) break;

            switch (escolha) {
                case "1":
                    String nomeSetor = JOptionPane.showInputDialog("Nome do Setor:");
                    String valorH = JOptionPane.showInputDialog("Valor por Hora:");
                    double precoHora = Double.parseDouble(valorH);
                    sistema.criarSetor(nomeSetor, precoHora);
                    JOptionPane.showMessageDialog(null, "Setor registrado com sucesso!");
                    break;

                case "2":
                    String nome = JOptionPane.showInputDialog("Nome do Colaborador:");
                    String cidade = JOptionPane.showInputDialog("Cidade:");
                    String uf = JOptionPane.showInputDialog("Estado (UF):");
                    int horas = Integer.parseInt(JOptionPane.showInputDialog("Horas trabalhadas:"));
                    String setorNome = JOptionPane.showInputDialog("Nome do Setor:");
                    Setor setor = sistema.encontrarSetor(setorNome);

                    if (setor == null) {
                        JOptionPane.showMessageDialog(null, "Setor não localizado!");
                        break;
                    }

                    String tipoFunc = JOptionPane.showInputDialog(
                            "Tipo de Colaborador:\n1 - Assalariado\n2 - Temporário\n3 - Vendedor"
                    );

                    switch (tipoFunc) {
                        case "1":
                            double fixo = Double.parseDouble(JOptionPane.showInputDialog("Salário fixo:"));
                            new Assalariado(nome, cidade, uf, horas, setor, fixo);
                            break;
                        case "2":
                            new Temporario(nome, cidade, uf, horas, setor);
                            break;
                        case "3":
                            double valorVendas = Double.parseDouble(JOptionPane.showInputDialog("Total de Vendas:"));
                            double comissao = Double.parseDouble(JOptionPane.showInputDialog("Taxa de Comissão (%):"));
                            new Vendedor(nome, cidade, uf, horas, setor, valorVendas, comissao);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Tipo inválido!");
                    }
                    JOptionPane.showMessageDialog(null, "Colaborador adicionado!");
                    break;

                case "3":
                    StringBuilder relatorioSetores = new StringBuilder();
                    for (Setor s : sistema.listarSetores()) {
                        relatorioSetores.append("Setor: ").append(s.obterNomeSetor()).append("\n");
                        for (Colaborador c : s.listarColaboradores()) {
                            relatorioSetores.append(" - ").append(c.obterNome())
                                    .append(" | Salário: ").append(c.calcularSalario()).append("\n");
                        }
                        relatorioSetores.append("Total do Setor: ").append(s.somarSalarios()).append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, relatorioSetores.toString());
                    break;

                case "4":
                    double totalGlobal = 0;
                    StringBuilder resumo = new StringBuilder();
                    for (Setor s : sistema.listarSetores()) {
                        double soma = s.somarSalarios();
                        resumo.append("Setor: ").append(s.obterNomeSetor())
                                .append(" | Total: ").append(soma).append("\n");
                        totalGlobal += soma;
                    }
                    resumo.append("\nTotal Geral: ").append(totalGlobal);
                    JOptionPane.showMessageDialog(null, resumo.toString());
                    break;

                case "5":
                    JOptionPane.showMessageDialog(null, "Finalizando aplicação...");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}
