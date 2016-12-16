package com.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.interf.test.TestRemote;

/**
 * @author   Francisco Gutiérrez <fsalvador23@gmail.com>
 * @version  0.1
 * @since    2015-01-10
 */
public class TestClient {

	public static final String RMI_ID = "TestRMI";
	/**
	 * Define el puerto en donde se encuentra el servidor.
	 */
	public static final int RMI_PORT = 8080;

	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", RMI_PORT);
		TestRemote remote = (TestRemote) registry.lookup(RMI_ID);
		System.out.println(remote.test("123"));
		System.out.println(remote.test("test"));
	}

}
