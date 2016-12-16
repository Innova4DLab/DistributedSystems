package com.Innova4d.DP;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * El problema de los filósofos (Esta versión causa un Deadlock).
 * @author Francisco Gutiérrez <fsalvador23@gmail.com>
 * @version 1.0
 */
public class CenaFilosofos {
	// El número de filósofos...
	private static final int NUM_FILOSOFOS = 1;
	
	/**
	 * Una prueba de los filósofos.
	 * @param args Not used
	 */
	public static void main (String[] args) {
		/*
		 *  Cada tenedor es un recurso compartido.
		 *  Los recursos compartidos en Java se definen como tipo Lock.
		 *  
		 */
		
		/* Completar codigo - Definir el tipo. */ tenedores = new ReentrantLock[NUM_FILOSOFOS];
		for (int i = 0; i < NUM_FILOSOFOS; i++) {
			tenedores[i] = new ReentrantLock();
		}
		/*
		 *  Crear un arreglo de filósofos [5] 
		 *  En cada posición del arreglo, crear un filósofo
		 *  Inicializar el Thread para cada filósofo.
		 *   
		 *  En el siguiente ejemplo se implementa un código para inicializar un Thread con un filósofo, 
		 *  realiza el código para inicializar 5 ó más filósofos.
		 *  Checar la variable NUM_FILOSOFOS.
		 */
		Filosofo filosofo = new Filosofo(0, tenedores[0], tenedores[(0+1)%NUM_FILOSOFOS]);
		new Thread(filosofo).start();
	}

}