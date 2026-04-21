package app;

public interface GerenciadorIO {
    
    /**
     * Redireciona entrada de dados para arquivo
     */
    void redirecionaEntrada();
    
    /**
     * Redireciona saída de dados para arquivo
     */
    void redirecionaSaida();
    
    /**
     * Restaura entrada padrão (teclado)
     */
    void restauraEntrada();
    
    /**
     * Restaura saída padrão (console)
     */
    void restauraSaida();
    
}
