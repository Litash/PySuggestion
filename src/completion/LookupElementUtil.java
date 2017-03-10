package completion;

import com.intellij.codeInsight.lookup.LookupElement;

import java.util.Comparator;

/**
 * Created by Litash on 3/10/2017.
 */
public class LookupElementUtil {
    private LookupElement lookupElement;
    private String tailText;
    private String lookupString;

    public LookupElementUtil(LookupElement lookupelement, String tailText) {
        this.lookupElement = lookupelement;
        this.tailText = tailText;
        this.lookupString = lookupelement.getLookupString();
    }

    public LookupElement getLookupElement() {
        return lookupElement;
    }

    public String getTailText() {
        return tailText;
    }

    public String getLookupString() {
        return lookupString;
    }

    public void setTailText(String tailText) {
        this.tailText = tailText;
    }

    public void setLookupString(String lookupString) {
        this.lookupString = lookupString;
    }

    public static Comparator<LookupElementUtil> tailTextComparator = new Comparator<LookupElementUtil>() {
        @Override
        public int compare(LookupElementUtil leu1, LookupElementUtil leu2) {
            return (int) (leu1.getTailText().compareTo(leu2.getTailText()));
        }
    };

    @Override
    public String toString() {
        return " LookupString: " + this.lookupString + ", TailText: " + this.tailText;
    }
}
