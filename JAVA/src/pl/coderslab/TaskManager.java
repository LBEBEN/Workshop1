package pl.coderslab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args){

        // wyświtlanie opcji do wyboru na konsoli
        System.out.println(ConsoleColors.BLUE + "Wybierz co chesz zrobić:");

        String[] option = new String[]{"Add - dodawanie nowego zadania", "Remove - usuwanie zadania", "List - wypisanie wszystkich zadań", "Exit - wyjście z programu"};
        for (String s : option) {
            System.out.println(ConsoleColors.RESET + s + "\n");
        }

        // wczytywanie danych z pliky tasks.csv do tablicy
        try {
            tasks();
        }
        catch (IOException e){
            System.out.println("Oj oj coś poszło nie tak");}

        // wybór czynności do wykonania
        Scanner wybor = new Scanner(System.in);
        String choice = wybor.next();

        switch (choice){
            case "Add": Add();
            case "Remove": Remove();
            case "List": List();
            case "Exit": exit();
            default:
        }


        }

        //Metoda służąca wczytywaniu danych z pliku do dwuwymiarowej tablicy
        static String[][] tasks() throws IOException {
        Path sciezka =Paths.get("tasks.csv");
            Scanner scan = new Scanner(sciezka);

            //sprawdzam czy plik istnieje
            //if (Files.exists(sciezka)){
              //  System.out.println("jest ok");
            //}
            //else {
              //  System.out.println("coś poszło nie tak");
            //}

            int line = 0; // ilość lini w pliku tasks;
            String data = "";
            while (scan.hasNextLine()) {
              scan.nextLine();
                line ++;}

            String[][] tab = new String[line][3];

            Scanner scan2 = new Scanner(sciezka);
            int wiersz = 0;
            while (scan2.hasNextLine()){
                data = scan2.nextLine();
                String[] data1 = data.split(", ");
                for(int i =0; i < data1.length; i++){
                    tab[wiersz][i] = data1[i];
                }
                wiersz ++;
            }

           // for (int i=0; i< tab.length; i++){
             //   for (int j =0; j < tab[i].length; j++){
               //     System.out.print(tab[i][j]);
                //}
                //System.out.println("");
            //}
            return tab;
        }

    }




