public class Temporario extends Colaborador {

    public Temporario(String nomeCompleto, String cidadeOrigem, String uf, int horasTrabalhadas, Setor setor) {
        super(nomeCompleto, cidadeOrigem, uf, horasTrabalhadas, setor);
    }

    @Override
    public double calcularSalario() {
        return horasAtuadas * setor.obterPrecoHora();
    }
}
