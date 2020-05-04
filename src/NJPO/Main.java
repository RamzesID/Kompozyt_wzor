package NJPO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ///Struktura
        Catalog disk = new Catalog("D:");
        Catalog folder1 = new Catalog("Folder1");
        Catalog folder2 = new Catalog("Folder2");
        Catalog folder3 = new Catalog("Folder3");

        folder1.add(new File("Plik1",".txt"));
        folder1.add(new File("Plik2",".txt"));
        folder1.add(folder3);
        folder2.add(new File("Plik3",".txt"));
        folder3.add(new File("Plik4",".txt"));

        disk.add(folder1);
        disk.add(folder2);

        Catalog pom = disk;

        Scanner scanner = new Scanner(System.in);
        String nameCat = "D:";
        boolean loop = true;

        ///Konsola
        while (loop) {
            System.out.print(nameCat + ">");
            String line = scanner.nextLine();
            ///CD
            if (line.substring(0, 2).equals("cd")) {
                if(line.substring(2).equals("..")) {
                    if(pom.name.equals("D:")) System.out.println("Nie mozna sie juz cofnac");
                    else {
                        pom = pom.parent;
                        nameCat = pom.name;
                    }
                }else{
                    try {
                        pom = (Catalog) pom.cd(line.substring(3));
                    }catch (ClassCastException e){
                        System.out.println("Nie mozna przejsc do pliku");
                    }
                    nameCat = pom.name;
                }
            }
            ///DIR
            if (line.substring(0, 3).equals("dir")) pom.dir();
            ///Exit
            if (line.equals("exit")) loop = false;
        }
    }
}
