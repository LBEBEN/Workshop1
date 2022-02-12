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
        // Zapisanie danych z pliku do tablicy dwuwymiarowej
        tasks();

        // wyświtlanie opcji do wyboru na konsoli
        System.out.println(ConsoleColors.BLUE + "Wybierz co chesz zrobić:");
        String[] option = new String[]{"Add - dodawanie nowego zadania", "Remove - usuwanie zadania", "List - wypisanie wszystkich zadań", "Exit - wyjście z programu"};
        for (String s : option) {
            System.out.println(ConsoleColors.RESET + s + "\n");
        }

        System.out.println("Wybierz co chcesz wykonać");

        Scanner wybor = new Scanner(System.in);
        String choice = wybor.next();
        while (!choice.equals("Exit")) {

            switch (choice) {
                //case "Add": Add();
                //case "Remove": Remove();
                case "List":
                    wyświetl(tasks());
                    break;
                default:
                    System.out.println("Wybierz polecenie z listy");
            }
            choice = wybor.next();

        }
    }

    //Metoda służąca wczytywaniu danych z pliku do dwuwymiarowej tablicy
    public static String[][] tasks() {
        Path sciezka = Paths.get("tasks.csv");
        Scanner scan = null;
        try {
            scan = new Scanner(sciezka);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //sprawdzam czy plik istnieje
        if (Files.exists(sciezka)) {
            System.out.println("");
        } else {
            System.out.println("coś poszło nie tak");
        }

        int line = 0; // ilość lini w pliku tasks;
        String data = "";
        while (scan.hasNextLine()) {
            scan.nextLine();
            line++;
        }

        String[][] tab = new String[line][3];

        Scanner scan2 = null;
        try {
            scan2 = new Scanner(sciezka);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int wiersz = 0;
        while (scan2.hasNextLine()) {
            data = scan2.nextLine();
            String[] data1 = data.split(", ");
            for (int i = 0; i < data1.length; i++) {
                tab[wiersz][i] = data1[i];
            }
            wiersz++;
        }
        return tab;
    }

    // Metoda wyświetająca zawartość pliku na konsoli
    public static void wyświetl(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void EXIT(String[][] tab) {
        Path sciezka = Paths.get("tasks.csv");


        try {
            Files.write(sciezka, tab);
        } catch (IOException e) {
            System.out.println("Plik nie istnieje");
        }

    }
}




