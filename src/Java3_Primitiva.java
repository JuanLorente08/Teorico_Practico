import java.util.Random;
import java.util.Scanner;

public class Java3_Primitiva {
    public static void main(String[] args){
        Random alea = new Random();
        Scanner leer = new Scanner(System.in)
        String arrayPrimitiva[] = new String[6];
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            int numAlea = alea.nextInt(100);
            arrayPrimitiva[i] = String.valueOf(numAlea);
        }

        System.out.println("Dame un numero");
        String cadUsuario1 = leer.nextInt();
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if (cadUsuario1.equals(arrayPrimitiva[i])){
                arrayPrimitiva[i] = "XX";
            }
        }

        System.out.println("Dame otro numero");
        String cadUsuario2 = leer.nextInt();
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if (cadUsuario2.equals(arrayPrimitiva[i])){
                arrayPrimitiva[i] = "XX";
            }
        }

        System.out.println("Dame el ultimo numero");
        String cadUsuario3 = leer.nextInt();
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if (cadUsuario3.equals(arrayPrimitiva[i])){
                arrayPrimitiva[i] = "XX";
            }
        }

        for (int i = 0; i < arrayPrimitiva.length; i++) {
            System.out.println(arrayPrimitiva[i]);
        }



    }
}