package cliente;

public class ClienteDeluxe extends Cliente implements ServicosAdicionais {
    public ClienteDeluxe(int id, String nome, String email, String telefone) {
        super(id, nome, email, telefone);
    }

    @Override
    public void exibirInfo() {
        System.out.println("=== Cliente Deluxe ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Serviços: Acesso total (academia + personal + aulas exclusivas).");
    }

    @Override
    public void acessoNutricionista() {
        System.out.println(nome + "Tem acompanhamento com nutricionista");

    }

    @Override
    public void acessoAulasAdicionais() {
        System.out.println(nome + "Tem acesso as aulas adicionais");
    }
}
