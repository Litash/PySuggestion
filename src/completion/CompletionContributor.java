package completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.lookup.LookupElementPresentation;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Litash on 2/16/2017.
 */
public class CompletionContributor extends com.intellij.codeInsight.completion.CompletionContributor {
    public CompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), new CompletionProvider<CompletionParameters>() {

            protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext context, @NotNull CompletionResultSet result) {
                // When completion is invoked, copy the file being edited
                PsiElement psiElement = completionParameters.getOriginalPosition();
                PsiElement psiElementP = completionParameters.getPosition();

                System.out.println("Element with OriginalPosition: "+psiElement);
                System.out.println("Element with Position: "+psiElementP);

                System.out.println("prefix: "+result.getPrefixMatcher().getPrefix());

                // dummy string for building suggestion item list (simulating result provided by the model)
                String[] dummyString1 = new String[]{"Hohoho", "I", "found", "something", "haha this is a long sentence"};
                String[] dummyProb = new String[]{"0.99", "0.52", "0.60", "0.21", "0.3"};
                String[] dummyString2 = new String[]{"How", "do I", "implement", "code completion", "How do I implement code completion without a keyword?"};

                ArrayList<LookupElementUtil> LookupEleArray = new ArrayList<LookupElementUtil>();

                System.out.println("CompletionType: "+completionParameters.getCompletionType());

                // custom LookupPresentation
                LookupElementPresentation presentation = new LookupElementPresentation();


                if (psiElement != null) {
                    System.out.println("Comparing with token: "+psiElement.getText());
                    for (int i=0; i<dummyString1.length; i++){
                        // create LookupElement based on the given string array
                        LookupElementBuilder lookupEleBuilder = LookupElementBuilder.create(dummyString1[i]).withTailText("    "+dummyProb[i]+" PySuggestion", true);
                        LookupElementUtil leu = new LookupElementUtil(lookupEleBuilder, dummyProb[i]);

                        // add newly created LookupElement into the LookupElement ArrayList

                        LookupEleArray.add(leu);
                    }
                    LookupElementSorter leuSorter = new LookupElementSorter(LookupEleArray);
                    ArrayList<LookupElementUtil> sortedLookupEleArray = leuSorter.getSortedJobLookupElementByTailText();

                    ArrayList<LookupElement> leList = new ArrayList<LookupElement>();
                    for (LookupElementUtil l : sortedLookupEleArray){
                        leList.add(l.getLookupElement());
                    }

                    result.addAllElements(leList);

                }
//                else{
//                    System.out.println("Comparing with token: "+psiElement.getText());
//                    for (int i=0; i<dummyString2.length; i++){
//                        String s = dummyString2[i];
//                        presentation.setTailText(dummyProb[i]);
//                        // create LookupElement based on the given string array
//                        LookupElementBuilder lookupEleBuilder = LookupElementBuilder.create(s);
//                        lookupEleBuilder.renderElement(presentation);
//                        // add newly created LookupElement into the LookupElement ArrayList
//                        LookupEleArray.add(lookupEleBuilder);
//                    }
//                    result.withRelevanceSorter(CompletionSorter.emptySorter()).addAllElements(LookupEleArray);
//                }
                // change the text at the bottom of the suggestion list
                result.addLookupAdvertisement("PySuggestion");
            }
        });


    }

//    @Override
//    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result){
//
//    }

    public void beforeCompletion(@NotNull CompletionInitializationContext context) {
        context.setDummyIdentifier("Yoo");
    }
}
