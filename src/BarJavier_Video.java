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
                String resultado = procesarDia(sumaPorCategoria, contEntradasPorCategoria);
            }else{
                char codigo = textoCategoria.charAt(0);
                int posQueOcupaCategoria = getPosCategoria(codigo);
                if (posQueOcupaCategoria>0){
                    anadirVenta(sumaPorCategoria, posQueOcupaCategoria, importe, contEntradasPorCategoria);
                }
            }
        }
    }
    static float mediaComida(float[]sum, int[]cont){
        int pos = getPosCategoria('A');
        return (sum[pos] / cont[pos]);
    }


    static float mediaTotalDia(float[]sum, int[]cont){
        float sumaTotal = 0.0f;
        int contTotal = 0;

        for (int i = 0; i < sum.length; i++) {
            sumaTotal += sumaTotal + sum[i];
            contTotal += contTotal + cont[i];
        }
        return sumaTotal/contTotal;
    }



    static float getMax(float[]sum, int[]cont){
        float vMax = sum[0];

        for (int i = 0; i < sum.length; i++) {
            if (vMax < sum[i]){
                vMax = sum[i];
            }
        }
        return vMax;
    }
    static float getMin(float[]sum){
        float vMin = sum[0];
        for (int i = 0; i < sum.length; i++) {
            if (vMin > sum[i]){
                vMin = sum[i];
            }
        }
        return vMin;
    }
    static String procesarDia(float[] sum, int[] contador){
        float max = getMax(sum, contador);
        float min = getMin(sum);

        float mediaA = mediaComida(sum, contador);
        float mediaTotal = mediaTotalDia(sum, contador);

        // If avreviado
        String supera = (mediaA > mediaTotal) ?"Si" :"No" ;
        return max + "#" + min + "#" + supera;
    }
    static void anadirVenta(float[]sumaParcial, int pos, float importe, int[] cont){
        sumaParcial[pos] = sumaParcial[pos] + importe;
        cont[pos] = cont[pos] + 1;
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
