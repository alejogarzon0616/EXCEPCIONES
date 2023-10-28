import java.util.InputMismatchException;
import java.util.Scanner;

//Considere una ecuación cuadrática de la forma ax^2 + bx + c. Escriba un programa que permita leer los coeficientes reales de una ecuación de este tipo y obtenga las raíces reales de la misma. Para ello:
//Si el coeficiente a es cero, deberá generar tanto la excepción como el manejo correspondiente de la misma; es decir, su programa deberá reportar el problema (no es una ecuación cuadrática) y continuar.
//Detectar si los coeficientes no son números.Si las raíces de la ecuación no son números reales, deberá también reportar dicha situación como una excepción y realizar el manejo correspondiente (preguntar al usuario si desea continuar o no).

public class EcuacionCuadratica {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        double a = 0, b = 0, c = 0;
        
        do {
            try {
                System.out.println("Ingrese los coeficientes de la ecuación cuadrática:");
                System.out.print("Coeficiente a: ");
                a = obtenerNumeroReal(teclado);
                if (a == 0) {
                    throw new CoeficienteCeroException();
                }
                System.out.print("Coeficiente b: ");
                b = obtenerNumeroReal(teclado);
                System.out.print("Coeficiente c: ");
                c = obtenerNumeroReal(teclado);
                
                double discriminante = b * b - 4 * a * c;
                
                if (discriminante < 0) {
                    throw new DiscriminanteNegativoException();
                }
                
                double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                
                System.out.println("Raíces de la ecuación cuadrática:");
                System.out.println("Raíz 1: " + raiz1);
                System.out.println("Raíz 2: " + raiz2);
                
            } catch (CoeficienteCeroException ex) {
                System.err.println(ex.getMessage());
            } catch (InputMismatchException ex) {
                System.err.println("Error: Los coeficientes deben ser números reales.");
            } catch (DiscriminanteNegativoException ex) {
                System.err.println(ex.getMessage());
                System.out.print("¿Desea continuar (S/N)? ");
                char respuesta = teclado.next().charAt(0);
                if (respuesta != 'S' && respuesta != 's') {
                    System.out.println("Programa terminado.");
                    break;
                }
            }
        } while (true);
        
        teclado.close();
    }

    static class CoeficienteCeroException extends Exception {
        public CoeficienteCeroException() {
            super("Error: No es una ecuación cuadrática (a = 0).");
        }
    }

    static class DiscriminanteNegativoException extends Exception {
        public DiscriminanteNegativoException() {
            super("Error: El discriminante es negativo, las raíces no son números reales.");
        }
    }
    
    static double obtenerNumeroReal(Scanner teclado) {
        while (true) {
            try {
                return teclado.nextDouble();
            } catch (InputMismatchException ex) {
                System.err.println("Error: Los coeficientes deben ser números reales. Inténtelo de nuevo.");
                teclado.next(); // Limpiar el valor no válido
            }
        }
    }
}
