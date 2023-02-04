import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AutomateFamilyWeakness {

    public static final String TEXT_FORMAT = "My family love %s";

    public static void main(String[] args) throws Exception {
        String weakness = args[0];
        String fileHeader = generateFileHeader(weakness);
        try {
            Path path = generateFile(fileHeader);
            Files.writeString(path, String.format(TEXT_FORMAT, weakness));
        } catch (FileAlreadyExistsException e) {
            Files.writeString(Path.of(fileHeader), String.format(TEXT_FORMAT, weakness));
        } catch (Exception e) {
            System.err.println("Something went wrong");
            throw e;
        }

    }

    public static String generateFileHeader(String weakness) {
        String fileHeader = "family_" + weakness + "_weakness" + ".txt";
        return fileHeader;
    }

    public static Path generateFile(String header) throws IOException {
        Path path = Path.of(header);
        var file = Files.createFile(path);
        return path;
    }
}