package com.Innova4d.DP;
import java.util.Random;
import java.util.concurrent.locks.Lock;
/**
 * La clase Filosofo que utiliza Runnable para poder ser implementada por un thread.
 * @author Francisco Gutiérrez <fsalvador23@gmail.com>
 * @version 1.0
 */
class Filosofo implements /* completar codigo */ {
	// Tiempo en que come un filósofo
	private Random numGenerator = new Random();
	// El Id del filosofo
	private int id;

	/* 
	 * Definir los cubiertos del filosofo.
	 * En Java los recursos compartidos se definen como Locks.
	 */
	private /* completar codigo */ cubiertoIzquierdo;
	private /* completar codigo */ cubiertoDerecho;

	/**
	 * El constructor del filósofto
	 * @param id el id del filósofo
	 * @param cubiertoIzquierdo cubierto izquierdo
	 * @param cubiertoDerecho cubierto derecho
	 */
	public Filosofo (int id, Lock cubiertoIzquierdo, Lock cubiertoDerecho) {
		this.id = id;
		this.cubiertoIzquierdo = cubiertoIzquierdo;
		this.cubiertoDerecho = cubiertoDerecho;
	}

	/**
	 * Ejecuta el thread, piensa, levanta cubiertos, come.
	 */
	public void run() {
		try {
			while (true) {
				piensa();
				levantaCubiertoIzquierdo();
				levantaCubiertoDerecho();
				come();
				bajaCubiertos();
			}
		} catch (InterruptedException e) {
			System.out.println("El Filósofo " + id + " fue interrumpido.\n");			
		}
	}

	/** 
	 * El filósofo está pensando
	 */
	private void piensa() throws InterruptedException {
		System.out.println("El Filósofo " + id + " está pensando.\n");
		/*
		 * Cuando el filósofo está pensando debemos "dormir el hilo por un tiempo aleatorio"
		 * *** Completar el código ***
		 */
	}

	/** 
	 * El filósofo ocupa el cubierto (Recurso compartido)
	 */
	private void levantaCubiertoIzquierdo() {
		cubiertoIzquierdo.lock();
		System.out.println("El filósofo " + id + " tiene en la mano un cubierto.\n");
	}

	/** 
	 * El filósofo ocupa el cubierto (Recurso compartido)
	 */
	private void levantaCubiertoDerecho() {
		/*
		 * Cuando el filósofo levanta el cubierto derecho el recurso es ocupado "Locked".
		 * *** Completar el código ***
		 */
	}

	/**
	 * El filósofo come...
	 * @throws InterruptedException
	 */
	private void come() throws InterruptedException {
		System.out.println("El filósofo " + id + " está comiendo.\n");
		Thread.sleep (numGenerator.nextInt(10));
	}

	/**
	 * El filósofo baja los cubiertos
	 */
	private void bajaCubiertos() {
		/* 
		 * *** Completar el código ***
		 * Cuando el filósofo desocupa 
		 * ambos cubiertos los recursos deben ser desbloqueados "Unlocked".
		 */
	}
}