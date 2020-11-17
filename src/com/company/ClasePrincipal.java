package com.company;

public class ClasePrincipal {
    ClasePrincipal(){
        Cuadrilatero cuadrilatero = new Cuadrilatero();

        for (int i = 0; i< 10; i++){
            Luchador luchador = new Luchador(cuadrilatero);
            luchador.setName("Luchador " + (i+1));
            luchador.start();
        }
    }
}
