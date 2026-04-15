package app;

import java.util.Scanner;
import java.io.PrintStream;

/**
 * Interface para gerenciar redirecionamento de entrada e saída
 */
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
    
    /**
     * Obtém o Scanner configurado
     */
    Scanner obterScanner();
    
    /**
     * Obtém o PrintStream configurado
     */
    PrintStream obterPrintStream();
}
