package cliente;

public class SistemaAcademia {
    private static ClienteService clienteService = new ClienteService();

    public static ClienteService getClienteService(){
        return clienteService;
    }
}
