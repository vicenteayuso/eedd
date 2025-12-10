import java.util.Scanner;

public class Programa {

    // Scanner global
    static Scanner sc = new Scanner(System.in);
    static Envio[] envios = new Envio[50];
    static Integer iEnvios = 0;

    public static void main(String[] args) {

        boolean repetirMenu = true;

        do {
            String opcion = verMenu();   // verMenu ahora devuelve la opción

            switch (opcion) {
                case "1":
                    registrarEnvio();
                    break;

                case "2":
                    System.out.println("Mostrando informe...\n");
                    
                    break;
                case "3":
                    System.out.println("Realizando envío...\n");
                    enviar();
                    break;
                case "X":
                case "x":
                    repetirMenu = false;
                    break;

                default:
                    System.out.println("Opción desconocida\n");
            }

        } while (repetirMenu);

        // Esto se ejecuta solo cuando se sale del menú
        sc.close();
        System.out.println("Fin del programa. Espero volver a verle pronto.");
    }

    // verMenu debe devolver la opción
    public static String verMenu() {
        System.out.println("APLICACION DE PAQUETERÍA");
        System.out.println("1. Registrar envío");
        System.out.println("2. Ver informe de envíos");
        System.out.println("3. Realizar envío");
        System.out.println("x. Salir");
        System.out.print("Opción: ");
        return sc.nextLine();  // Devuelve lo que el usuario escribió
    }

    public static void registrarEnvio() {
        try {
            System.out.println("\nRegistro de Envío");
            System.out.print("\tNúmero: ");
            String numero = sc.nextLine();

            System.out.print("\tPrecio: ");
            float precio = Float.parseFloat(sc.nextLine());

            Envio envio = new Envio();
            envio.numero = numero;
            envio.precio = precio;
            envios[iEnvios++] = envio;

            System.out.println("Registro OK\n");
        } catch (Exception excepcion) {
            System.out.println("Registro KO\n");
        }
    }
    public static void enviar() {
        System.out.println("\nRealizar Envío");
        System.out.print("\tNúmero de envío: ");
        String numero = sc.nextLine();

        // Buscar el envío
        Envio envio = null;
        for (int i = 0; i < iEnvios; i++) {
            if (envios[i].numero.equals(numero)) {
                envio = envios[i];
                break;
            }
        }

        if (envio == null) {
            System.out.println("Envío no encontrado\n");
            return;
        }

        System.out.print("\tDirección de envío: ");
        String direccion = sc.nextLine();

        Furgonetas furgoneta = new Furgonetas();
        Boolean exito = furgoneta.realizar(envio, direccion);

        if (exito) {
            System.out.println("Envío realizado con éxito\n");
        } else {
            System.out.println("Error al realizar el envío\n");
        }
    }
}
