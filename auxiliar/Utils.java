package auxiliar;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Utils {

    //! Convierte un array de cadenas en una única cadena separada por espacios.
    public static String argsToString(String[] args) {
        return String.join(" ", args);
    }

    //! Valida la ruta proporcionada por el usuario y crea un directorio si no existe.
    public static Path validatePath(String pathString) {
        if (pathString == null || pathString.isEmpty()) {
            System.out.println("Input the path:");
            pathString = new Scanner(System.in).nextLine();
        }

        try {
            Path path = Paths.get(pathString).toAbsolutePath();

            if (!Files.exists(path)) {
                Files.createDirectories(path);
                System.out.println("Directory created at: " + path.toAbsolutePath());
            }

            if (!Files.isDirectory(path)) {
                System.out.println("The provided path is not a directory.");
                return null;
            }

            return path; // Devuelve la ruta validada
        } catch (InvalidPathException | java.io.IOException e) {
            System.out.println("Invalid path: " + e.getMessage());
            return null;
        }
    }
}
