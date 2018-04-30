package algoritmosgulososapa;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author luana
 */

public class LerDados {

    private final String endereco;
    private final Path caminho;
    private final Charset utf8;
    private final String token;

    public LerDados(String end, String token) {
        this.endereco = end;
        caminho = Paths.get(endereco);
        utf8 = StandardCharsets.UTF_8;
        this.token = token;
    }

    public LerDados(String end) {
        this(end, "\t");
    }

    public ArrayList<Integer> lerArquivo() {
        ArrayList<Integer> aux = new ArrayList<>();
        try (BufferedReader leitor = Files.newBufferedReader(caminho, utf8)) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] t = linha.split(token); // recuperando um linha
                for (int i = 0; i < t.length; i++) {
                    aux.add(Integer.parseInt(t[i]));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro no recuperar");
        }
        return aux;
    }
}

