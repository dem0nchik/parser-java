import java.io.*;
import java.util.HashMap;

public class Parser {

    public static void main(String[] args) throws InterruptedException {

        Parser parser = new Parser();
        File  file = new File("resources/file.txt");
        parser.printMapOfWords(parser.countUniqueWordsFromFile(file));
    }

    public HashMap<String, Integer> countUniqueWordsFromFile(File file)  {
        HashMap<String, Integer> map;


            try (InputStream inputStream = new FileInputStream(file)) {
                map = countUniqueWords(inputStream);
            } catch (IOException e) {
                throw new RuntimeException("Exception parse file");
            }
        return map;
    }

    public HashMap<String, Integer> countUniqueWords(InputStream inputStream) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();

        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream)) {
            int data = inputStreamReader.read();
            String word = "";

            while (data != -1) {
                char sym = (char) data;

                if (sym != '\r' && sym != '\n' && sym != ' ') {
                    word += sym;
                } else if(word.length() != 0) {
                    if (map.containsKey(word))
                        map.put(word, map.get(word) + 1);
                    else
                        map.put(word, 1);

                    word = "";
                } else {
                    word = "";
                }
                data = inputStreamReader.read();
            }
            if(word.length() != 0)
                if (map.containsKey(word))
                    map.put(word, map.get(word) + 1);
                else
                    map.put(word, 1);


        } catch (IOException e) {
            throw new IOException("Exception parse data");
        }
        return map;
    }

    public void printMapOfWords(HashMap<String, Integer> map) {
        map.keySet().forEach(key -> System.out.println(key + " - " + map.get(key)));
    }
}

