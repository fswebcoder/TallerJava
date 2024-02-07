/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tallerpaula;
import java.util.Arrays;

import java.util.Scanner;

/**
 *
 * @author fasanche
 */
public class Serie {

    /**declaración de un vector de reales**/
    private static double[] vector;

    /**Constructor que inicializa el vector en n elementos**/
    public Serie(int n){
        vector = new double[n];
    }

    /**Metodo principal**/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la opción correcpondiente al punto del taller: \n");
        System.out.print("1. Maximo - minimo - media - varianza - mediana - moda \n");
        System.out.print("2. Ingresar valores al vector \n");
        System.out.print("\n");
        String opcion = scanner.nextLine();
        switch (opcion) {
            case "1":
                System.out.print("Ingrese la cantidad de elementos en el vector: ");
                int n = scanner.nextInt();
                Serie main = new Serie(n);
                main.ingresarValoresVector();

                System.out.println("El máximo es :" + main.max());
                System.out.println("El minimo es :" + main.min());
                System.out.println("La media es :" + main.media());
                System.out.println("La mediana es :" + main.mediana());
                System.out.println("La moda es :" + main.moda());
                break;
            case "2":

                System.out.print("Ingrese el tamaño del vector de String: ");
                n = scanner.nextInt();
                InsertarElemento vectorString = new InsertarElemento(n);
                vectorString.ingresarDatosAlVector();
                System.out.print("\n");
                System.out.print("----------------------------------------------\n");
                System.out.print("Ingrese el elemento a insertar: ");
                String elemento = scanner.next();
                System.out.print("----------------------------------------------\n");
                System.out.print("Ingrese la posición de inserción: ");
                int posicion = scanner.nextInt();

                System.out.print("\n");

                vectorString.insertarElemento(elemento, posicion);
                vectorString.mostrarVector();
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }




    }

    public void MenuApp(){


    }



    public void ingresarValoresVector(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos para el vector:");
        for (int i = 0; i < vector.length; i++) {
            System.out.print("Dato " + (i + 1) + ": ");
            vector[i] = scanner.nextDouble();
        }
    }

    public double max(){
        double maximo = vector[0];
        for (double elemento = 0; elemento <= vector.length ; elemento++) {
            if (elemento > maximo) {
                maximo = elemento;
            }
        }
        return maximo;
    }

    public double min(){
        double minimo = vector[0];
        for (double elemento = 1; elemento < vector.length ; elemento++) {
            if (elemento < minimo) {
                minimo = elemento;
            }
        }
        return minimo;
    }

    public double media(){
        double suma = 0;
        for(int i = 0; i < vector.length; i++) {
            suma += vector[i];
        }
        return suma / vector.length;
    }

    public double mediana(){
        double mediana = 0;
        if (vector.length % 2 == 0) {
            mediana = (vector[vector.length / 2] + vector[vector.length / 2 - 1]) / 2;
        } else {
            mediana = vector[vector.length / 2];
        }
        return mediana;
    }

    public double moda(){
        Arrays.sort(vector);

        double moda = vector[0];
        int maxFrecuencia = 1;
        int frecuenciaActual = 1;

        for (int i = 1; i < vector.length; i++) {
            if (vector[i] == vector[i - 1]) {
                frecuenciaActual++;
            } else {
                frecuenciaActual = 1;
            }

            if (frecuenciaActual > maxFrecuencia) {
                maxFrecuencia = frecuenciaActual;
                moda = vector[i];
            }
        }

        return moda;

    }
}