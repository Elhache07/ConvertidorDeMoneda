import Api.ConsultaTasaDeCambio;
import Api.Tasas;


import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {


        Scanner lectura=new Scanner(System.in);

        ConsultaTasaDeCambio consulta=new ConsultaTasaDeCambio();

        try{
            while (true){

                System.out.println(" *******************************************************");
                System.out.println("Sea bienvenido/a al Conversor de Monedas =]");
                System.out.println("\n1) Dólar =>> Peso argentino" +
                        "\n2) Peso argentino =>> Dólar" +
                        "\n3) Dólar =>> Real Brasileño" +
                        "\n4) Real Brasileño =>> Dólar" +
                        "\n5) Dólar =>> Peso colombiano"+
                        "\n6) Peso colombiano =>> Dólar" +
                        "\n7) Salir" );

                System.out.println(" \nElige una opción válida:");
                System.out.println(" *******************************************************");

                int opcion = lectura.nextInt();
                lectura.nextLine(); // Limpia el buffer

                switch (opcion){

                    case 1:
                        System.out.println("Ingrese el valor que desea convertir: ");
                        Double valor1 = Double.valueOf(lectura.nextLine());
                        consulta.buscarTasa("USD", "ARS", valor1);
                        break;

                    case 2:
                        System.out.println("Ingrese el valor que desea convertir: ");
                        Double valor2 = Double.valueOf(lectura.nextLine());
                        consulta.buscarTasa("ARS", "USD", valor2);
                        break;

                    case 3:
                        System.out.println("Ingrese el valor que desea convertir: ");
                        Double valor3 = Double.valueOf(lectura.nextLine());
                        consulta.buscarTasa("USD", "BRL", valor3);
                        break;

                    case 4:
                        System.out.println("Ingrese el valor que desea convertir: ");
                        Double valor4 = Double.valueOf(lectura.nextLine());
                        consulta.buscarTasa("BRL", "USD", valor4);
                        break;

                    case 5:
                        System.out.println("Ingrese el valor que desea convertir: ");
                        Double valor5 = Double.valueOf(lectura.nextLine());
                        consulta.buscarTasa("USD", "COP", valor5);
                        break;

                    case 6:
                        System.out.println("Ingrese el valor que desea convertir: ");
                        Double valor6 = Double.valueOf(lectura.nextLine());
                        consulta.buscarTasa("COP", "USD", valor6);
                        break;

                    case 7:
                        System.out.println("Hasta luego");
                        return;

                    default:
                        System.out.println("Opción no válida");
                }
            }



        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicacion");
        }
    }
}
