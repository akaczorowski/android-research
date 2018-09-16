import java.util.Locale;
import java.util.regex.Pattern;

/*

Use this class for character normalization. 
    Case-insensitive
        querying “SaN FranCiscO”, you expect “San Francisco” as a result.
    Accented characters.
        non-accented queries matches accented data. For instance, querying “ceci” should match “[Céci]le”
*/
public final class Normalizer {

    private static final Pattern PATTERN_DIACRITICS = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    private static final Pattern PATTERN_NON_LETTER_DIGIT_TO_SPACES = Pattern.compile("[^\\p{L}\\p{Nd}]");

    private Normalizer() {
        //no instance
    }

    public static final String forSearch(CharSequence searchTerm) {
        if (searchTerm == null) {
            return null;
        }
        String result = java.text.Normalizer.normalize(searchTerm, java.text.Normalizer.Form.NFD);
        result = PATTERN_DIACRITICS.matcher(result).replaceAll("");
        result = PATTERN_NON_LETTER_DIGIT_TO_SPACES.matcher(result).replaceAll(" ");
        return result.toLowerCase(Locale.ROOT);
    }
}