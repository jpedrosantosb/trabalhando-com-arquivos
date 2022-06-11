package Whiter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterBufferedWhiter {

  public static void main(String[] args) {

//    Cria/recria o arquivo: new FileWriter(path)
//    Acrescenta ao arquivo existente: new FileWriter(path, true)
    
    String[] linhas = new String[] { "Quando surge o alviverde imponente",
        "No gramado em que a luta o aguarda",
        "Sabe bem o que vem pela frente" };
    String path = "C:\\temp\\ws-eclipse\\trabalhando-com-arquivos\\criadoComJava.txt";
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
      for (String linha : linhas) {
        bw.write(linha);
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
