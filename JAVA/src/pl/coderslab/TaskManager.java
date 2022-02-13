package pl.coderslab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) {
        // wyświtlenie opcji do wyboru
        desription();

        // tworzenie tablicy dwuwymiarowej
        Path sciezka = Paths.get("tasks.csv");
        Scanner scan = null;
        try {
            scan = new Scanner(sciezka);
        } catch (IOException e) {
            System.out.println("Plik nie istnieje");;
        }

        int line = 0; // ilość lini w pliku tasks;
        String data = "";
        while (scan.hasNextLine()) {
            scan.nextLine();
            line++;
        }
        String[][] tab = new String[line][3];

        // wpisywanie danych z pliku csv do tablicy dwuwymiarowej
        try {
            tabZpliku(tab);
        }
        catch (IOException e){
            System.out.println("Plik nie istnieje!");
        }
        // użytkownik wybiera jaką operację chce wykonać
        System.out.println(ConsoleColors.BLUE + "Wybierz jedną z dostępnych opcji:" + ConsoleColors.RESET);
        Scanner skanujOpcje = new Scanner(System.in);
        String wybranaOpcja = skanujOpcje.next();
        while (!wybranaOpcja.equals("exit")){
        switch (wybranaOpcja){
            case "add" : add(tab); break;
            //case remove: ;
            case "list" : list(tab); break;
        }
            System.out.println(ConsoleColors.BLUE + "Wybierz kolejną czynność:" + ConsoleColors.RESET);
        wybranaOpcja = skanujOpcje.next();
        }




    }

// metoda służąca wyświetlainu opcji do wyboru
    public static void desription(){
        System.out.println(ConsoleColors.BLUE +"Program posiada poniższe funkcjonalności:");
        String[] opcje = new String[] {
                "add - dodaj zadania do realizacji",
                "remove - usuń zdanie",
                "list - wyświetl zadania do realizacji",
                "exit - zapisz i zamknij program"
        };
        for (String s : opcje) {
            System.out.println(ConsoleColors.RESET + s);
        }
        System.out.println("");
    }
    // metoda służąca wpisywaniu danych z pliku do tablicy dwuwymiarowej
    public static String [][] tabZpliku (String[][] tab) throws IOException {
        Path sciezka = Paths.get("tasks.csv");
        Scanner scan = new Scanner(sciezka);
        int wiersz = 0;
        String data = "";
        while (scan.hasNextLine()) {
            data = scan.nextLine();
            String[] data1 = data.split(", ");
            for (int i = 0; i < data1.length; i++) {
                tab[wiersz][i] = data1[i];
            }
            wiersz++;
        }
        return tab;
    }
// metoda służąca wyświetleniu tego co jest w tabeli dwuwymiarowej
    public static void list(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print (i + ":");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println("");
        }}
    public static String[][] add(String[][] tab){
        tab = Arrays.copyOf(tab, tab.length+1);
        tab[tab.length-1] = new String[3];
        for(int i=0; i< tab.length;i++){
            for(int j=0; j<tab[i].length; j++){
                System.out.print(tab[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Podaj opis zadania:");
        Scanner zadanie = new Scanner(System.in);
        String zadanie1= zadanie.nextLine();
        tab[tab.length-1][0] = zadanie1;
        System.out.println("Podaj date wykonania zadania:");
        Scanner data = new Scanner(System.in);
        tab[tab.length-1][1] = data.nextLine();
        System.out.println("Czy to zadanie jest ważne [podaj true/false]:");
        Scanner important = new Scanner(System.in);
        tab[tab.length-1][2] = important.nextLine();
        tab[tab.length-1] = new String[3];
        for(int i=0; i< tab.length;i++){
            for(int j=0; j<tab[i].length; j++){
                System.out.print(tab[i][j] + " ");
            }
            System.out.println("");
        }
        return tab;
    }


}
   /* //Metoda służąca wczytywaniu danych z pliku do dwuwymiarowej tablicy
    public static String[][] tasks() {


    public static void EXIT(String[][] tab) {
        Path sciezka = Paths.get("tasks.csv");
String [] jedenWymiar = new String[tab.length];

*//*

*//*

    }
}*/




