import java.util.ArrayList;
    public class Playlista {
        private ArrayList<String> listaUtworow = new ArrayList<>();
        private String nazwa;

        public Playlista(String nazwa){
            this.nazwa = nazwa;
        }
//1. wyswietl utwory
        public void wyswietlUtwory() {
            System.out.println("Playlista: " + nazwa);
            for (int i = 0; i < listaUtworow.size(); i++) {
                System.out.println(listaUtworow);
            }
        }
//2. wyszukaj utwory
        public void wyszukajUtwory(String opis) {
            if(opis == null || opis.isEmpty()) {
                return;
            }
            System.out.println("Utwory zawierające opis: " + opis);
            for (int i = 0; i < listaUtworow.size(); i++) {
                if(listaUtworow.get(i).contains(opis)) {
                    System.out.println(listaUtworow.get(i));
                }
            }
        }

        public void dodajUtwor(String nazwa) {
            if(nazwa == null || nazwa.isBlank()){
                return;
            }
            if(listaUtworow.contains(nazwa)){
                return;
            }
            listaUtworow.add(nazwa);
        }

        public void usunUtwor(String nazwa) {
            listaUtworow.remove(nazwa);
        }

        public String getNazwa() {
            return nazwa;
        }

        public ArrayList<String> getListaUtworow() {
            return listaUtworow;
        }
    }
