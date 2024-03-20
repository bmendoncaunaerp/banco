public class Conta {
    Conta(int id, String nome, float saldo) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
    }
    private int id;
    private String nome;
    private float saldo;

    public int getId() {
        return id;
    }

    void sacar(float valor) {
        this.saldo -= valor;
    }

    void depositar(float valor) {
        this.saldo += valor;
    }

    void transferir(Conta contaPara, float valor) {
        this.sacar(valor);
        contaPara.depositar(valor);
    }
}
