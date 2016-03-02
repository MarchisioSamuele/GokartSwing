import java.util.Vector;

/**
 * E' una collezione di Tratto
 */
public class Percorso{
    protected Vector<Tratto> tratti;
    private Vector<Integer> pericolosita = null;

    /**
     * metodo costruttore
     */
    public Percorso(int lenght, int maxPericolosita){
        Tratto tratto;
        this.tratti = new Vector<>();
        this.pericolosita = new Vector<>();
        for(int i = 0; i < lenght; i++) {
            tratto = new Tratto(maxPericolosita);
            this.add(tratto);
            this.pericolosita.add(tratto.getPericolosita());
        }
    }

    /**
     * aggiunge un tratto al percorso
     * @param tratto
     */
    public void add(Tratto tratto){
        this.tratti.add(tratto);
    }

    /**
     * calcola il danno nei tratti superati dal cart
     * (estremi inclusi)
     * @param da indica il tratto di partenza
     * @param a indica il tratto di arrivo
     * @return il danno subito
     */
    public int danno(int da, int a){
        int i=da;
        int dmg=0;

        if(da<=a)
            for(;i<=a;i++)
                dmg += tratti.get(i).danno();
        else{
            int lenght = tratti.size();
            for(;i<lenght;i++)
                dmg += tratti.get(i).danno();
            for(i=0;i<=a;i++)
                dmg += tratti.get(i).danno();
        }
        return dmg;
    }

    public int getPericolosita(int i) {
        return pericolosita.get(i);
    }
}
