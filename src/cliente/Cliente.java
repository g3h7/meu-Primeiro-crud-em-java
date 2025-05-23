package cliente;

// Classe abstrata cliente.Cliente
public abstract class Cliente {
    protected int id;
    protected String nome;
    protected String email;
    protected String telefone;
    protected Double precoMensal;

    // Construtor
    public Cliente(int id, String nome, String email, String telefone, double precoMensal) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.precoMensal = precoMensal;
    }

    public abstract String getTipo ();
    public abstract void exibirInfo();

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public Double getPrecoMensal(){ return precoMensal;}

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }


    @Override
    public String toString() {
        return "ID: " + id +
                "\nNome: " + nome +
                "\nEmail: " + email +
                "\nTelefone: " + telefone +
                "\nTipo: " + getTipo() +
                "\nPreço Mensal: R$ " + precoMensal;
    }
}