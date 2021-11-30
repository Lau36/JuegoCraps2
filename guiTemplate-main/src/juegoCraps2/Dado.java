package juegoCraps2;

import java.util.Random;
/**
 * Class Dado generate a Randow value between 1 and 6
 * @author Laura Jaimes
 * @version v.1.0.0 date 20/11/2021
 */

public class Dado {
    private int cara;

    /**
     * Method that generate on random value to cara
     * @return number between (1,6)
     * @author Laura Jaimes
     * @version v.1.0.0 date 20/11/2021
     */
    public int getCara() {
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6)+1;
        return cara;
    }
}
