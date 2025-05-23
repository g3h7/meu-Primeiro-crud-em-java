package cliente.view;
import cliente.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class CadastrarClienteView extends JFrame {
    private JTextField campoId, campoNome, campoEmail, campoTelefone;
    private JComboBox<String> comboTipo;
    private JCheckBox checkNutricionista; // NOVO
    private JLabel valorPreco;
    private ClienteService clienteService = SistemaAcademia.getClienteService();

    public CadastrarClienteView() {
        setTitle("Cadastrar Novo Cliente");
        setSize(400, 450); // aumentei altura
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel labelId = new JLabel("ID");
        labelId.setBounds(30, 20, 100, 25);
        add(labelId);

        campoId = new JTextField();
        campoId.setBounds(150, 20, 200, 25);
        add(campoId);

        JLabel labelNome = new JLabel("NOME: ");
        labelNome.setBounds(30, 60, 100, 25);
        add(labelNome);

        campoNome = new JTextField();
        campoNome.setBounds(150, 60, 200, 25);
        add(campoNome);

        JLabel labelEmail = new JLabel("EMAIL: ");
        labelEmail.setBounds(30, 100, 100, 25);
        add(labelEmail);

        campoEmail = new JTextField();
        campoEmail.setBounds(150, 100, 200, 25);
        add(campoEmail);

        JLabel labelTelefone = new JLabel("Telefone: ");
        labelTelefone.setBounds(30, 140, 100, 25);
        add(labelTelefone);

        campoTelefone = new JTextField();
        campoTelefone.setBounds(150, 140, 200, 25);
        add(campoTelefone);

        JLabel labelTipo = new JLabel("Tipo de Cliente");
        labelTipo.setBounds(30, 180, 120, 25);
        add(labelTipo);

        comboTipo = new JComboBox<>(new String[]{"Selecione o tipo...", "Padrão", "Premium", "Deluxe"});
        comboTipo.setBounds(150, 180, 200, 25);
        add(comboTipo);

        // CHECKBOX: Nutricionista
        checkNutricionista = new JCheckBox("Incluir Acesso ao Nutricionista (R$ 50,00)");
        checkNutricionista.setBounds(30, 220, 320, 25);
        add(checkNutricionista);

        // LABEL DE PREÇO
        JLabel labelPreco = new JLabel("Preço Total:");
        labelPreco.setBounds(30, 260, 100, 25);
        add(labelPreco);

        valorPreco = new JLabel("R$ 0,00");
        valorPreco.setBounds(150, 260, 200, 25);
        add(valorPreco);

        // Atualiza preço ao mudar tipo ou marcar nutricionista
        comboTipo.addActionListener(e -> atualizarPreco());
        checkNutricionista.addActionListener(e -> atualizarPreco());

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(150, 310, 120, 30);
        add(btnCadastrar);

        btnCadastrar.addActionListener(e -> cadastrarCliente());
    }

    private void atualizarPreco() {
        String tipoSelecionado = (String) comboTipo.getSelectedItem();
        double preco = 0.0;

        switch (tipoSelecionado) {
            case "Padrão":
                preco = 80.0;
                break;
            case "Premium":
                preco = 180.0;
                break;
            case "Deluxe":
                preco = 250.0;
                break;
        }

        if (checkNutricionista.isSelected()) {
            preco += 50.0;
        }

        valorPreco.setText("R$ " + preco);
    }

    private void cadastrarCliente() {
        try {
            int id = Integer.parseInt(campoId.getText());
            String nome = campoNome.getText();
            String email = campoEmail.getText();
            String telefone = campoTelefone.getText();
            String tipoSelecionado = (String) comboTipo.getSelectedItem();
            boolean nutricionista = checkNutricionista.isSelected();

            if (tipoSelecionado.equals("Selecione o tipo...")) {
                JOptionPane.showMessageDialog(this, "Por favor, selecione um tipo de cliente válido.");
                return;
            }

            Cliente cliente;

            switch (tipoSelecionado) {
                case "Padrão":
                    cliente = new ClientePadrao(id, nome, email, telefone, nutricionista);
                    break;
                case "Premium":
                    cliente = new ClientePremium(id, nome, email, telefone, nutricionista);
                    break;
                case "Deluxe":
                    cliente = new ClienteDeluxe(id, nome, email, telefone, nutricionista);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo inválido");
            }

            clienteService.cadastrarCliente(cliente);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
            dispose(); // fecha janela

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID deve ser um número inteiro.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + ex.getMessage());
        }
    }
}

