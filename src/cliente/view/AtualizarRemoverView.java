package cliente.view;

import cliente.Cliente;
import cliente.ClienteService;
import cliente.SistemaAcademia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarRemoverView extends JFrame {


    private JTextField campoId;
    private JButton btnBuscar, btnRemover;

    // Obtemos o serviço compartilhado da aplicação
    private ClienteService clienteService = SistemaAcademia.getClienteService();

    public AtualizarRemoverView() {
        setTitle("Atualizar ou Remover Cliente");
        setSize(400, 200);
        setLocationRelativeTo(null); // Centraliza a janela
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Fecha apenas essa janela

        JLabel labelId = new JLabel("ID do Cliente:");
        labelId.setBounds(30, 30, 100, 25);
        add(labelId);

        campoId = new JTextField();
        campoId.setBounds(140, 30, 200, 25);
        add(campoId);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(60, 80, 100, 30);
        add(btnBuscar);

        btnRemover = new JButton("Remover");
        btnRemover.setBounds(200, 80, 100, 30);
        add(btnRemover);

        // Quando o botão Buscar for clicado
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(campoId.getText());
                    Cliente cliente = clienteService.buscarClientePorId(id);

                    if (cliente != null) {
                        JOptionPane.showMessageDialog(null,
                                "Cliente encontrado:\n" +
                                        "ID: " + cliente.getId() + "\n" +
                                        "Nome: " + cliente.getNome() + "\n" +
                                        "Email: " + cliente.getEmail());
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.");
                }
            }
        });

        // Quando o botão Remover for clicado
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(campoId.getText());
                    boolean removido = clienteService.removerCliente(id);

                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Cliente removido com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.");
                }
            }
        });
    }
}