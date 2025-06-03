import java.util.ArrayList;
import java.util.List;

public class Setor {
    private String nomeSetor;
    private double precoHora;
    private List<Colaborador> equipe;

    public Setor(String nomeSetor, double precoHora) {
        this.nomeSetor = nomeSetor;
        this.precoHora = precoHora;
        this.equipe = new ArrayList<>();
    }

    public String obterNomeSetor() {
        return nomeSetor;
    }

    public double obterPrecoHora() {
        return precoHora;
    }

    public void incluirFuncionario(Colaborador colaborador) {
        equipe.add(colaborador);
    }

    public List<Colaborador> listarColaboradores() {
        return equipe;
    }

    public double somarSalarios() {
        double soma = 0.0;
        for (Colaborador pessoa : equipe) {
            soma += pessoa.calcularSalario();
        }
        return soma;
    }
}
