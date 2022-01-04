package com.company.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class BanKiemPhieu {


    public static void main(String[] args) {
        try {
            ActionC obj=new ActionC();
            LocateRegistry.createRegistry(2022);
            Naming.rebind("rmi://localhost:2022/Adtrue", obj);
            System.out.println("dang cho ket noi tu client....");
        } catch (MalformedURLException | RemoteException e) {
        }
    }

}
