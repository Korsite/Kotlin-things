public class person {
    public String nombre;
    public person next;


    public person(){
        nombre=null;
        next=null;
    }

    public person creanodo(String nom, person P, person Q){
        Q.nombre =nom;
        Q.next=P;

        P=Q;
        System.out.println("valor del nodo: " + Q.nombre);
        System.out.println("direccion del nodo actual : " + Q );
        System.out.println("nodo actual apunta a: " + Q.next);
        System.out.println("                               "  );
        return P;
    }
    public person eliminanodo(person P, person Q){

        if (Q.next != null)
            P=Q.next;

        else
            P=null;
        System.out.println("EL NODO...." + Q.nombre+ "     HA SIDO ELIMINADO" );
        System.out.println("                               "  );
        Q=null;

        return P;
    }
    public void imprimirnodo(person nodos){

        System.out.println(nodos.nombre);
        while (nodos.next!=null){
            nodos=nodos.next;
            System.out.println(nodos.nombre);
        }

    }


}