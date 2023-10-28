import java.util.InputMismatchException;
import java.util.Scanner;
// Realizar la carga de un número entero por teclado e imprimir su cuadrado.
public class CuadradoNumero {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            boolean continua = true;

            do {
                try {
                    System.out.print("Ingrese un valor entero: ");
                    int num = teclado.nextInt();
                    int cuadrado = num * num;
                    System.out.println("El cuadrado de " + num + " es " + cuadrado);
                    continua = false;
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente un número entero.");
                    teclado.next(); // Limpiar el valor no válido
                }
            } while (continua);

        } finally {
            teclado.close();
        }
    }
}
