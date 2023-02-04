import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AutomateFamilyWeakness {

    public static final String TEXT_FORMAT = "My family love %s";

    public static void main(String[] args) throws Exception {
        String weakness = args[0];
        String fileName = generateFileName(weakness);
        try {
            Path path = generateFile(fileName);
            Files.writeString(path, String.format(TEXT_FORMAT, weakness));
        } catch (FileAlreadyExistsException e) {
            Files.writeString(Path.of(fileHeader), String.format(TEXT_FORMAT, weakness));
        } catch (Exception e) {
            System.err.println("Something went wrong");
            throw e;
        }

    }

    public static String generateFileName(String weakness) {
        String name = "family_" + weakness + "_weakness" + ".txt";
        return name;
    }

    public static Path generateFile(String name) throws IOException {
        Path path = Path.of(name);
        var file = Files.createFile(path);
        return path;
    }
}
