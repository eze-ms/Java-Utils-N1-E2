import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import auxiliar.Utils;

public class DirectoryLister {

    //! Punto de inicio del programa.
    static void init(String[] args) {
        String defaultDirectory = "TestFolder";

        String directoryPath = (args.length < 1) ? defaultDirectory : Utils.argsToString(args);
        listDirectory(directoryPath);
    }

    //! Lista alfabéticamente el contenido de un directorio.
    public static void listDirectory(String directoryPath) {
        Path path = Utils.validatePath(directoryPath);

        if (path == null) {
            System.out.println("Invalid directory path.");
            return;
        }

        // Añadir archivos y subdirectorios si se acaba de crear la carpeta
        if (isDirectoryEmpty(path)) {
            createDefaultFiles(path);
        }

        // Listar el contenido del directorio
        try (Stream<Path> stream = Files.list(path)) {
            System.out.println("Contents of " + path.toAbsolutePath() + ":");

            List<Path> sortedPaths = stream.sorted().toList();
            for (Path file : sortedPaths) {
                System.out.println(file.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Error reading the directory: " + e.getMessage());
        }
    }

    //! Comprueba si un directorio está vacío.
    private static boolean isDirectoryEmpty(Path path) {
        try (Stream<Path> stream = Files.list(path)) {
            return stream.findAny().isEmpty();
        } catch (IOException e) {
            System.out.println("Error checking directory: " + e.getMessage());
            return false;
        }
    }

    //! Crea archivos y subdirectorios por defecto en la ruta dada.
    private static void createDefaultFiles(Path path) {
        try {
            Files.createFile(path.resolve("file1.txt"));
            Files.createFile(path.resolve("file2.txt"));
            Files.createDirectory(path.resolve("subdir"));
            System.out.println("Default files and subdirectory created.");
        } catch (IOException e) {
            System.out.println("Error creating default files: " + e.getMessage());
        }
    }
}
