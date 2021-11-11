package maria.incyberspace.Lesson13.ParseForWiki_GSON;

import java.util.Locale;

public class CustomiseURL {
    private String url = "https://en.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=";

    public String getCustomisedWikiUrl(String s) {
        StringBuilder sb = new StringBuilder(url);
        return sb.append(transform(s)).toString();
    }

    private String transform(String s) {
        return s.toLowerCase(Locale.ROOT).replace(" ", "_");
    }
}
