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
        setLocationRelativeTo(null); // Centraliza a janela
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false); // Impede digitação
        JScrollPane scroll = new JScrollPane(areaTexto); // Barra de rolagem
        scroll.setBounds(20,40,440,250);
        add(scroll, BorderLayout.CENTER); // Corrigido: precisa usar BorderLayout

        carregarClientes();
    }

    private void carregarClientes(){
        areaTexto.setText(""); // Limpa o conteúdo antes de listar

        List<Cliente> lista = clienteService.getClientes();

        if(lista.isEmpty()){
            areaTexto.append("NENHUM CLIENTE CADASTRADO. \n");
        } else {
            for (Cliente c : lista){
                areaTexto.append("ID: " + c.getId() + "\n");
                areaTexto.append("Nome: " + c.getNome() + "\n");
                areaTexto.append("Email: " + c.getEmail() + "\n");
                areaTexto.append("Telefone: " + c.getTelefone() + "\n");

                // Verifica o tipo de cliente e mostra plano + preço
                if (c instanceof ClientePadrao){
                    areaTexto.append("Plano: Padrão - ACESSO A ACADEMIA\n");
                    areaTexto.append("Preço Mensal: R$ 80\n");
                } else if (c instanceof ClientePremium) {
                    areaTexto.append("Plano: Premium - ACADEMIA + PERSONAL\n");
                    areaTexto.append("Preço Mensal: R$ 180\n");
                } else if (c instanceof ClienteDeluxe) {
                    areaTexto.append("Plano: Deluxe - ACADEMIA + PERSONAL + AULAS EXCLUSIVAS\n");
                    areaTexto.append("Preço Mensal: R$ 250\n");
                }

                areaTexto.append("-------------------------------------------------------------\n\n");
            }
        }
    }
}
