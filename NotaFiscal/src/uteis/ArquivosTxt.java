package uteis;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArquivosTxt {

    public ArquivosTxt() {
    }

    public void gerarArquiosTxt(StringBuilder texto) {

        Writer writer = null;

        try {

            File arquivo = new File(gerarNomeArquivo());
            FileOutputStream fos = new FileOutputStream(arquivo);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            writer = new BufferedWriter(osw);
            writer.write(texto.toString());
            writer.close();

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public String gerarNomeArquivo() {
        return "Notas_Fiscais_" + System.currentTimeMillis() + ".txt";
    }


    public List<List<String>> lerArquivosTxt() throws IOException {

        List<List<String>> tt = new ArrayList<>();
        List<String> linhasDoArQuivo = Arrays.stream(Files.lines(Path.of("Teste.txt")).toArray(String[]::new)).collect(Collectors.toList());

        for (String linha: linhasDoArQuivo) {
            List<String> listaDoResult = List.of(linha.split(","));
            tt.add(listaDoResult);
        }
        //System.out.println(tt);
        return tt;
    }

}
