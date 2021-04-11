import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import lombok.SneakyThrows;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordGenerator {
    //Get lines from text file
    public List<String> getLines(File fileName) throws Exception {
        //ReadFile instance
        ReadFile rf = new ReadFile();
        List<String> lines = rf.readLines(fileName);
        lines.forEach(System.out::println);
        return lines;
    }

    //Create Word
    @SneakyThrows public void createWord(List<String> lines) throws IOException {
        for (String line : lines) {
            //Blank Document
            XWPFDocument document = new XWPFDocument();
            //Write the Document in file system
            if (!Paths.get("./generated").toFile().exists()) Files.createDirectories(Paths.get("./generated"));
            String fileName = new File("generated/" + "createdWord" + "_" + line + ".docx").getAbsolutePath();

            FileOutputStream out = new FileOutputStream(fileName);

            //create Paragraph
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("VK Number (Parameter): " + line + " here you type your text...\n");
            document.write(out);

            //Close document
            out.close();
            System.out.println("createdWord" + "_" + line + ".docx" + " written successfully");
        }
    }
}
