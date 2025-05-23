package cliente;

public class ClientePremium extends Cliente implements ServicosAdicionais {

    private boolean incluiNutricionista;

    public ClientePremium(int id, String nome, String email, String telefone, boolean incluiNutricionista) {
        super(id, nome, email, telefone, 180.0);
        this.incluiNutricionista = incluiNutricionista;
        if (incluiNutricionista) {
            this.precoMensal += 50.0;
        }
    }

    @Override
    public void exibirInfo() {
        System.out.println("=== Cliente Premium ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Serviços: Acesso à academia + Personal Trainer");
        if (incluiNutricionista) {
            System.out.println(" + Acesso ao nutricionista");
        }
        System.out.println("Preço total: R$ " + precoMensal);
    }

    @Override
    public void acessoNutricionista() {
        if (incluiNutricionista) {
            System.out.println(nome + " tem acesso ao Nutricionista");
        } else {
            System.out.println(nome + " não tem acesso ao Nutricionista");
        }
    }

    @Override
    public void acessoAulasAdicionais() {
        System.out.println(nome + " NÃO tem aulas adicionais.");
    }

    @Override
    public String getTipo() {
        return "Premium";
    }

    public boolean isIncluiNutricionista() {
        return incluiNutricionista;
    }
}
