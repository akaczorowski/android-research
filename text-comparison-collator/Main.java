import java.text.Collator;
import java.util.Locale;

import static java.text.Collator.CANONICAL_DECOMPOSITION;
import static java.text.Collator.NO_DECOMPOSITION;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Get the Collator for US English and set its strength to PRIMARY
        Collator usCollator = Collator.getInstance(Locale.US);
        usCollator.setStrength(Collator.PRIMARY);
        if (usCollator.compare("abc", "ABC") == 0) {
            System.out.println("Strings are equivalent");
        }

        //The following example shows how to compare two strings using the
        //Collator for the default locale.

        // Compare two strings in the default locale
        Collator myCollator = Collator.getInstance();
        myCollator.setDecomposition(NO_DECOMPOSITION);
        if (myCollator.compare("à\u0325", "a\u0325̀") != 0) {
            System.out.println("à\u0325 is not equals to a\u0325̀ without decomposition");
            myCollator.setDecomposition(CANONICAL_DECOMPOSITION);
            if (myCollator.compare("à\u0325", "a\u0325̀") != 0) {
                System.out.println("Error: à\u0325 should be equals to a\u0325̀ with decomposition");
            } else {
                System.out.println("à\u0325 is equals to a\u0325̀ with decomposition");
            }
        } else {
            System.out.println("Error: à\u0325 should be not equals to a\u0325̀ without decomposition");
        }
    }
}
