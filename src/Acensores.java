import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Acensores {
    static BufferedReader lector;
    static BufferedWriter escritor;
    static int numAscensores = 0;
    static int pisoLlamada = 0;

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

            pisosAscensores = new int[numAscensores]
        }
    }
}
