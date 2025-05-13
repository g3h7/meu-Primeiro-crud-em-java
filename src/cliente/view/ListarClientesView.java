package cliente.view;

import cliente.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListarClientesView extends JFrame {

    private JTextArea areaTexto;

    private ClienteService clienteService = SistemaAcademia.getClienteService();

    public ListarClientesView(){
        setTitle("Listas de Cliente");
        setSize(600,500);
        setLocationRelativeTo(null);//  ISSO VAI CENTRALIZAR A JANELA
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false); //impede o usuario DIGITAR AQUI

        JScrollPane scroll = new JScrollPane(areaTexto); //ROLAGEM DE TEXTO
        scroll.setBounds(20,40,440,250);
        add(scroll);

        // ABRIR JANELA E MOSTRAR CLIENTES
        carregarClientes();
    }
    private void carregarClientes(){
        areaTexto.setText("");

        List<Cliente> lista = clienteService.getClientes();

        if(lista.isEmpty()){
            areaTexto.append("NENHUM CLIENTE CADASTRADO. \n");
        }else {
            for (Cliente c : lista){
                areaTexto.append("ID: "+ c.getId() + "\n");
                areaTexto.append("Nome: "+ c.getNome() + "\n");
                areaTexto.append("Email: "+ c.getEmail() + "\n");
                areaTexto.append("Telefone: "+ c.getTelefone() + "\n");

                if (c instanceof ClientePadrao){
                    areaTexto.append("plano Padrão - ACESSO A ACADEMIA\n");
                } else if (c instanceof ClientePremium) {
                    areaTexto.append("Plano Premium - ACADEMIA + PERSONAL\n ");
                } else if (c instanceof ClienteDeluxe) {
                    areaTexto.append("Plano Deluxe - ACADEMIA + PERSONAL + AULAS EXCLUSIVAS\n");
                }

                areaTexto.append("\n-------------------------------------------------------------------------\n");
            }
        }

    }
}
