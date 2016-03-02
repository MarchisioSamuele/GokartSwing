import java.util.Random;

/**
 * Indica un tratto della pista
 */
public class Tratto {
    private int pericolosita = 0;
    private Random random = null;

    /**
     * genera un tratto del percorso
     * @param maxPericolosita
     */
    public Tratto(int maxPericolosita){
        this.random = new Random();
        this.pericolosita = random.nextInt(maxPericolosita+1);
    }

    /**
     * @return  il danno subito dal cart in quel tratto
     */
    public int danno() {
        return random.nextInt(pericolosita+1);
    }

    public int getPericolosita() {
        return this.pericolosita;
    }
}
