public abstract class Colaborador {
    protected String nomeCompleto;
    protected String cidadeResidencial;
    protected String unidadeFederativa;
    protected int horasAtuadas;
    protected Setor setor;

    public Colaborador(String nomeCompleto, String cidadeResidencial, String unidadeFederativa, int horasAtuadas, Setor setor) {
        this.nomeCompleto = nomeCompleto;
        this.cidadeResidencial = cidadeResidencial;
        this.unidadeFederativa = unidadeFederativa;
        this.horasAtuadas = horasAtuadas;
        this.setor = setor;
        this.setor.incluirFuncionario(this);
    }

    public abstract double calcularSalario();

    public String obterNome() {
        return nomeCompleto;
    }

    public Setor obterSetor() {
        return setor;
    }
}
