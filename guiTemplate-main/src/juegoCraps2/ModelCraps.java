package juegoCraps2;

/**
 * ModelCraps apply craps rules.
 * if status = 1 Natural winner
 * is status = 2 Craps looser
 * if status = 3 Establish Punto
 * if status = 4 Punto winner
 * if status = 5 Punto looser
 * @author Laura Jaimes
 * @version v.1.0.0 dato 01/12/21
 */
public class ModelCraps {
    private Dado dado1, dado2;
    private int tiro, punto, estado, flag;
    private String estadoToString;
    private int[] caras;

    /**
     * Class Constructor
     */
    public ModelCraps(){
        dado1 = new Dado();
        dado2 = new Dado();
        caras = new int[2];
        flag = 0;
    }

    /**
     * Establish the tiro value according to each dice
     */
    public void calcularTiro(){
        caras[0]= dado1.getCara();
        caras[1] = dado2.getCara();
        tiro = caras[0] + caras[1];
    }

    /**
     * Establish game state to estado attribute value
     */
    public void determinarJuego(){
        if (flag==0){
            if(tiro==7 || tiro==11){
                estado = 1;
            }else{
                if(tiro==3 || tiro==2 || tiro==12){
                    estado = 2;
                }else{
                    estado=3;
                    punto = tiro;
                    flag = 1;

                }
            }
        }else{
            //ronda punto
            rondaPunto();
        }
    }

    /**
     * Establish game state acording to estado attribute value two last one
     * if status = 4 Punto winner
     * if status = 5 Punto looser
     */
    private void rondaPunto() {
        if (tiro==punto){
            estado = 4;
            flag = 0;
        }else{
            if(tiro==7){
                estado=5;
                flag=0;
            }
        }
    }

    public int getTiro() {
        return tiro;
    }

    public int getPunto() {
        return punto;
    }

    /**
     * Establish message game state according to estado attribute value
     * @return message for the View class
     */
    public String getEstadoToString() {
        switch (estado){
            case 1: estadoToString="Sacaste Natural, has ganado omg";
                    break;
            case 2: estadoToString="Sacaste Craps, has perdido :(";
                break;
            case 3: estadoToString="Estableciste punto en"+punto+ "Debes seguir lanzando ;)"+"\n pero si sacas 7 antes que"+punto+"perderas";
                break;
            case 4: estadoToString="Volviste a sacar"+punto+ ", has ganado omg";
                break;
            case 5: estadoToString="Sacaste 7 antes que"+punto+", has perdido :(";
                break;
        }
        return estadoToString;
    }

    /**
     * Establish two face of the dice
     * @return face of th dice
     */
    public int[] getCaras() {
        return caras;
    }
}

