/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsav;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author davi
 * @author geova
 */
public class CliImpl extends UnicastRemoteObject implements InterfaceCli{

    public List<Stock> stocks;
    public InterfaceServ server;
    public long id;
    
    /**
     * @param eee
     * @throws RemoteException
     */
    @Override
    public void echo(String eee) throws RemoteException{
        System.out.println("Echo recebido: "+eee);
    }
    
    @Override
    public void notify(String event) throws RemoteException {
        JOptionPane.showMessageDialog(null, event);
    }
    
    public CliImpl(long id) throws RemoteException{
        stocks = new ArrayList();
        try {
            this.id = id;
            Registry refSN = LocateRegistry.getRegistry("localhost", 1099);
            server = (InterfaceServ) refSN.lookup("RefServidor");
            server.chamar("Cliente", this);
        } catch (NotBoundException ex) {
            Logger.getLogger(CliImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(CliImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertStock(Stock stock) {
        try {
            stocks.add(stock);
            server.newStock(this, stock, id);
        } catch (RemoteException ex) {
            Logger.getLogger(CliImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public long getId() {
        return id;
    }
    
}
