import java.io.File;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        //Instantiate WordGenerator Class
        WordGenerator wg = new WordGenerator();

        //Gather VK Lines from text file
        List<String> vkLines = wg.getLines(
            new File((Objects.requireNonNull(Main.class.getClassLoader().getResource("vk_no.txt")).toURI())));

        //Create word document according to VK lines
        wg.createWord(vkLines);
    }
}
