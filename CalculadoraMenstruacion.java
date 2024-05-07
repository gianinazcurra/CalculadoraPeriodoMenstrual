package calculadoramenstruacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

/**
 *
 * @Giani
 */
public class CalculadoraMenstruacion {

    public static LocalDate calcularProximaMenstruacion(LocalDate fechaUltimaMenstruacion) {

        return fechaUltimaMenstruacion.plusDays(28);
    }

    public void MenuOpciones() {
        Scanner scanner = new Scanner(System.in);

        int opciones;

        do {
            // Mostrar el menú
            System.out.println("\nMenú:");
            System.out.println("1. Calcular fecha probable de ovulación");
            System.out.println("2. Calcular próxima fecha de menstruación");
            System.out.println("3. Calcular fecha probable de parto");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción:");

            opciones = scanner.nextInt();

            switch (opciones) {
                case 1:
                    break;
                case 2:
                    System.out.println("Ingresá la fecha de tu último periodo con el siguiente formato: AAAA-MM-DD");
                    scanner.nextLine();
                    String respuestaUsuario = scanner.nextLine();

                    LocalDate fechaUltimaMenstruacion = LocalDate.parse(respuestaUsuario); //paso de String a formato Date
                    LocalDate proximaMenstruacion = calcularProximaMenstruacion(fechaUltimaMenstruacion); //Llamo al método que está dentro de la clase y el resultado lo guardo en la variable
                    DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM); //formateo la fecha para que sea legible ja

                    System.out.println("La próxima fecha de menstruación es:" + proximaMenstruacion.format(mediumF));

                case 3:
                    break;
                case 4:
                    System.out.println("Exit");
            }

        } while (opciones != 4);
        if (opciones == 4) {
            System.out.println("Hasta Pronto");
        }

    }

    public static void main(String[] args) {
        CalculadoraMenstruacion calculadora = new CalculadoraMenstruacion();
        calculadora.MenuOpciones();
    }

}
