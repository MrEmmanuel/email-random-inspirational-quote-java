import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quotes {
    private String path;
    private List<String> quotes;

    public Quotes(String filePath) {
        this.path = filePath;
    }

    public void readQuotesFromFile() throws FileNotFoundException {
        this.quotes = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            quotes.add(line);
        }
        scanner.close();
    }

    public List<String> getQuotes() {
        return quotes;
    }
}
