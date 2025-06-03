public class Assalariado extends Colaborador {
    private double valorFixoMensal;

    public Assalariado(String nomeCompleto, String cidadeResidencial, String uf, int horasMensais, Setor setor, double valorFixoMensal) {
        super(nomeCompleto, cidadeResidencial, uf, horasMensais, setor);
        this.valorFixoMensal = valorFixoMensal;
    }

    @Override
    public double calcularSalario() {
        return valorFixoMensal;
    }
}
