package completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Litash on 2/16/2017.
 */
public class CompletionContributor extends com.intellij.codeInsight.completion.CompletionContributor {
    public CompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), new CompletionProvider<CompletionParameters>() {

            protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext context, @NotNull CompletionResultSet result) {
                // When completion is invoked, copy the file being edited
                PsiElement psiElement = completionParameters.getOriginalPosition();
                LookupElement resultElements;
                if (psiElement != null) {
                    resultElements = new LookupElement() {
                        @NotNull
                        @Override
                        public String getLookupString() {
                            return "THERE ARE SOMETHING";
                        }
                    };
                }else{
                    resultElements = new LookupElement() {
                        @NotNull
                        @Override
                        public String getLookupString() {
                            return "Hahaha";
                        }
                    };
                }
                result.addElement(resultElements);
                result.addLookupAdvertisement("Hahaha");
            }
        });
    }

    public void beforeCompletion(@NotNull CompletionInitializationContext context) {
        context.setDummyIdentifier("Yoo");
    }
}
