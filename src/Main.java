import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName = "src/translation.txt";
        ArrayList<String> englishWords = new ArrayList<>();
        ArrayList<String> turkishWords = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            String turkishWord = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("/");
                if (parts.length >= 2) {
                    String englishWord = parts[parts.length-2].trim();
                    englishWords.add(englishWord);
                    if (!turkishWord.equals("")) {
                        turkishWords.add(turkishWord.trim());
                    }
                    turkishWord = "";
                } else {
                    turkishWord += line.trim() + "\n";
                }
            }
            if (!turkishWord.equals("")) {
                turkishWords.add(turkishWord.trim());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(englishWords);
        System.out.println(turkishWords);
    }
}


