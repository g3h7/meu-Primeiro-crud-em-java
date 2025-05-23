package cliente.view;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal  extends JFrame {
    public MenuPrincipal(){
        setTitle("Protótipo - CRUD");
        setSize(400,300);
        setLocationRelativeTo(null); // isso CENTRALIZA OK
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnCriar = new JButton("Cadastrar Cliente");
        btnCriar.setBounds(100,30,200,30);
        add(btnCriar);

        JButton btnListar = new JButton("Listar CLientes");
        btnListar.setBounds(100,70,200,30);
        add(btnListar);

        JButton btnAtualizar = new JButton("Atualizar / Remover cadastro");
        btnAtualizar.setBounds(100,110,200,30);
        add(btnAtualizar);

        JButton btnSair = new JButton("SAIR");
        btnSair.setBounds(100,150,200,30);
        add(btnSair);

        //AÇÕES DO BOTÃO

        btnCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastrarClienteView().setVisible(true);

            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarClientesView().setVisible(true);
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AtualizarRemoverView().setVisible(true);
            }
        });
        btnSair.addActionListener(e -> System.exit(0));

    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(()-> {
            new MenuPrincipal().setVisible(true);
        });
    }

}