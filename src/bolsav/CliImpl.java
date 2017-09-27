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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geova
 */
public class CliImpl extends UnicastRemoteObject implements InterfaceCli{

    //private Registry serv;
    /**
     *
     * @param eee
     * @throws RemoteException
     */
    @Override
    public void echo(String eee) throws RemoteException{
        System.out.println("Echo recebido: "+eee);
    }
    
    public CliImpl() throws RemoteException{
        //serv = servidor;
        //servidor = (InterfaceServ) refSN.lookup("localhost/InterfaceServ");
          //  servidor.chamar("Cliente", cliente);
    }
    
}
