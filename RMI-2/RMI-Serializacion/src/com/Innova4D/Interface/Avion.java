package com.Innova4D.Interface;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * 
 * @author Francisco Gutiérrez <fsalvador23@gmail.com>
 * 
 * Los aviones van a formar parte de nuestra interfaz,
 * por eso es importante declarar los objetos dentro del mismo paquete.
 * 
 * Aquí vamos a experimentar con Marshalling, que es básicamente serialización de objetos.
 * 
 * Hacer Marshalling significa grabar el estado de un objeto y su codebase.
 * así cuando un objeto es "UnMarshalled" el objeto es exactamente el mismo.
 */
public class Avion implements Serializable {
	
	/**
	 * Serial Unique ID 
	 */
	private static final long serialVersionUID = 42L;

	private int x;
	private int y;
	private String id;
	
	public Avion(String id, int x, int y) throws RemoteException {
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
