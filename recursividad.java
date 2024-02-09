import java.util.Scanner;

public class recursividad {
    public static int suma = 0;
    public static int numeroPar = 2;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Has que numero sumo solamente los pares: ");
        int limiteParaSumar = in.nextInt();

        int sumaDeNumerosPares = sumaSolamentePares(limiteParaSumar, 2);
        System.out.println(sumaDeNumerosPares);
    }
    public  static int sumaSolamentePares(int limiteParaSumar, int siguienteNumeroPar) {

        if(siguienteNumeroPar <= limiteParaSumar){
            suma += siguienteNumeroPar;
            numeroPar += 2;
            return sumaSolamentePares(limiteParaSumar, numeroPar);
        }else return suma;
    }
}


