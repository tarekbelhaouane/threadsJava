package com.java.threads;

/**
 * Hello world!
 *
 */
public class App 
{
	 public static void main(String[] args) {
	        // Création d'un objet de verrouillage (lock)
	        Object verrou = new Object();

	        // Création de trois threads
	        Thread thread1 = new Thread(new MyRunnable(verrou), "Thread 1");
	        Thread thread2 = new Thread(new MyRunnable(verrou), "Thread 2");
	        Thread thread3 = new Thread(new MyRunnable(verrou), "Thread 3");

	        // Démarrage des threads
	        thread1.start();
	        thread2.start();
	        thread3.start();
	    }

	    // Classe Runnable qui effectue une tâche synchronisée
	    static class MyRunnable implements Runnable {
	        private final Object verrou;

	        public MyRunnable(Object verrou) {
	            this.verrou = verrou;
	        }

	        public void run() {
	            synchronized (verrou) {
	                // Code à exécuter de manière synchronisée
	                for (int i = 1; i <= 5; i++) {
	                    System.out.println(Thread.currentThread().getName() + " - Étape " + i);
	                }
	            }
	        }
	    }
}
