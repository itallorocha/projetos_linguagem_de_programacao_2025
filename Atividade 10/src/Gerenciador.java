import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
    private List<Setor> setores;

    public Gerenciador() {
        setores = new ArrayList<>();
    }

    public void criarSetor(String nome, double precoHora) {
        setores.add(new Setor(nome, precoHora));
    }

    public Setor encontrarSetor(String nome) {
        for (Setor s : setores) {
            if (s.obterNomeSetor().equalsIgnoreCase(nome)) {
                return s;
            }
        }
        return null;
    }

    public List<Setor> listarSetores() {
        return setores;
    }

    public void exibirSalariosPorSetor() {
        for (Setor s : setores) {
            System.out.println("Setor: " + s.obterNomeSetor());
            for (Colaborador c : s.listarColaboradores()) {
                System.out.println("Colaborador: " + c.obterNome() + " - Salário: " + c.calcularSalario());
            }
            System.out.println("Total de salários do setor: " + s.somarSalarios());
            System.out.println("----------");
        }
    }

    public void exibirTotalSalarios() {
        double totalGeral = 0.0;
        for (Setor s : setores) {
            double subtotal = s.somarSalarios();
            System.out.println("Setor: " + s.obterNomeSetor() + " - Total: " + subtotal);
            totalGeral += subtotal;
        }
        System.out.println("Total geral de salários: " + totalGeral);
    }
}
