import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Acensores {
    static BufferedReader lector;
    static BufferedWriter escritor;
    static int numAscensores = 0;
    static int pisoLlamada = 0;
    static int pisosAscensores[];
    static int distanciaMinima = -1;
    static int posicionElegidaPorCercania = -1;
    static boolean respondioElDelCero = false;
    static int indiceBajadaAlCero;
    static int mejorDistancia;

    public static void main(String[]args) throws Exception{
        lector = new BufferedReader(new InputStreamReader(System.in));
        escritor = new BufferedWriter(new OutputStreamWriter(System.out));
        String linea;
        while ((linea = lector.readLine()) != null){
            linea = linea.trim();
            if (linea.isEmpty()) continue;;

            String[] cabecera = linea.split(" ");
            numAscensores = Integer.parseInt(cabecera[0]);
            pisoLlamada = Integer.parseInt(cabecera[1]);

            String segunda = lector.readLine();
            if (segunda == null){
                break;
            }
            String[] partes = segunda.trim().split(" ");

            pisosAscensores = new int[numAscensores];
            for (int i = 0; i < partes.length; i++) {
                pisosAscensores[i] = Integer.parseInt(partes[i]);
            }
            elegirAscensorYCuplir0();
            for (int i = 0; i < numAscensores; i++) {
                escritor.write(Integer.toString(pisosAscensores[i]));
            }
            escritor.newLine();
        }
        escritor.flush();
    }


    static void elegirAscensorYCuplir0(){
        // Calcular el que esta mas cerca
        posicionElegidaPorCercania = -1;
        distanciaMinima = Math.abs(pisosAscensores[0] - pisoLlamada);
        for (int i = 0; i < numAscensores; i++) {
            int d = Math.abs(pisosAscensores[i] - pisoLlamada);
            if (d < distanciaMinima){
                distanciaMinima = d;
                posicionElegidaPorCercania = i;
            }
        }
        if (pisosAscensores[posicionElegidaPorCercania] == 0){
            respondioElDelCero = true;
        }else{
            respondioElDelCero = false;
        }
        pisosAscensores[posicionElegidaPorCercania] = pisoLlamada;
        if (respondioElDelCero){
            indiceBajadaAlCero = -1;
            mejorDistancia = 1000; // Valor desborde (que no es posible dentro del problema)
            for (int i = 0; i < numAscensores; i++) {
                if (i == posicionElegidaPorCercania) continue;
                int distanciaActual = Math.abs(pisosAscensores[i] - 0);
                if (distanciaActual < mejorDistancia){
                    mejorDistancia = distanciaActual;
                    indiceBajadaAlCero = i;
                }
            }
            pisosAscensores[indiceBajadaAlCero] = 0;
        }

    }
}
