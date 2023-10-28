import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccesoArchivo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean archivoExiste = false;

        do {
            try {
                System.out.print("Ingrese la ruta del archivo: ");
                String rutaArchivo = teclado.nextLine();
                File archivo = new File(rutaArchivo);

                if (archivo.exists()) {
                    archivoExiste = true;
                    Scanner lector;
                    try {
                        lector = new Scanner(archivo);

                        System.out.println("Contenido del archivo:");
                        while (lector.hasNextLine()) {
                            System.out.println(lector.nextLine());
                        }

                        lector.close();
                    } catch (FileNotFoundException ex) {
                        System.err.println("Error al leer el archivo.");
                    }
                } else {
                    throw new FileNotFoundException("Error: El archivo no existe en la ruta proporcionada.");
                }
            } catch (FileNotFoundException ex) {
                System.err.println(ex.getMessage());
            }
        } while (!archivoExiste);

        teclado.close();
    }
}
