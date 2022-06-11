package Exercicio.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Exercicio.entidade.Produto;

public class Programa {

  /*
   * Programa que ler o caminho de um arquivo .txt contendo os dados
   * de itens vendidos. Cada item possui um nome, preço unitário e quantidade,
   * separados por vírgula. É gerado então um novo arquivo chamado
   * "summary.txt", localizado em uma subpasta chamada "out" a partir da pasta
   * original do arquivo de origem, contendo apenas o nome e o valor total para
   * aquele item (preço unitário multiplicado pela quantidade)
   */
  
  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    List<Produto> list = new ArrayList<>();
    //C:\\temp\\ws-eclipse\\trabalhando-com-arquivos\\exercicio.txt
    System.out.println("Digite o caminho do arquivo: ");
    String sourceFileStr = sc.nextLine();

    File sourceFile = new File(sourceFileStr);
    String sourceFolderStr = sourceFile.getParent();

    boolean sucesso = new File(sourceFolderStr + "\\out").mkdir();
    System.out.println(sucesso);
    
    String targetFileStr = sourceFolderStr + "\\out\\summary.txt";

    try (
        BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

      String itemCsv = br.readLine();
      while (itemCsv != null) {

        String[] fields = itemCsv.split(",");
        String nome = fields[0];
        double preco = Double.parseDouble(fields[1]);
        int quantidade = Integer.parseInt(fields[2]);

        list.add(new Produto(nome, preco, quantidade));

        itemCsv = br.readLine();
      }

      try (
          BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

        for (Produto item : list) {
          bw.write(item.getNome() + ","
              + String.format("%.2f", item.total()));
          bw.newLine();
        }

        System.out.println(targetFileStr + " CRIADO!");

      } catch (IOException e) {
        System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
      }

    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }

    sc.close();

  }

}
