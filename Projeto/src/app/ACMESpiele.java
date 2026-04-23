package app;

public class ACMESpiele {
    private GerenciadorIOArquivos IO;

    public ACMESpiele() {
        // Inicializa o gerenciador de E/S e redireciona entrada/saída
        IO = new GerenciadorIOArquivos("datain.txt", "dataout.txt");
        IO.redirecionaEntrada();
        IO.redirecionaSaida();
    }

    public void executar() {
        String a = IO.getEntrada();
    }
   
}