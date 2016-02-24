/**
 * contiene le varie tipologie di gare
 */
public class Races{
    private Percorso percorso;
    /**
     * metodo costruttore
     */
    public Races(int lenght, int maxPericolosita) {
        this.percorso = new Percorso(lenght, maxPericolosita);
    }

    /**
     * fa correre il cart fino a che la carrozzeria non è completamente
     * distrutta e salva i giri fatti
     * @dmg è il danno subito nel percorso
     */
    public void corsa(Gokart gokart){
        while (gokart.isOk()){
            int da = gokart.getTrattiPercorsi() % percorso.tratti.size();
            int spostamento = gokart.move();
            int a = (da + spostamento) % percorso.tratti.size();
            int dmg = percorso.danno(da, a);
            gokart.danneggia(dmg);
        }
        gokart.setGiri(gokart.getTrattiPercorsi() / percorso.tratti.size());
    }
}
