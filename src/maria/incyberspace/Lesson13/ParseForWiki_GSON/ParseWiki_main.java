package maria.incyberspace.Lesson13.ParseForWiki_GSON;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class ParseWiki_main {
    public interface SuccessfulSearchListener {
        void onError();
        void onDownload();
    }
    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you wish to search for, you know-it-all?");
        String search = scanner.nextLine();
        // Customise the URL based on user input
        URL url = new URL(new CustomiseURL().getCustomisedWikiUrl(search));
        // A listener that would tell us when the search executes
        SuccessfulSearchListener listener = new SuccessfulSearchListener() {
            @Override
            public void onError() {
                System.out.println("An error occurred.");
            }

            @Override
            public void onDownload() {
                System.out.println("All done! Listener did well, eh?");
            }
        };
        new Thread(() -> {
            try (InputStreamReader inputStreamReader = new InputStreamReader(url.openStream())) {
                StringBuilder response = new StringBuilder();
                ParseWiki jsonObj = new Gson().fromJson(inputStreamReader, ParseWiki.class);
                Query query = jsonObj.getQuery();
                // Get main title of this article and append it to the StringBuilder
                response.append(query.getSearch().get(0).getTitle()).append("\n\n");
                // Append other titles and snippets from this article
                query.getSearch().forEach((m) -> response.append(m.getTitle() + ":\n" + m.getSnippet() + "\n\n"));
                System.out.println("You searched for \"" + search + "\". Here's what I found: \n\n" + response);
                listener.onDownload(); // Success
            } catch (IOException e) {
                e.printStackTrace();
                listener.onError(); // Failure
            }
        }).start();
    }
}

