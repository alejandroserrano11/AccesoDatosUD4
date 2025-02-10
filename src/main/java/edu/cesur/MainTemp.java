package edu.cesur;

import java.util.Arrays;
import java.util.Date;

public class MainTemp {
    public static void main(String[] args) {

        Cliente miCliente = new Cliente();

        /* casos de prueba
        1. array fuese null (solucionado por el constructor)
        2. array vacio
        3. array con un elemento
        4. array con MAX_VISITAS -2
        5. array con MAX_VISITAS -1
        6. array lleno
        

        // caso 2. array vacio

        System.out.println("Antes: " + miCliente.getVisitas());
        miCliente.ordenarVisitas();
        System.out.println("Después: " + miCliente.getVisitas());

        // caso 3. array con un elemento

        miCliente.insertarVisita(new Date("2025/02/03"));
        System.out.println("Antes: " + Arrays.toString(miCliente.getVisitas()));
        miCliente.ordenarVisitas();
        System.out.println("Después: " + Arrays.toString(miCliente.getVisitas()));

        */

        // caso 4. array con MAX_VISITAS -2
        miCliente.insertarVisita(new Date ("2025/01/05"));
        miCliente.insertarVisita(new Date ("2025/01/04"));
        miCliente.insertarVisita(new Date ("2025/01/03"));

    }
}
