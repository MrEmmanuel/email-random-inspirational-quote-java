import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quotes {
    private String author;
    private String quote;
    private String path;
    private List<String> quotes;

    public Quotes(String filePath) {
        this.path = filePath;
    }
    public Quotes(String author, String quote) {
        this.author = author;
        this.quote = quote;
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

    public String getAuthor() {
        return author;
    }
    public String getQuote() {
        return quote;
    }
}
