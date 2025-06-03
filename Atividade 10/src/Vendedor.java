public class Vendedor extends Colaborador {
    private double totalDeVendas;
    private double taxaComissao;

    public Vendedor(String nomeCompleto, String cidadeOrigem, String uf, int horasTrabalhadas, Setor setor, double totalDeVendas, double taxaComissao) {
        super(nomeCompleto, cidadeOrigem, uf, horasTrabalhadas, setor);
        this.totalDeVendas = totalDeVendas;
        this.taxaComissao = taxaComissao;
    }

    @Override
    public double calcularSalario() {
        return totalDeVendas * (taxaComissao / 100.0);
    }
}
