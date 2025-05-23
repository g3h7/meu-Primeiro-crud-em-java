package cliente;

public class ClienteDeluxe extends Cliente implements ServicosAdicionais {

    private boolean incluiNutricionista;

    public ClienteDeluxe(int id, String nome, String email, String telefone, boolean incluiNutricionista) {
        super(id, nome, email, telefone, 250.0);
        this.incluiNutricionista = incluiNutricionista;
        if (incluiNutricionista) {
            this.precoMensal += 50.0;
        }
    }

    @Override
    public String getTipo() {
        return "Deluxe";
    }

    @Override
    public void exibirInfo() {
        System.out.println("=== Cliente Deluxe ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
        System.out.println("Serviços: Acesso total (academia + personal + aulas exclusivas)");
        if (incluiNutricionista) {
            System.out.println("+ Acompanhamento com nutricionista");
        }
        System.out.println("Preço total: R$ " + precoMensal);
    }

    @Override
    public void acessoNutricionista() {
        if (incluiNutricionista) {
            System.out.println(nome + " tem acompanhamento com nutricionista");
        } else {
            System.out.println(nome + " não tem acompanhamento com nutricionista");
        }
    }

    @Override
    public void acessoAulasAdicionais() {
        System.out.println(nome + " tem acesso às aulas adicionais");
    }

    public boolean isIncluiNutricionista() {
        return incluiNutricionista;
    }
}

