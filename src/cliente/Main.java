package cliente;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();

        int opcao;

        do {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Atualizar cliente");
            System.out.println("4 - Remover cliente");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner, clienteService);
                    break;
                case 2:
                    clienteService.listarClientes();
                    break;
                case 3:
                    atualizarCliente(scanner, clienteService);
                    break;
                case 4:
                    removerCliente(scanner, clienteService);
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); // Linha em branco

        } while (opcao != 5);

        scanner.close();
    }

    // Método auxiliar para cadastrar cliente
    public static void cadastrarCliente(Scanner scanner, ClienteService service) {
        System.out.print("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.println("Tipo de cliente:");
        System.out.println("1 - Padrão");
        System.out.println("2 - Premium");
        System.out.println("3 - Deluxe");
        System.out.print("Escolha o tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Deseja incluir acesso ao nutricionista? (s/n): ");
        String respNutri = scanner.nextLine().trim().toLowerCase();
        boolean incluiNutricionista = respNutri.equals("s");

        Cliente cliente;

        switch (tipo) {
            case 1:
                cliente = new ClientePadrao(id, nome, email, telefone, incluiNutricionista);
                break;
            case 2:
                cliente = new ClientePremium(id, nome, email, telefone, incluiNutricionista);
                break;
            case 3:
                cliente = new ClienteDeluxe(id, nome, email, telefone, incluiNutricionista);
                break;
            default:
                System.out.println("Tipo inválido.");
                return;
        }


        service.cadastrarCliente(cliente);
    }

    // Metodo auxiliar para atualizar cliente
    public static void atualizarCliente(Scanner scanner, ClienteService service) {
        System.out.print("Digite o ID do cliente que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo email: ");
        String email = scanner.nextLine();

        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();

        service.atualizarCliente(id, nome, email, telefone);
    }

    // Metodo auxiliar para remover cliente
    public static void removerCliente(Scanner scanner, ClienteService service) {
        System.out.print("Digite o ID do cliente que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        service.removerCliente(id);
    }
}
