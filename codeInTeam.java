import java.util.Arrays;

public class codeInTeam {
    public static void main(String[] args){

        int [] unaLista = {35, 15, 1, 20, -5};

        for(int iterador1 = 0; iterador1 <= unaLista.length - 1; iterador1++){
            int numeroMenor = unaLista[iterador1];
            int posicionDelNumeroMenor = iterador1;

            for(int iterador2 = iterador1; iterador2 <= unaLista.length - 1; iterador2 ++)
                if(unaLista[iterador2] < numeroMenor) {
                    numeroMenor = unaLista[iterador2];
                    posicionDelNumeroMenor = iterador2;
                }

            System.out.print("El numero menor en la vuelta " + (iterador1 + 1) + " es " + numeroMenor + " -> ");
            System.out.println(Arrays.toString(unaLista));

            int variableTemporal = unaLista[iterador1];
            unaLista[iterador1] = numeroMenor;
            unaLista[posicionDelNumeroMenor] = variableTemporal;

            System.out.println();
        }
    }
}