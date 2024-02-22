package wypozyczenie;

import ksiazka.Ksiazka;

import java.util.Objects;

public class Egzemplarz {
    private Ksiazka ksiazka;

    public enum Stan{
        WYPOZYCZONY,WOLNY
    }
    private Stan stan;

    public Egzemplarz(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
        stan = Stan.WOLNY;
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

    public Ksiazka getKsiazka() {
        return ksiazka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Egzemplarz that)) return false;
        return Objects.equals(ksiazka, that.ksiazka) && stan == that.stan;
    }

}