import javax.swing.JOptionPane;

public class node {

    public static void main(String[] args) {
        // Declarar un arreglo para el estacionamiento y un contador de avionetas estacionadas.
        String[] estacionamiento = new String[12];
        int avionetasEstacionadas = 0;
        String avionetaEnEspera = "";

        // Bucle para la llegada de avionetas
        while (true) {
            // Solicitar la matrícula de la avioneta al usuario
            String input = JOptionPane.showInputDialog("Ingrese la matrícula de la avioneta (o 'salir' para salir):");

            // Salir del programa si se ingresa "salir"
            if (input == null || input.equalsIgnoreCase("salir")) {
                break;
            }

            // Incrementar el contador de avionetas estacionadas y guardar la matrícula en el estacionamiento
            avionetasEstacionadas++;
            estacionamiento[avionetasEstacionadas - 1] = input;

            // Comprobar si el estacionamiento está lleno
            if (avionetasEstacionadas == 12) {
                JOptionPane.showMessageDialog(null, "El estacionamiento está lleno. Espere o dé la orden de salida.");
                avionetaEnEspera = input;
                break;
            }

            // Mostrar las avionetas estacionadas en orden
            String message = "Avionetas estacionadas en orden:\n";
            for (int i = 0; i < avionetasEstacionadas; i++) {
                message += (i + 1) + ". " + estacionamiento[i] + "\n";
            }
            JOptionPane.showMessageDialog(null, message);
        }

        // Bucle para la salida de avionetas
        while (avionetasEstacionadas > 0) {
            // Solicitar la matrícula de la avioneta que se desea sacar
            String input = JOptionPane.showInputDialog("Ingrese la matrícula de la avioneta que desea sacar:");

            // Variable para controlar si se encontró la avioneta
            boolean encontrado = false;

            // Buscar la avioneta en el estacionamiento
            for (int i = 0; i < avionetasEstacionadas; i++) {
                if (estacionamiento[i] != null && estacionamiento[i].equals(input)) {
                    encontrado = true;
                    avionetasEstacionadas--;

                    // Mover las avionetas hacia adelante
                    for (int j = i; j < avionetasEstacionadas; j++) {
                        estacionamiento[j] = estacionamiento[j + 1];
                    }
                    estacionamiento[avionetasEstacionadas] = avionetaEnEspera;
                    break;
                }
            }

            // Mostrar las avionetas estacionadas después de la salida
            if (encontrado) {
                String message = "Avionetas estacionadas en orden:\n";
                for (int i = 0; i < avionetasEstacionadas; i++) {
                    message += (i + 1) + ". " + estacionamiento[i] + "\n";
                }
                JOptionPane.showMessageDialog(null, message);
            } else {
                JOptionPane.showMessageDialog(null, "La avioneta con matrícula " + input + " no se encuentra estacionada.");
            }

            avionetaEnEspera = JOptionPane.showInputDialog("Ingrese la matrícula de la avioneta que desea ingresar:");
        }

        // Mostrar un mensaje de que el estacionamiento está vacío
        JOptionPane.showMessageDialog(null, "El estacionamiento está vacío. Gracias por utilizar el programa.");

    }
}