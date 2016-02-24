import java.util.Vector;

/**
 * E' una collezione di Gokart
 */
public class Partecipanti {
    protected Vector<Gokart> partecipanti;

    /**
     * costruttore
     */
    public Partecipanti(){
        this.partecipanti = new Vector<>();
    }

    /**
     * aggiunge un nuovo gokart al vettore
     */
    public void add(){
        Gokart gokart = new Gokart();
        this.partecipanti.add(gokart);
    }
}
