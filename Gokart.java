import java.util.Random;

/**
 * automobile da competizione
 */
public class Gokart {
    private  int carrozzeria = 0;
    private  int maxVelocita = 0;
    private  int trattiPercorsi = 0;
    private  int giri = 0;
    private  int id = 0;
    private  static int lastId = 0;
    private Random random;

    /**
     * costruttore
     * carrozzeria: casuale tra [50,100]
     * maxVelocita: casuale tra [5,10]
     * id: assegnato automaticamente
     * lastId: si incrementa autonomamente
     */
    public Gokart() {
        this.random = new Random();
        this.carrozzeria = random.nextInt(51) + 50;
        this.maxVelocita = random.nextInt(6) + 5;
        this.id = lastId;
        lastId ++;
    }

    /**
     * @return vero se il kart può proseguire la gara, false altrimenti
     */
    public boolean isOk(){
        return (this.carrozzeria > 0);
    }

    /**
     * calcola la distanza percorsa e aggiunge il valore ai tratti percorsi
     * @return la distanza percorsa
     */
    public int move(){
        int distance = random.nextInt(maxVelocita);
        trattiPercorsi += distance;
        return distance;
    }

    /**
     * sottrae alla carrozzeria il danno subito durante i tratti percorsi
     * @param dmg il danno subito
     */
    public void danneggia(int dmg){
        this.carrozzeria -= dmg;
    }

    public int getTrattiPercorsi(){
        return this.trattiPercorsi;
    }

    public void setGiri(int giri){
        this.giri = giri;
    }

    public int getGiri(){
        return this.giri;
    }

    public int getId(){
        return this.id;
    }

    public void resetId() {
        this.lastId = 0;
    }

    /**
     * @return una stringa contenente le informazioni sul kart
     */
    public String toString(){
        String ret;
        ret= new String("tratti percorsi: "
                + this.trattiPercorsi +
                " stato carrozzeria: "
                + this.carrozzeria);

        return ret;
    }
}
