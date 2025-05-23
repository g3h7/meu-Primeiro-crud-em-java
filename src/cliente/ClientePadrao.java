package cliente;

public class ClientePadrao extends Cliente {

    public ClientePadrao(int id, String nome, String email, String telefone){
        super (id, nome, email, telefone, 80.0);

    }

    @Override
    public String getTipo(){
        return "Padrâo";
    }



    @Override
    public void exibirInfo(){
        System.out.println("===Cliente padrão===");
        System.out.println("ID:" + id );
        System.out.println("Nome: "+ nome);
        System.out.println("Email: "+ email);
        System.out.println("Telefone: " + telefone);
        System.out.println("SERVIÇOS : ACESSO A ACADEMIA");
    }
}
