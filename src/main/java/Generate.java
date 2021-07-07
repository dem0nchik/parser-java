import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Generate {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("resources/fileBig.txt", "UTF-8");

        for (int i = 0; i < 90000; i++) {
            writer.print(generateRandomWords() + " ");

        }
        writer.close();
    }

    public static String generateRandomWords() {
        Random random = new Random();
        char[] word = new char[random.nextInt(8)+3];
        for(int i = 0; i < word.length; i++) {
            word[i] = (char)('a' + random.nextInt(26));
        }
        return new String(word);
    }
}
