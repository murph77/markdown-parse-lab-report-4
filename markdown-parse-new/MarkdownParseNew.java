import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseNew {
    
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            if(!markdown.substring(currentIndex, markdown.length()).contains("[")){
                break;
            }
 
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
 
 
            if(markdown.contains("!") && markdown.charAt(openBracket - 1) == '!'){
                currentIndex = closeParen + 1;
                continue;
            }
 
            //For 3 & 4
            if(openBracket + 1 == closeBracket){
                currentIndex += 1;
                continue;
            }
 
 
            //For 7
            if (closeParen < openBracket || openParen < openBracket) {
                break;
            }
 
            //For 5
            if(markdown.charAt(closeBracket + 1) != '('){
                break;
            }
 
            //For 8
            else{
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
        }
 
        return toReturn;
    }

}
