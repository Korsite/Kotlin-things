import java.util.Arrays;
import java.util.Scanner;

public class Ecuacion_3_variables{

    public static long gcd(long a, long b) {

        return b == 0 ? a : gcd(b, a % b);
    }

    public static String asFraction(long a, long b) {
        long gcd = gcd(a, b);
        return (a / gcd) + "/" + (b / gcd);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int [] valor_x = new int[3];
        int [] valor_y = new int[3];
        int [] valor_z = new int[3];
        int [] valor_igualdad = new int[3];

        int [][] matriz_z = new int[5][3];
        int [][] matriz_y = new int[5][3];
        int [][] matriz_x = new int[5][3];
        int [][] matriz_denominador = new int[5][3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Digito el valor de x" + (i+1) + ": ");
            valor_x[i] = in.nextInt();

            System.out.println("Digito el valor de y" + (i + 1) + ": ");
            valor_y[i] = in.nextInt();

            System.out.println("Digito el valor de z" + (i + 1) + ": ");
            valor_z[i] = in.nextInt();

            System.out.println("Digito el valor de la igualdad " + (i + 1) + ": ");
            valor_igualdad[i] = in.nextInt();
        }
//Grandhi just suck my pp this night atte: Ángel y Gilberto 21/03/2023
        for (int i = 0; i <3; i++) {    // aqui se pasan los datos dados a la matriz z, y, x (en ese orden)
            for (int j = 0; j < 3; j++) {
                matriz_z[i][j] = valor_x[i];
                matriz_y[i][j] = valor_x[i];
                matriz_x[i][j] = valor_igualdad[i];
                matriz_denominador[i][j] = valor_x[i];  j++;

                matriz_z[i][j] = valor_y[i];
                matriz_y[i][j] = valor_igualdad[i];
                matriz_x[i][j] = valor_y[i];
                matriz_denominador[i][j] = valor_y[i];  j++;

                matriz_z[i][j] = valor_igualdad[i];
                matriz_y[i][j] = valor_z[i];
                matriz_x[i][j] = valor_z[i];
                matriz_denominador[i][j] = valor_z[i];
            }
        }

        for (int i = 0; i < 2; i++) { // aqui se genera la posicion de los primeros dos 2 grupos a los ultimos 2 para la matriz z
            for (int j = 0; j < 3; j++) {
                matriz_z[i + 3][j] = matriz_z[i][j];
                matriz_y[i + 3][j] = matriz_y[i][j];
                matriz_x[i + 3][j] = matriz_x[i][j];
                matriz_denominador[i + 3][j] = matriz_denominador[i][j];
            }

        }
        System.out.println("La matriz Z CON la asignacion: " + Arrays.deepToString(matriz_z) + "\n" +
                           "La matriz Y CON la asignacion: " + Arrays.deepToString(matriz_y) + "\n" +
                           "La matriz X CON la asignacion: " + Arrays.deepToString(matriz_x) + "\n" +
                           "La matriz denominador con la asignacion: " + Arrays.deepToString(matriz_denominador));


        int matriz_multiplicacion = 1;
        int matriz_suma = 0;
        int matriz_resta = 0;
        System.out.println("------------Resolviendo la matriz \"Z\" en el numerador ------------");
        System.out.println("------Resolviendo la suma de dicha matriz-------\n");
        for (int i = 0; i < 3; i++) { //resolviendo matriz z en la suma
            for (int j = 0; j < 3; j++) {

                System.out.println("(" + matriz_z[i][j] + ")");
                matriz_multiplicacion *= matriz_z[i][j];

                i++; j++;
                System.out.println("(" + matriz_z[i][j] + ")");
                matriz_multiplicacion *= matriz_z[i][j];

                i++; j++;
                System.out.println("(" + matriz_z[i][j] + ")");
                matriz_multiplicacion *= matriz_z[i][j];

                System.out.println("La multiplicaion de los numeros es de: " + matriz_multiplicacion);
                System.out.println("\n");

            }
            i-=2;
            matriz_suma += matriz_multiplicacion;
            matriz_multiplicacion = 1;
        }

        System.out.println("La suma de las anteriores multiplicaciones es de: " + matriz_suma + "\n\n");
        System.out.println("------Resolviendo la resta de dicha matriz-------");


        for (int i = 4; i > 1; i--) { //resolviendo matriz z en la resta
            for (int j = 0; j < 3; j++) {

                System.out.println("(" + matriz_z[i][j] + ")");
                matriz_multiplicacion *= matriz_z[i][j];

                i--; j++;
                System.out.println("(" + matriz_z[i][j] + ")");
                matriz_multiplicacion *= matriz_z[i][j];


                i--; j++;
                System.out.println("(" + matriz_z[i][j] + ")");
                matriz_multiplicacion *= matriz_z[i][j];


                System.out.println("La multiplicaion de los numeros es de: " + matriz_multiplicacion);
                System.out.println("\n");
            }
            matriz_resta += matriz_multiplicacion;
            matriz_multiplicacion = 1;
            i+=2;
        }
        System.out.println("La suma de todos los numeros es de: " + matriz_resta);
        int matriz_z_numerador = matriz_suma - matriz_resta;
        System.out.println("El numerador de la matriz z sera de: "+ matriz_z_numerador + "\n\n");

        //aqui se acaba solucion de la matriz z

        matriz_suma = 0;
        matriz_resta= 0;

        //aqui empieza la solucion de la matriz y

        System.out.println("------------Resolviendo la matriz \"Y\" en el numerador ------------");
        System.out.println("------Resolviendo la suma de dicha matriz-------\n");
        for (int i = 0; i < 3; i++) {       //resolviendo matriz y en la suma
            for (int j = 0; j < 3; j++) {

                System.out.println("(" + matriz_y[i][j] + ")");
                matriz_multiplicacion *= matriz_y[i][j];

                i++; j++;
                System.out.println("(" + matriz_y[i][j] + ")");
                matriz_multiplicacion *= matriz_y[i][j];

                i++; j++;
                System.out.println("(" + matriz_y[i][j] + ")");
                matriz_multiplicacion *= matriz_y[i][j];

                System.out.println("La multiplicaion de los numeros es de: " + matriz_multiplicacion);
                System.out.println("\n");

            }
            i-=2;
            matriz_suma += matriz_multiplicacion;
            matriz_multiplicacion = 1;
        }
        System.out.println("La suma de las anteriores multiplicaciones es de: " + matriz_suma + "\n\n");
        System.out.println("------Resolviendo la resta de dicha matriz-------");

        for (int i = 4; i > 1; i--) {       //resolviendo matriz y en la resta
            for (int j = 0; j < 3; j++) {

                System.out.println("(" + matriz_y[i][j] + ")");
                matriz_multiplicacion *= matriz_y[i][j];

                i--; j++;
                System.out.println("(" + matriz_y[i][j] + ")");
                matriz_multiplicacion *= matriz_y[i][j];


                i--; j++;
                System.out.println("(" + matriz_y[i][j] + ")");
                matriz_multiplicacion *= matriz_y[i][j];


                System.out.println("La multiplicacion de los numeros es de: " + matriz_multiplicacion);
                System.out.println("\n");
            }
            matriz_resta += matriz_multiplicacion;
            matriz_multiplicacion = 1;
            i+=2;
        }



        System.out.println("La suma de las anteriores multiplicaciones es de: " + matriz_resta);
        int matriz_y_numerador = matriz_suma - matriz_resta;
        System.out.println("El numerador de la matriz z sera de: "+ matriz_y_numerador + "\n\n");

        //aqui se acaba la solucion de la matriz y

        matriz_suma = 0;
        matriz_resta = 0;

        //aqui empieza la solucion de la matriz x

        System.out.println("------------Resolviendo la matriz \"X\" en el numerador ------------");
        System.out.println("------Resolviendo la suma de dicha matriz-------\n");
        for (int i = 0; i < 3; i++) {       //resolviendo matriz x en la suma
            for (int j = 0; j < 3; j++) {

                System.out.println("(" + matriz_x[i][j] + ")");
                matriz_multiplicacion *= matriz_x[i][j];

                i++; j++;
                System.out.println("(" + matriz_x[i][j] + ")");
                matriz_multiplicacion *= matriz_x[i][j];

                i++; j++;
                System.out.println("(" + matriz_x[i][j] + ")");
                matriz_multiplicacion *= matriz_x[i][j];

                System.out.println("La multiplicacion de los numeros es de: " + matriz_multiplicacion);
                System.out.println("\n");

            }
            i-=2;
            matriz_suma += matriz_multiplicacion;
            matriz_multiplicacion = 1;
        }
        System.out.println("La suma de las anteriores multiplicaciones es de: " + matriz_suma + "\n\n");
        System.out.println("------Resolviendo la resta de dicha matriz-------");

        for (int i = 4; i > 1; i--) {       //resolviendo matriz x en la resta
            for (int j = 0; j < 3; j++) {

                System.out.println("(" + matriz_x[i][j] + ")");
                matriz_multiplicacion *= matriz_x[i][j];

                i--; j++;
                System.out.println("(" + matriz_x[i][j] + ")");
                matriz_multiplicacion *= matriz_x[i][j];


                i--; j++;
                System.out.println("(" + matriz_x[i][j] + ")");
                matriz_multiplicacion *= matriz_x[i][j];


                System.out.println("La multiplicacion de los numeros es de: " + matriz_multiplicacion);
                System.out.println("\n");
            }
            matriz_resta += matriz_multiplicacion;
            matriz_multiplicacion = 1;
            i+=2;
        }

        System.out.println("La suma de las anteriores multiplicaciones es de: " + matriz_resta);
        int matriz_x_numerador = matriz_suma - matriz_resta;
        System.out.println("El numerador de la matriz x sera de: "+ matriz_x_numerador + "\n\n");

        //aqui se acaba solucion de matriz x

        matriz_resta = 0;
        matriz_suma = 0;

        //aqui empieza solucion de matriz denominador

        System.out.println("------------Resolviendo la matriz \"denominador\" ------------");
        System.out.println("------Resolviendo la suma de dicha matriz-------\n");

        for (int i = 0; i < 3; i++) {       //resolviendo matriz denominador en la suma
            for (int j = 0; j < 3; j++) {

                System.out.println("(" + matriz_denominador[i][j] + ")");
                matriz_multiplicacion *= matriz_denominador[i][j];

                i++; j++;
                System.out.println("(" + matriz_denominador[i][j] + ")");
                matriz_multiplicacion *= matriz_denominador[i][j];

                i++; j++;
                System.out.println("(" + matriz_denominador[i][j] + ")");
                matriz_multiplicacion *= matriz_denominador[i][j];

                System.out.println("La multiplicacion de los numeros es de: " + matriz_multiplicacion);
                System.out.println("\n");

            }
            i-=2;
            matriz_suma += matriz_multiplicacion;
            matriz_multiplicacion = 1;
        }
        System.out.println("La suma de las anteriores multiplicaciones es de: " + matriz_suma + "\n\n");
        System.out.println("------Resolviendo la resta de dicha matriz-------");


        for (int i = 4; i > 1; i--) {       //resolviendo matriz numerador en la resta
            for (int j = 0; j < 3; j++) {

                System.out.println("(" + matriz_denominador[i][j] + ")");
                matriz_multiplicacion *= matriz_denominador[i][j];

                i--; j++;
                System.out.println("(" + matriz_denominador[i][j] + ")");
                matriz_multiplicacion *= matriz_denominador[i][j];


                i--; j++;
                System.out.println("(" + matriz_denominador[i][j] + ")");
                matriz_multiplicacion *= matriz_denominador[i][j];


                System.out.println("La multiplicacion de los numeros es de: " + matriz_multiplicacion);
                System.out.println("\n");
            }
            matriz_resta += matriz_multiplicacion;
            matriz_multiplicacion = 1;
            i+=2;
        }

        System.out.println("La suma de las anteriores multiplicaciones es de: " + matriz_resta);
        int matriz_x_denominador = matriz_suma - matriz_resta;
        int matriz_y_denominador = matriz_suma - matriz_resta;
        int matriz_z_denominador = matriz_suma - matriz_resta;
        System.out.println("El denominador de la matriz x, y, z sera de: "+ matriz_x_denominador);
        System.out.println("Mi verga en tu boca persona que esta utilizando este programa");
        System.out.println("---------------------------------------Los resultados son----------------------------------------\n\n");
        System.out.println("X = " + matriz_x_numerador + "/" + matriz_x_denominador + " = " + asFraction(matriz_x_numerador, matriz_x_denominador) + " = " + ((float)matriz_x_numerador/(float)matriz_x_denominador));
        System.out.println("Y = " + matriz_y_numerador + "/" + matriz_y_denominador + " = " + asFraction(matriz_y_numerador, matriz_y_denominador) + " = " + ((float)matriz_y_numerador/(float)matriz_y_denominador));
        System.out.println("Z = " + matriz_z_numerador + "/" + matriz_z_denominador + " = " + asFraction(matriz_z_numerador, matriz_z_denominador) + " = " + ((float)matriz_z_numerador/(float)matriz_z_denominador));
    }
}
