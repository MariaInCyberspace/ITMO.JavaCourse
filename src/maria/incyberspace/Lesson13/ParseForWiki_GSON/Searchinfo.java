package maria.incyberspace.Lesson13.ParseForWiki_GSON;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Searchinfo {

    @SerializedName("totalhits")
    @Expose
    private Integer totalhits;
    @SerializedName("suggestion")
    @Expose
    private String suggestion;
    @SerializedName("suggestionsnippet")
    @Expose
    private String suggestionsnippet;

    public Integer getTotalhits() {
        return totalhits;
    }

    public void setTotalhits(Integer totalhits) {
        this.totalhits = totalhits;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getSuggestionsnippet() {
        return suggestionsnippet;
    }

    public void setSuggestionsnippet(String suggestionsnippet) {
        this.suggestionsnippet = suggestionsnippet;
    }

}
