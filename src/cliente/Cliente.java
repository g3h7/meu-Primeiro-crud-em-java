package cliente;

// Classe abstrata cliente.Cliente
public abstract class Cliente {
    protected int id;
    protected String nome;
    protected String email;
    protected String telefone;

    // Construtor
    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }


    public abstract void exibirInfo();

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}

