package app;

public class ACMESpiele {
    
    private GerenciadorIO gerenciadorIO;

    public ACMESpiele() {
        // Inicializa o gerenciador de E/S e redireciona entrada/saída
        gerenciadorIO = new GerenciadorIOArquivos("datain.txt", "dataout.txt");
        gerenciadorIO.redirecionaEntrada();
        gerenciadorIO.redirecionaSaida();
    }

    public void executar() {
        System.out.println("bleh");
    }
   
    // public GerenciadorIO obterGerenciadorIO() {
    //     return gerenciadorIO;
    // }
}