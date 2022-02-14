package pl.coderslab;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            case "add" : tab = add(tab) ; break;
            case "remove" : tab = remove(tab); break;
            case "list" : list(tab); break;
            default: System.out.println("Wybierz tylko opcje z listy");
        }
            System.out.println(ConsoleColors.BLUE + "Wybierz kolejną czynność:" + ConsoleColors.RESET);
        wybranaOpcja = skanujOpcje.next();
        }
        // exit();

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
    // metoda dodająca zadania do tablicy
    public static String[][] add(String[][] tab) {
        tab = Arrays.copyOf(tab, tab.length + 1);
        tab[tab.length - 1] = new String[3];

        System.out.println("Podaj opis zadania:");
        Scanner scan = new Scanner(System.in);
        tab[tab.length - 1][0] = scan.nextLine();
        System.out.println("Podaj date wykonania zadania:");
        Scanner scan1 = new Scanner(System.in);
        tab[tab.length - 1][1] = scan1.nextLine();;
        System.out.println("Czy to zadanie jest ważne [podaj true/false]:");
        Scanner scan2 = new Scanner(System.in);
        tab[tab.length - 1][2] = scan2.nextLine();

        return tab;
    }
// metoda usuwająca zadania z tablicy łącznie z obsługą "wyjątków"
    public static String[][] remove(String[][] tab){
        System.out.println("Podaj pozycję do usunięcia: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()){
            System.out.println("Podaj prawidłową wartość liczbową");
            scan.next();
        }
        int pozycja = scan.nextInt();
        while (pozycja < 0 || pozycja > tab.length){
            System.out.println("Podaj liczbę z zakresu 0-" + (tab.length-1));
            pozycja = scan.nextInt();
        }

        String[][] remove = new String[tab.length-1][3];
        System.arraycopy(tab, 0,remove,0,pozycja);
        System.arraycopy(tab, pozycja+1, remove, pozycja, tab.length - pozycja -1);
        System.out.println("Zadanie usunięto");
        return remove;
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




