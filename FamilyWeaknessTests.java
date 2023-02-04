import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FamilyWeaknessTest{
    public static final String FILE_HEADER_PATTERN = "^family_([a-zA-Z]+)_weakness.txt$";

    public static final String FILE_BODY_PATTERN = "My family love %s";

    public static void main(String[] args) throws IOException {
        System.out.println(Files.list(Path.of(""))
                .filter(p -> p.toFile().isFile())
                .filter(file -> file.toString().matches(FILE_HEADER_PATTERN))
                .allMatch(Main::fileBodyTest)
        );
    }


    public static boolean fileBodyTest(Path file) {
        try {
            String body = Files.readString(file);
            Matcher matcher = Pattern.compile(FILE_HEADER_PATTERN).matcher(file.getFileName().toString());
            matcher.find();

            return body.equals(String.format(FILE_BODY_PATTERN, matcher.group(1)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}