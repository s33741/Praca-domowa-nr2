import java.util.ArrayList;

public class BibliotekaMuzyczna {
    private String nazwa;
    private String autor;
    private ArrayList<String> utwory = new ArrayList<>();
    private ArrayList<Playlista> playlisty = new ArrayList<>();

    public BibliotekaMuzyczna(String nazwa, String autor) {
        this.nazwa = nazwa;
        this.autor = autor;
    }
//dodaje nowy utwór do głównej listy (sprawdza czy utwór już istnieje
//używając metody contains
    public void dodajUtwor(String utwor) {
        if (!utwory.contains(utwor)) {
            utwory.add(utwor);
        }
    }
//usuwa utwór z głównej listy i ze wszystkich playlist (używa metody
//remove
    public void usunUtwor(String utwor) {
        utwory.remove(utwor);
        for (Playlista p : playlisty) {
            p.usunUtwor(utwor);
        }
    }
//wyświetla wszystkie utwory z wykorzystaniem pętli for
    public void wyswietlUtwory() {
        for (String u : utwory) {
            System.out.println(u);
        }
    }
//wykorzystaj pętle i znajdź (metoda filter ) do znalezienia
//utworów zawierających podaną frazę
    public void wyszukajUtwory(String tekst) {
        if(tekst == null || tekst.isEmpty()) {
            return;
        }
        for (String u : utwory) {
            if (u.contains(tekst)) {
                System.out.println(u);
            }
        }
    }
//tworzy nową playlistę (sprawdza istnienie używając pętli)
    public void utworzPlayliste(String nazwa) {
        if (znajdzPlayliste(nazwa) == null) {
            playlisty.add(new Playlista(nazwa));
        }
    }
//pomocnicza metoda znajdująca playlistę po nazwie (używa
//pętli)
    public Playlista znajdzPlayliste(String nazwa) {
        for (Playlista p : playlisty) {
            if (p.getNazwa().equals(nazwa)) {
                return p;
            }
        }
        return null;
    }
//dodaje utwór do konkretnej playlisty
    public void dodajUtworDoPlaylisty(String utwor, String nazwaPlaylisty) {
        if (!utwory.contains(utwor)) return;
        Playlista p = znajdzPlayliste(nazwaPlaylisty);
        if (p != null) {
            p.dodajUtwor(utwor);
        }
    }
//wyświetla zawartość playlisty
    public void wyswietlPlayliste(String nazwa) {
        Playlista p = znajdzPlayliste(nazwa);
        if (p != null) {
            p.wyswietlUtwory();
        }
    }
//wyświetla listę wszystkich playlist używając pętli for-each
    public void wyswietlWszystkiePlaylisty() {
        for (Playlista p : playlisty) {
            System.out.println("Playlista: " + p.getNazwa());
        }
    }

    public int getLiczbaUtworow() {
        return utwory.size();
    }

    public int getLiczbaPlaylist() {
        return playlisty.size();
    }
}
