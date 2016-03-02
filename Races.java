import java.util.Vector;

/**
 * contiene le varie tipologie di gare
 */
public class Races{
    private Percorso percorso;
    private Vector<Integer> vincitori = null;
    private int giriMax = 1;
    /**
     * metodo costruttore
     */
    public Races(int lenght, int maxPericolosita) {
        this.percorso = new Percorso(lenght, maxPericolosita);
        this.vincitori = new Vector<>();
        Gokart gokart = new Gokart();
        gokart.resetId();
    }

    /**
     * fa correre il cart fino a che la carrozzeria non è completamente
     * distrutta e salva i giri fatti
     * @dmg è il danno subito nel percorso
     */
    public String corsa(Gokart gokart){
        while (gokart.isOk()){
            int da = gokart.getTrattiPercorsi() % percorso.tratti.size();
            int spostamento = gokart.move();
            int a = (da + spostamento) % percorso.tratti.size();
            int dmg = percorso.danno(da, a);
            gokart.danneggia(dmg);
        }
        gokart.setGiri(gokart.getTrattiPercorsi() / percorso.tratti.size());

        // Controllo se il kart ha battuto i precedenti
        if(gokart.getGiri() > giriMax) {
            this.vincitori.clear();
            this.vincitori.add(gokart.getId());
            this.giriMax = gokart.getGiri();
        } else if(gokart.getGiri() == giriMax) {
            this.vincitori.add(gokart.getId());
        }

        return "• Il gokart numero " + gokart.getId() + " ha eseguito "
                + gokart.getGiri() + " giri;\n";
    }

    public String vincitori() {
        if(vincitori.size() == 0)
            return "---\nNessun gokart ha completato almeno un giro.";
        else if(vincitori.size() == 1)
            return "---\nIl vincitore è il gokart numero " + vincitori.get(0) + ".";
        else {
            String ret = "";
            int i = 0;
            ret = "---\nI gokart vincitori sono i gokart numero ";
            for (i = 0; i < vincitori.size()-1; i++) {
                ret += vincitori.get(i);
                ret += ", ";

            }
            ret += vincitori.get(i);
            ret += ".";

            return ret;
        }
    }

    public int getPericolosita(int i) {
        return percorso.getPericolosita(i);
    }
}
