import javax.swing.*;

public class Ejercicios {

    public static void main(String[] args) {
        int res=1;
        int con=0;

        person P = new person();
        person R = new person();
        P=null;
        R=null;
        while (res!=0){

            String resp = JOptionPane.showInputDialog("1. agregar, 2: eliminar, 3: imprimir, 0: salir");
            res = Integer.parseInt(resp);
            if (res==1){
                person Q = new person();
                String x = JOptionPane.showInputDialog("introduzca un nombre");
                P = Q.creanodo(x, P, Q);

            }
            if (res==2){
                if (P==null)
                    System.out.println("LA LISTA ESTA VACIA...." );
                else{
                    P=P.eliminanodo(P, P);
                }

            }

            if (res==3){
                if (P==null)
                    System.out.println("LA LISTA ESTA VACIA...." );
                else{
                    P.imprimirnodo(P);
                }
            }
        }
    }
}


/**
 *
 * @author sistemas y computaci
 */
