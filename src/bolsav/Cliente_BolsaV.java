package bolsav;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe principal que cria um cliente e executa a interface gráfica
 *
 * @author Davi Pereira Neto
 * @author Geovana Franco Santos
 */
public class Cliente_BolsaV {

    /**
     * Método principal
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //cria um novo cliente com um id baseado no tempo de sistema, garantindo que os clientes possuem ids diferentes
            CliImpl cliente = new CliImpl(System.nanoTime());
            //invoca a interface gráfica
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Client_BolsaV(cliente).setVisible(true);
                }
            });
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente_BolsaV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
