package completion;

import com.intellij.codeInsight.lookup.LookupElement;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by Litash on 3/10/2017.
 */
public class LookupElementSorter {
    ArrayList<LookupElementUtil> lookupElements = new ArrayList<LookupElementUtil>();
    public LookupElementSorter(ArrayList<LookupElementUtil> lookupElements) {
        this.lookupElements = lookupElements;
    }

    public ArrayList<LookupElementUtil> getSortedJobLookupElementByTailText() {
        Collections.sort(lookupElements, LookupElementUtil.tailTextComparator);
        return lookupElements;
    }
}
