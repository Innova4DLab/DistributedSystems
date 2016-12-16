package com.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.interf.test.TestRemote;

/**
 * @author   Francisco Gutiérrez <fsalvador23@gmail.com>
 * @version  0.1
 * @since    2015-01-10
 */
public class ServerDefinition extends UnicastRemoteObject implements TestRemote {

	/**
	 * Identificador único de la serialización (Default).
	 */
	private static final long serialVersionUID = 1L;

	protected ServerDefinition() throws RemoteException {
		super();
	}

	@Override
	public Boolean test(String test) throws RemoteException {
		if(test.equalsIgnoreCase("test")) return true;
		return false;
	}

}
