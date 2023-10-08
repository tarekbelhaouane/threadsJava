package com.java.threads;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {

    @Test
    public void testSynchronizedThreads() throws InterruptedException {
        // Créer un objet de verrouillage pour le test
        Object verrouTest = new Object();

        // Créer trois threads pour le test
        Thread thread1 = new Thread(new App.MyRunnable(verrouTest));
        Thread thread2 = new Thread(new App.MyRunnable(verrouTest));
        Thread thread3 = new Thread(new App.MyRunnable(verrouTest));

        // Démarrer les threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Attendre la fin de l'exécution des threads
        thread1.join();
        thread2.join();
        thread3.join();

        // Vérifier si les threads ont été exécutés correctement (par exemple, en vérifiant la sortie)
        // Vous devrez adapter cette vérification en fonction de votre logique spécifique
        // Dans cet exemple, nous n'effectuons qu'une vérification minimale
        assertTrue(true); // Vous pouvez remplacer ceci par votre propre vérification
    }
}