import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EngCalisan{
    public static void main(String[] args) {
        String fileName = "src/translation.txt";
        ArrayList<String> englishWords = new ArrayList<>();
        ArrayList<String> turkishWords = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            String currentEnglishWord = "";
            String currentTurkishWord = "";

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // If the line starts with a number, it is a Turkish word
                if (line.matches("^\\d+\\..*")) {
                    currentTurkishWord += line + "\n";
                } else {
                    // If the currentTurkishWord is not empty, it means we have finished reading a Turkish word
                    if (!currentTurkishWord.isEmpty()) {
                        turkishWords.add(currentTurkishWord.trim());
                        currentTurkishWord = "";
                    }

                    // If the line ends with "/ˈeɪ/", it is the start of a new English word
                    if (line.matches(".*\\/ˈeɪ\\/$")) {
                        if (!currentEnglishWord.isEmpty()) {
                            englishWords.add(currentEnglishWord.trim());
                        }
                        currentEnglishWord = line.replace("/ˈeɪ/", "").trim();
                    } else {
                        currentEnglishWord += " " + line.trim();
                    }
                }
            }

            // Add the last English and Turkish words to the ArrayLists
            if (!currentEnglishWord.isEmpty()) {
                englishWords.add(currentEnglishWord.trim());
            }
            if (!currentTurkishWord.isEmpty()) {
                turkishWords.add(currentTurkishWord.trim());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("English words: " + englishWords);
        System.out.println("Turkish words: " + turkishWords);
    }
}
