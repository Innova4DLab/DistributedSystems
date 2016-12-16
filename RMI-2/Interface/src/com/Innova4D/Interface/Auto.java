package com.Innova4D.Interface;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Auto implements Serializable {
	
	/**
	 * Serial Unique ID 
	 */
	private static final long serialVersionUID = 12L;

	private int x;
	private int y;
	private String id;
	
	public Auto(String id, int x, int y) throws RemoteException {
		super();
		this.id = id;
		this.setX(x);
		this.setY(y);
	}

	public String getId() throws RemoteException  {
		return id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
