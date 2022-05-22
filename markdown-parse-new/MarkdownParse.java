//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            /*
            String currentString = markdown.substring(currentIndex, markdown.length());
            if (!currentString.contains("[") && !currentString.contains("]") && !currentString.contains("(") && !currentString.contains(")")) {
                    //System.out.println("Only at end");
                    break;
            }
            */
            
            if (!markdown.contains("[")) {
                break;
            }
            /*
            //if (markdown.contains("[") && markdown.contains("]") && 
                //markdown.contains("(s)") && markdown.contains(")")) {

                int openBracket = markdown.indexOf("[", currentIndex);
                int closeBracket = markdown.indexOf("]", openBracket);
                int openParen = markdown.indexOf("(", closeBracket);
                int closeParen = markdown.indexOf(")", openParen);

                if (openBracket != 0) {
                    if (markdown.charAt(openBracket - 1) == '!') {
                        currentIndex = closeParen + 1;
                        continue;
                    }
                }
                
                if (openParen - 1 != closeBracket) {
                    currentIndex = closeParen + 1;
                    continue;
                }
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
            
            //else {
            //    break;
            //}
            //*/
            
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            
            
            if (openBracket != 0) {
                if (markdown.charAt(openBracket - 1) == '!') {
                    currentIndex = closeParen + 1;
                    continue;
                }
            }
            
            if (openParen - 1 != closeBracket) {
                currentIndex = closeParen + 1;
                continue;
            }
            
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            //System.out.println(toReturn);
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
        //System.out.println("This is a new addition");
        //System.out.println(content);
    }
}
