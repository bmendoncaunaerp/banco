import java.util.ArrayList;
import java.util.List;

public class ContaBaseDeDados {
    private List<Conta> contas = new ArrayList<Conta>();

    void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    Conta obterContaPorId(int contaId) {
        for (Conta conta : contas) {
            if (conta.getId() == contaId) {
                return conta;
            }
        }
        return null;
    }
}
