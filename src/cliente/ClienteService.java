package cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ClienteService() {
        this.clientes = new ArrayList<>();



    }

    // Cadastrar um novo cliente
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    // Listar todos os clientes cadastrados
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("=== Lista de Clientes ===");
            for (Cliente cliente : clientes) {
                cliente.exibirInfo();
                System.out.println("--------------------------");
            }
        }
    }

    // Atualizar informações de um cliente
    public void atualizarCliente(int id, String nome, String email, String telefone) {
        Cliente cliente = buscarClientePorId(id);

        if (cliente != null) {
            cliente.setNome(nome);
            cliente.setEmail(email);
            cliente.setTelefone(telefone);
            System.out.println("Cliente atualizado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Remover cliente pelo ID
    public boolean removerCliente(int id) {
        Cliente cliente = buscarClientePorId(id);

        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
        return false;
    }

    // Buscar cliente por ID (uso interno)
    public Cliente buscarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    // A INTENÇÃO DESSA PARTE
    //É GERAR A ID DOS CLIENTES AUTOMATICAMENTE



    }





