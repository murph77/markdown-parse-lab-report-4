/* javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java 
java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
*/

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.io.*;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFileMD() throws Exception {
        String fileContents = Files.readString(Path.of("test-file.md"));

        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        expectedResult = List.of("https://something.com", "some-thing.html");

        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testFile2() throws Exception {
        String fileContents = Files.readString(Path.of("test2.md"));

        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        expectedResult = List.of("linktosomething.com");

        assertEquals(expectedResult, testResult);
    }

    
    // Haven't fixed the bug that causes this test to fail yet so will not test yet
    @Test
    public void testFile3() throws Exception {
        String fileContents = Files.readString(Path.of("test3.md"));

        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        expectedResult = List.of("linktosomething.com");

        assertEquals(expectedResult, testResult);
    }
    
    

    @Test
    public void testFile4() throws Exception {
        String fileContents = Files.readString(Path.of("test4.md"));

        ArrayList<String> testResult = new ArrayList<>();
        ArrayList<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        
        
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testFile5() throws Exception {
        String fileContents = Files.readString(Path.of("test5.md"));

        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        

        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testFile6() throws Exception {
        String fileContents = Files.readString(Path.of("test6.md"));

        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        expectedResult = List.of("something.com");

        assertEquals(expectedResult, testResult);
    }
    
    //Testing new tests
    @Test
    public void testFileMD2() throws Exception {
        String fileContents = Files.readString(Path.of("test-file2.md"));

        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        expectedResult = List.of("https://something.com", "some-page.html");

        assertEquals(expectedResult, testResult);
    }

    
    @Test
    public void testFileMD3() throws Exception {
        String fileContents = Files.readString(Path.of("test-file3.md"));

        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testFileMD4() throws Exception {
        String fileContents = Files.readString(Path.of("test-file4.md"));

        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testFileMD5() throws Exception {
        String fileContents = Files.readString(Path.of("test-file5.md"));

        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testFileMD6() throws Exception {
        String fileContents = Files.readString(Path.of("test-file6.md"));

        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testFileMD7() throws Exception {
        String fileContents = Files.readString(Path.of("test-file7.md"));

        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        
        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testFileMD8() throws Exception {
        String fileContents = Files.readString(Path.of("test-file8.md"));

        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();

        testResult = MarkdownParseNew.getLinks(fileContents);
        

        assertEquals(expectedResult, testResult);
    }

    @Test
    public void testSnippet1() throws Exception {
        String fileContents = Files.readString(Path.of("snippet1.md"));
        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = List.of("`google.com","google.com","ucsd.edu");
        testResult = MarkdownParseNew.getLinks(fileContents);
        assertEquals(expectedResult, testResult); 
    }

    @Test
    public void testSnippet2() throws Exception {
        String fileContents = Files.readString(Path.of("snippet2.md"));
        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = List.of("a.com","a.com(())","example.com");
        testResult = MarkdownParseNew.getLinks(fileContents);
        assertEquals(expectedResult, testResult); 
    }

    @Test
    public void testSnippet3() throws Exception {
        String fileContents = Files.readString(Path.of("snippet3.md"));
        ArrayList<String> testResult = new ArrayList<>();
        List<String> expectedResult = List.of
        ("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        testResult = MarkdownParseNew.getLinks(fileContents);
        assertEquals(expectedResult, testResult); 
    }


}
