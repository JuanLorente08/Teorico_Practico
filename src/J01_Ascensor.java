/*
Un ascensor emieza con 0 perosnas y admite como maximo C
En la primera planta baja un grupo y intenta subir otro
Hay gente que no entra y se queda fuera
Cuantas se quedan fuera?

Entrada
C = numero de personas totales (1 ≤ C ≤ 50)
N = plantas??(1 ≤ N ≤ 200)
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class J01_Ascensor {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] datos = br.readLine().split(" ");

        int N = Integer.parseInt(datos[0]);
        int C = Integer.parseInt(datos[1]);
        int ocupacion = 0;
        int fuera = 0;
        // Recorrer todas las plantas
        for (int i = 0; i < N; i++) {

            // Personas que bajan y intenan subir
            datos = br.readLine().split(" ");

            int bajan = Integer.parseInt(datos[0]);
            int suben = Integer.parseInt(datos[1]);

            //Las que bajan
            ocupacion = ocupacion - bajan;

            //Huecos libres
            int huecos = C - ocupacion;

            //Capacidad del ascensor
            if (suben > huecos) {
                fuera = fuera + (suben - huecos);
                ocupacion = C;
            } else {
                ocupacion = ocupacion + suben;
            }
        }

        bw.write(fuera + " " + ocupacion);
        bw.newLine();

        bw.flush();

        br.close();
        bw.close();
    }
}
