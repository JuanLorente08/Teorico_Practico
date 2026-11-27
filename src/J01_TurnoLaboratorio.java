/*
Cada equipo tiene un identificador y una prioridad. Ordena la cola de prioridad mayor a menor.
Si dos equipos tienen la misma prioridad, conserva el orden en que llegaron.
Entrada
La primera línea contiene N (1 ≤ N ≤ 200).
Cada una de las N líneas siguientes contiene un identificador entero
positivo distinto y una prioridad entre 0 y 100.
Las líneas están en orden de llegada
Salida
Los N identificadores, separados por espacios, en el orden de atención.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class J01_TurnoLaboratorio {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        int[] identificadores = new int[N];
        int[] prioridades = new int[N];

        //Leer los datos de cada equipo
        for (int i = 0; i < N; i++) {
            String[] datos = br.readLine().trim().split("\\s+");
            identificadores[i] = Integer.parseInt(datos[0]);
            prioridades[i] = Integer.parseInt(datos[1]);
        }

        //Establecer las prioridades
        for (int i = 0; i < N - 1; i++) {

            for (int j = 0; j < N - 1 - i; j++) {

                if (prioridades[j] < prioridades[j + 1]) {

                    // Intercambiamos las prioridades
                    int auxPrioridad = prioridades[j];
                    prioridades[j] = prioridades[j + 1];
                    prioridades[j + 1] = auxPrioridad;

                    // Intercambiamos los identificadores
                    int auxId = identificadores[j];
                    identificadores[j] = identificadores[j + 1];
                    identificadores[j + 1] = auxId;
                }
            }
        }

        //Mostrar ordenado
        for (int i = 0; i < N; i++) {

            if (i > 0) {
                bw.write(" ");
            }

            bw.write(String.valueOf(identificadores[i]));
        }

        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
    }
}
