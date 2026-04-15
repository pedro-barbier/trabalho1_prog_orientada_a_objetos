package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

/**
 * Implementação do gerenciador de E/S com redirecionamento para arquivos
 */
public class GerenciadorIOArquivos implements GerenciadorIO {
    
    private Scanner entrada;
    private PrintStream saidaPadrao;
    private final String nomeArquivoEntrada;
    private final String nomeArquivoSaida;
    
    /**
     * Construtor padrão com nomes de arquivos padrão
     */
    public GerenciadorIOArquivos() {
        this("entrada.txt", "saida.txt");
    }
    
    /**
     * Construtor com nomes customizáveis
     */
    public GerenciadorIOArquivos(String nomeArquivoEntrada, String nomeArquivoSaida) {
        this.nomeArquivoEntrada = nomeArquivoEntrada;
        this.nomeArquivoSaida = nomeArquivoSaida;
        this.entrada = new Scanner(System.in);
        this.saidaPadrao = System.out;
        
        Locale.setDefault(Locale.ENGLISH);
    }
    
    @Override
    public void redirecionaEntrada() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            entrada = new Scanner(streamEntrada);
            entrada.useLocale(Locale.ENGLISH);
        } catch (Exception e) {
            System.err.println("Erro ao redirecionar entrada: " + e.getMessage());
        }
    }
    
    @Override
    public void redirecionaSaida() {
        try {
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida);
        } catch (Exception e) {
            saidaPadrao.println("Erro ao redirecionar saída: " + e.getMessage());
        }
    }
    
    @Override
    public void restauraEntrada() {
        entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);
    }
    
    @Override
    public void restauraSaida() {
        System.setOut(saidaPadrao);
    }
    
    @Override
    public Scanner obterScanner() {
        return entrada;
    }
    
    @Override
    public PrintStream obterPrintStream() {
        return saidaPadrao;
    }
}
