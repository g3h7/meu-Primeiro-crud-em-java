package cliente;

public class ClientePadrao extends Cliente {

    private boolean incluiNutricionista;

    public ClientePadrao(int id, String nome, String email, String telefone, boolean incluiNutricionista) {
        super(id, nome, email, telefone, 80.0);
        this.incluiNutricionista = incluiNutricionista;
        if (incluiNutricionista) {
            this.precoMensal += 50.0;
        }
    }

    @Override
    public String getTipo() {
        return "Padrão";
    }

    public boolean isIncluiNutricionista() {
        return incluiNutricionista;
    }

    @Override
    public void exibirInfo() {
        System.out.println("=== Cliente Padrão ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("SERVIÇOS: Acesso à academia");
        if (incluiNutricionista) {
            System.out.println(" + Acesso ao nutricionista");
        }
        System.out.println("Preço total: R$ " + precoMensal);
    }
}

