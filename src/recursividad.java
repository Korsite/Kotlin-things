import java.util.Scanner;

public class recursividad {
    public static int numeroAChecar = 1;
    public static int suma = 0;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Has que numero sumo solamente los pares: ");
        int limiteParaSumar = in.nextInt();

        int sumaDeNumerosPares = sumaSolamentePares(limiteParaSumar);
        System.out.println(sumaDeNumerosPares);
    }
    public  static int sumaSolamentePares(int limiteParaSumar) {

        if(numeroAChecar <= limiteParaSumar && numeroAChecar % 2 == 0){
            suma += numeroAChecar;
            numeroAChecar += 1;
            return sumaSolamentePares(limiteParaSumar);
        }else if(numeroAChecar % 2 == 1){
            numeroAChecar += 1;
            return  sumaSolamentePares(limiteParaSumar);
        }else return suma;
    }
}


