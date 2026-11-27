/*
Una estacion registra N mediciones
Busca el tramo contiguo mas largo de lecturas iguales
Si hay varios escoge el que empieza antes

Entrada
La primera línea contiene N (1 ≤ N ≤ 1 000)
La segunda contiene N enteros entre −100 y 100.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class J01_RachaLectura {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //Leemos las mediciones
        int N = Integer.parseInt(br.readLine());

        //Leemos los numeros
        String[] datos = br.readLine().split(" ");
        int contador = 1;
        int valorActual = Integer.parseInt(datos[0]);
        int mayor = 1;
        int posicion = 1;
        int valorMayor = valorActual;

        //Recorremos
        for (int i = 1; i < N; i++) {

            int numero = Integer.parseInt(datos[i]);

            if (numero == valorActual) {
                contador++;
            } else {
                contador = 1;
                valorActual = numero;
            }

            if (contador > mayor) {
                mayor = contador;
                posicion = i - contador + 2;
                valorMayor = valorActual;
            }
        }

        // Mostramos los resultados
        bw.write(mayor + " " + posicion + " " + valorMayor);
        bw.newLine();

        bw.flush();

        br.close();
        bw.close();
    }
}
