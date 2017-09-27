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
 *
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
            
            Registry refSN = LocateRegistry.getRegistry("localhost", 1099);
            CliImpl cliente = new CliImpl();
            servidor = (InterfaceServ) refSN.lookup("RefServidor");
            servidor.chamar("Cliente", cliente);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente_BolsaV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente_BolsaV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
