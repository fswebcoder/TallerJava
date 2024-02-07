package com.mycompany.tallerpaula;

import java.util.Scanner;

public class InsertarElemento {

    private String[] vector;
    public InsertarElemento(int n) {
        vector = new String[n];
    }

    public void ingresarDatosAlVector() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < vector.length; i++) {
            System.out.print("Ingrese el valor en la posición " + (i + 1) + ": ");
            vector[i] = scanner.next();
        }
    }

    public void insertarElemento(String elemento, int posicion) {
        if (posicion >= 0 && posicion < vector.length) {
            for (int i = vector.length - 1; i > posicion; i--) {
                vector[i] = vector[i - 1];
            }
            vector[posicion] = elemento;
        } else {
            System.out.println("No se pudo insertar el elemento.");
        }
    }

    public void mostrarVector() {
        System.out.print("Vector: [");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);
            if (i < vector.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }


}
