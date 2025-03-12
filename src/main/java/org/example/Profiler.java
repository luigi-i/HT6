package org.example;

import org.apache.commons.lang3.time.StopWatch;

//estructura base del profiler extraida de:

import java.util.List;

public class Profiler {
    public static void medirTiempo(Runnable metodo) {
        long inicio = System.nanoTime();

        metodo.run();  // Ejecuta el método que le pasas

        long fin = System.nanoTime();
        long duracion = (fin - inicio) / 1_000_000; // Convierte a milisegundos

        System.out.println("Tiempo de ejecución: " + duracion + " ms");
    }
}

