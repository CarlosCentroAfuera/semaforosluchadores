package com.company;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cuadrilatero {

    private Semaphore semaphoreLucha = new Semaphore(2, false);

    private Luchador ganadorTemporal;

    private Luchador calcularGanador(Luchador l1, Luchador l2){
        Random r = new Random();
        if (r.nextBoolean()) {
            return l1;
        } else {
            return l2;
        }

    }

    public void pelearse(Luchador luchador)  {
        try {
            System.out.println("El " + luchador.getName() + " tiene ganas de guerra");
            semaphoreLucha.acquire();
            System.out.println("Entra en acción el " + luchador.getName());

            Random r = new Random();

            Thread.sleep(r.nextInt(1000));

            if (ganadorTemporal == null){
                // soy el primero, no había nadie.
                System.out.println(luchador.getName() + " ha sido el más rápido");
                ganadorTemporal = luchador;
            } else {
                System.out.println(luchador.getName() + " y " + ganadorTemporal.getName() + " se van a pelear");
                // Ya había alguien, toca pegarse
                Thread.sleep(2000);
                ganadorTemporal = calcularGanador(luchador, ganadorTemporal);
                System.out.println("Consideramos ganador a " + ganadorTemporal.getName());
                semaphoreLucha.release();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
