import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;

import org.junit.*;

public class MarkdownParseTest {  // class for tests 

    @Test  // annotattion for JUnit to know this is a test case 
    public void addition() {  // test method header 
        assertEquals(2, 1 + 1);  // checks actual value 1 + 1 == expected 2
    }

    @Test
    public void testGetLinks() throws IOException{
        Path filePath = Path.of("test-file.md");
        String fileContent = Files.readString(filePath);
        assertEquals("Check for right links", List.of("https://something.com", "some-thing.html"), MarkdownParse.getLinks(fileContent));
    }

    @Test
    public void testGetLinks1() throws IOException{
        Path filePath = Path.of("test-file-link-mid.md");
        String fileContent = Files.readString(filePath);
        assertEquals("Check for right links", List.of("https://www.google.com/"), MarkdownParse.getLinks(fileContent));
    }

    @Test
    public void testGetLinks2() throws IOException{
        Path filePath = Path.of("test-file-Img.md");
        String fileContent = Files.readString(filePath);
        assertEquals("Check doesnt get img", List.of("https://www.google.com/"), MarkdownParse.getLinks(fileContent));
    }

    @Test
    public void testFileBackwards() throws IOException{
        Path filePath = Path.of("file-backward.md");
        String fileContent = Files.readString(filePath);
        assertEquals("Check doesnt get link", List.of("https://www.google.com/"), MarkdownParse.getLinks(fileContent));
    }
}