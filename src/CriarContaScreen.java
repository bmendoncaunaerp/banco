import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarContaScreen extends JFrame implements ActionListener {
    private JLabel idLabel, nameLabel, balanceLabel;
    private JTextField idField, nameField, balanceField;
    private JButton createButton, cancelButton;

    private ContaBaseDeDados baseDeDados;

    public CriarContaScreen() {
        super("Criar Conta");

        baseDeDados = new ContaBaseDeDados();

        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Nome:");
        balanceLabel = new JLabel("Saldo:");

        idField = new JTextField(10);
        nameField = new JTextField(20);
        balanceField = new JTextField(10);

        createButton = new JButton("Criar conta");
        createButton.setActionCommand("criar");
        createButton.addActionListener(this);

        cancelButton = new JButton("Cancelar");
        cancelButton.setActionCommand("cancelar");
        cancelButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(balanceLabel);
        panel.add(balanceField);
        panel.add(cancelButton);
        panel.add(createButton);

        add(panel);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("criar")) {
            int id = Integer.parseInt(idField.getText());
            String nome = nameField.getText();
            float saldo = Float.parseFloat(balanceField.getText());
            Conta novaConta = new Conta(id, nome, saldo);

            baseDeDados.adicionarConta(novaConta);

            idField.setText("");
            nameField.setText("");
            balanceField.setText("");

            Conta contaCadastrada = baseDeDados.obterContaPorId(id);
            System.out.println("Conta cadastrada " + contaCadastrada.getId());

        } else if(e.getActionCommand().equals("cancelar")){
            System.out.println("Botão cancelar clicado");
        }
    }
}
