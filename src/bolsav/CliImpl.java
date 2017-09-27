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

/**
 * @author davi
 * @author geova
 */
public class CliImpl extends UnicastRemoteObject implements InterfaceCli{

    private List<Stock> stocks;
    private InterfaceServ server;
    private int id;
    
    /**
     * @param eee
     * @throws RemoteException
     */
    @Override
    public void echo(String eee) throws RemoteException{
        System.out.println("Echo recebido: "+eee);
    }
    
    public CliImpl(int id) throws RemoteException{
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
            server.newStock(this, stock);
        } catch (RemoteException ex) {
            Logger.getLogger(CliImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public int getId() {
        return id;
    }
    
}
