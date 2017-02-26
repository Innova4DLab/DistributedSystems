package com.Innova4D.Server;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.Innova4D.Interface.Constant;

public class ServerLauncher {
	/**
	 * 
	 * @param args
	 * @throws AccessException
	 * @throws RemoteException
	 * @throws AlreadyBoundException
	 */
	public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException {
		ControlTower control = new ControlTower();
		Registry registry = LocateRegistry.createRegistry(Constant.RMI_PORT);
		registry.bind(Constant.RMI_ID, control);
		System.out.println("Control Tower (Server) has started");
	}
}
