public class AreaCirculo {
    public static class circulo{
        public static Float retornaElAreaDeCirculo(
                Float radioDelCirculo
        ){
            return (float) (radioDelCirculo * radioDelCirculo * 3.1416);
        }
    }

    public static void main(String[] args){
        System.out.println(
                circulo.retornaElAreaDeCirculo(3.2f)
        );
    }
}
