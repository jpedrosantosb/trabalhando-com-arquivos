package Pastas;

import java.io.File;

public class ManipulandoPastasComFile {

  public static void main(String[] args) {

    File path = new File("C:\\temp");
    // APENAS PASTAS
    File[] pastas = path.listFiles(File::isDirectory);
    System.out.println("PASTAS:");
    for (File pasta : pastas) {
      System.out.println(pasta);
    }
    // APENAS ARQUIVOS
    File[] arquivos = path.listFiles(File::isFile);
    System.out.println("ARQUIVOS:");
    for (File arquivo : arquivos) {
      System.out.println(arquivo);
    }
    // CRIA PASTA DO DIRETORIO
    boolean criada = new File("C:\\temp" + "\\pastaCriada").mkdir();
    System.out.println("Diretório criado com sucesso: " + criada);
  }
}
