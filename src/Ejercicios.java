import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
class Practica2 {

    public static void main(String[] args) throws IOException {
        InputStreamReader irs = new InputStreamReader(System.in);
        BufferedReader entrada = new BufferedReader(irs);
        PrintStream salida = System.out;
        int a = 0, r = 0;
        int[][] cal = new int[5][4]; // Matriz para almacenar calificaciones

        for (int i = 0; i < 5; i++) {
            int suma = 0;
            int c = 1;

            for (int j = 0; j < 3; j++) {
                salida.println("Introduce calificacion " + c);
                c++;
                String b = entrada.readLine();
                cal[i][j] = Integer.parseInt(b);
                suma += cal[i][j];
            }

            cal[i][3] = suma / 3;
            salida.println("El promedio es = " + cal[i][3]);
        }

        for (int j = 0; j < 5; j++) {
            if (cal[j][3] >= 70)
                a++;
            else
                r++;
        }

        salida.println("Numero de aprobados: " + a);
        salida.println("Numero de reprobados: " + r);
    }
}