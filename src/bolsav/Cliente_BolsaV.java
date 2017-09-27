/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsav;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author davi
 * @author geova
 */
public class Cliente_BolsaV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfaceServ servidor = null;
        try {
            // TODO code application logic here
            CliImpl cliente = new CliImpl(1);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Client_BolsaV(cliente).setVisible(true);
                }
            });
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente_BolsaV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
