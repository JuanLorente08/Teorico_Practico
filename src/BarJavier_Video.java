import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BarJavier_Video {
    static final char[] codes = {'D','A','M','I','C'};
    static final String[] nombres = {"Desayunos", "Comidas", "Meriendas", "Cenas", "Copas"};

    public static void main(String[]args) throws Exception{
        //Asistentes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        float[] sumaPorCategoria = new float[codes.length];
        int[] contEntradasPorCategoria = new int[codes.length];

        String linea;
        while ((linea = br.readLine()) !=null){
            linea = linea.trim();
            if (linea.isEmpty())continue;

            StringTokenizer st = new StringTokenizer(linea);
            String textoCategoria = st.nextToken();
            float importe = Float.parseFloat(st.nextToken());
            // D 2.80
            if (textoCategoria.equals("N") && importe == 0.0f){

            }else{
                char codigo = textoCategoria.charAt(0);
                int posQueOcupaCategoria = getPosCategoria(codigo);
                if (posQueOcupaCategoria>0){
                    anadirVenta(sumaPorCategoria, posQueOcupaCategoria);
                }
            }
        }
    }
    static void anadirVenta(float[]sumaParcial, int pos, int importe){
        sumaParcial[pos]=sumaParcial[pos] + importe;
    }
    static int getPosCategoria(char cod){
        for (int i = 0; i < codes.length; i++) {
            if (codes[i] == cod){
                return i;
            }
        }
        return -1;
    }
}
