package cliente;

public class ClientePremium extends Cliente implements ServicosAdicionais {
    public ClientePremium(int id, String nome, String email, String telefone) {
        super(id, nome, email, telefone, 180.0);
    }

    @Override
    public void exibirInfo() {
        System.out.println("=== Cliente Premium ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Serviços: Acesso à academia + Personal Trainer.");
    }

    @Override
    public void acessoNutricionista() {
        System.out.println(nome + "tem acesso ao Nutricionista");

    }

    @Override
    public void acessoAulasAdicionais(){
        System.out.println(nome + "NAO tem aulas adicionais.");

    }

    @Override
    public  String getTipo(){
        return "Premium";
    }
}