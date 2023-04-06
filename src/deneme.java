public class deneme {
    /*try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            String currentEnglishWord = "";
            String currentTurkishWords = "";

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.endsWith("/ˈeɪ/")) {
                    // this is the end of the previous word and the beginning of the Turkish words
                    String[] parts = line.split("/ˈeɪ/");
                    if (parts.length >= 2) {
                        currentEnglishWord = parts[0].trim();
                        currentTurkishWords = parts[1].trim();
                    }
                } else if (!line.isEmpty()) {
                    // this is a line containing Turkish words for the current English word
                    currentTurkishWords += ", " + line;
                } else {
                    // this is an empty line, which indicates the end of the Turkish words for the current English word
                    englishWords.add(currentEnglishWord);
                    turkishWords.add(currentTurkishWords);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } */
}
