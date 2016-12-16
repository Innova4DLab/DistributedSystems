package com.Innova4d.dpm;

/**
 * El monitor asegura que el filósofo levantará únicamente
 * ambos cubiertos cuando sus vecinos nó estén comiendo.
 *
 * @author Francisco Gutiérrez
 * @version 1.0v
 *
 */
class Monitor {
	// El monitor conoce los diferentes estados para cada filósofo.
	private enum State {PENSANDO, HAMBRIENTO, COMIENDO};

	// Un vector que contiene el estado de cada filósofo.
	private State[] estadoFilosofo;

	/**
	 * Constructor que crea un monitor para el número adecuado de filósofos
	 * Como estado inicial, todos los filósofos están pensando.
	 *
	 * @param numFilosofos El número de filósofos.
	 */
	public Monitor (int numFilosofos) {
		estadoFilosofo = new State[numFilosofos];
		for (int i = 0; i < estadoFilosofo.length; i++) {
			estadoFilosofo[i] = State.PENSANDO;
		}
	}

	/**
	 * Un filósofo toma ambos cubiertos.
	 * El filósofo se pone a pensar si ambos vecinos comen.
	 *
	 * @param idFilosofo El filósofo que desea comer.
	 * @throws InterruptedException excepción si falla el hilo, ¿Por qué?.
	 */
	public synchronized void levantaCubiertos(int idFilosofo) throws /* Completar código */ {
		// Si levanta los cubiertos, come.
		estadoFilosofo[idFilosofo] = State.HAMBRIENTO;
		System.out.println("Filósofo: " + idFilosofo + " está hambriento.\n");
		// Mientras los vecinos comen, esperar...
		while (losVecinosComen(idFilosofo)) {
			/*
			 * Completar código.
			 * Mientras los vecinos comen.
			 * El filósofo debería estar pensando.
			 */
		}
		/* Cuando los vecinos dejan de comer.
		 * Ahora, y solo ahora, éste filósofo está comiendo. 
		 */
		estadoFilosofo[idFilosofo] = State.COMIENDO;
		System.out.println("Filósofo: " + idFilosofo + " está comiendo.\n");
	}

	/**
	 * Regresar true si ningún vecino come.
	 * @param idFilosofo El filósofo objetivo para verificar vecinos.
	 * @return true si ningún vecino come.
	 */
	private boolean losVecinosComen(int idFilosofo) {
		// Verificar filósofo de un lado.
		if (estadoFilosofo[(idFilosofo + 1) % estadoFilosofo.length] == State.COMIENDO)
			return true;
		// Verificar filósofo del otro.
		if (estadoFilosofo[(idFilosofo + estadoFilosofo.length - 1) % estadoFilosofo.length] == State.COMIENDO)
			return true;
		// Ninguno está comiendo
		return false;
	}

	/**
	 * El filósofo baja los cubiertos.
	 * Éste método debería ejecutar una tarea sincronizada.
	 * (Bajar los cubiertos al mismo tiempo y notificar a todos).
	 *
	 * Notificar a todos que ya pueden ocupar los recursos (Cubiertos).
	 *
	 * @param idFilosofo El filósofo que a terminado de comer.
	 */
	public /* completar codigo */ void bajarCubiertos(int idFilosofo) {
		estadoFilosofo[idFilosofo] = State.PENSANDO;
		/*
		 * Completar código
		 * Notificar a todos.
		 */
	}
}
