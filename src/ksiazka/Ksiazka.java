package ksiazka;

public class Ksiazka {
    private final String tytul;
    private final Gatunek gatunek;
    private final Autor autor;
    private final int rokWydania;

    public Ksiazka(String tytul, Gatunek gatunek, Autor autor, int rokWydania) {
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.autor = autor;
        this.rokWydania = rokWydania;
    }

    public String getTytul() {
        return tytul;
    }

    public Gatunek getGatunek() {
        return gatunek;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    @Override
    public String toString(){
        return String.format("%s,%s",tytul,autor.toString());
    }
}
