package wypozyczenie;

import java.time.Duration;
import java.time.LocalDate;

public class Wypozyczenie {

    private static final int DLUGOSC_WYPOZYCZENIA = 30;
    private static final double KARA = 0.1;
    private Egzemplarz egzemplarz;
    private LocalDate dataWypozyczenia;
    private LocalDate dataOddania;
    private LocalDate przewidywanaDataOddanial;

    public Wypozyczenie(Egzemplarz egzemplarz) {
        this.egzemplarz = egzemplarz;
        egzemplarz.setStan(Egzemplarz.Stan.WYPOZYCZONY);
        dataWypozyczenia = LocalDate.now();
        przewidywanaDataOddanial = dataWypozyczenia.plusDays(DLUGOSC_WYPOZYCZENIA);
        dataOddania = null;

    }
    public double oddaj(){
        egzemplarz.setStan(Egzemplarz.Stan.WOLNY);
        dataOddania=LocalDate.now();
        if(przewidywanaDataOddanial.isBefore(dataOddania)){
            long liczbaDni = Duration.between(dataOddania,przewidywanaDataOddanial).toDays();
            return liczbaDni*KARA;
        }
        return 0;
    }

    public LocalDate prelonguj(){
        przewidywanaDataOddanial = przewidywanaDataOddanial.plusDays(DLUGOSC_WYPOZYCZENIA);
        return przewidywanaDataOddanial;
    }
}