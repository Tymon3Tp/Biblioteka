import ksiazka.Autor;
import ksiazka.Gatunek;
import ksiazka.Ksiazka;
import wypozyczenie.Egzemplarz;
import wypozyczenie.Wypozyczenie;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteka {
    ArrayList<Ksiazka> ksiazki = new ArrayList<>();
    ArrayList<Egzemplarz> egzemplarze = new ArrayList<>();
    ArrayList<Wypozyczenie> wypozyczenia = new ArrayList<>();
    public Ksiazka wyszukajKsiazke(String tytul){
        for (Ksiazka ksiazka: ksiazki){
            if(ksiazka.getTytul().equals(tytul)){
                return ksiazka;
            }
        }
    }
    public ArrayList<Ksiazka> wyszukajKsiazke(Autor autor){
        for (Ksiazka ksiazka: ksiazki){
            if(ksiazka.getAutor().equals(autor)){
                ksiazki.add(ksiazka);
            }
        }
    }
    public ArrayList<Ksiazka> wyszukajKsiazke(Gatunek gatunek){
        for (Ksiazka ksiazka: ksiazki){
            if(ksiazka.getGatunek().equals(gatunek)){
                ksiazki.add(ksiazka);
            }
        }
        return null;
    }
    public Egzemplarz wyszukajWolnyEgzemplarz(){
        for (Egzemplarz e: egzemplarze){
            if(e.getKsiazka().equals(ksiazki) && e.getStan() == Egzemplarz.Stan.WOLNY){
                return e;
            }
        }
    }
    Scanner scanner = new Scanner(System.in);
    public void dodajKsiazke(){
        // dodaje nowa ksiazke (przeprowadza dialog z uzytkownikiem)
        // jesli ksiazka nie istnieje najpierw ja tworzy
        System.out.println("Podaj nazwe ksiazki");
        String tytulskiazki = scanner.next();
        System.out.println("Podaj gatunek ksiazki (Dostępne gatunki: KRYMINAŁ,POPULARNO_NAUKOWE,FANTASTYKA,BIOGRAFIA");
        Gatunek gatunek = switch (scanner.next()){
            case "Kryminal" -> Gatunek.KRYMINAŁ;
            case "Popularno naukowe" +
                    "" -> Gatunek.POPULARNO_NAUKOWE;
            case "Fantastyka" -> Gatunek.FANTASTYKA;
            case "Biografia" -> Gatunek.BIOGRAFIA;
            default -> null;

        };
        System.out.println("Podaj rok wydania ksiazki");
        int rok_wydania = scanner.nextInt();



    }

    public Autor stworzAutora(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie autora");
        String imieautora = scanner.next();
        System.out.println("Podaj nazwisko autora");
        String naziwskoautora = scanner.next();
        System.out.println("Podaj rok urodzenia autora");
        int rokurodzeniaautora = scanner.nextInt();
        System.out.println("Podaj date smierci autora (jesli nie zyje)");
        int datasmierciautora = scanner.nextInt();
        Autor newautor = new Autor(imieautora,naziwskoautora,rokurodzeniaautora,datasmierciautora);
        return newautor;
    }

}