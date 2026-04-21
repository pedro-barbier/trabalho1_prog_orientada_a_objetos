package app;

// Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class GerenciadorIOArquivos implements GerenciadorIO {
    // Atributos para redirecionamento de E/S
    private Scanner entrada = new Scanner(System.in);;
    private PrintStream saidaPadrao = System.out;
    private final String nomeArquivoEntrada;
    private final String nomeArquivoSaida;
    
    public GerenciadorIOArquivos(String nomeArquivoEntrada, String nomeArquivoSaida) {
        this.nomeArquivoEntrada = nomeArquivoEntrada;
        this.nomeArquivoSaida = nomeArquivoSaida;
    }
    

    // Redireciona Entrada de dados para arquivos em vez de teclado
    // Chame este metodo para redirecionar a leitura de dados para arquivos
    @Override
    public void redirecionaEntrada() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
            entrada.useLocale(Locale.ENGLISH);
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH);   // Ajusta para leitura para ponto decimal
    }
    
    // Redireciona Saida de dados para arquivos em vez da tela (terminal)
    // Chame este metodo para redirecionar a escrita de dados para arquivos
    @Override
    public void redirecionaSaida() {
        try {
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
    }
    
    // Restaura Entrada padrao para o teclado
    // Chame este metodo para retornar a leitura de dados para o teclado
    @Override
    public void restauraEntrada() {
        entrada = new Scanner(System.in);
    }
    
    // Restaura Saida padrao para a tela (terminal)
    // Chame este metodo para retornar a escrita de dados para a tela
    @Override
    public void restauraSaida() {
        System.setOut(saidaPadrao);
    }
}
