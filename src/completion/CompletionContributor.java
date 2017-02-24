package completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementFactory;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiReference;
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
                PsiElement psiElementP = completionParameters.getPosition();

                System.out.println("Element with OriginalPosition: "+psiElement);
                System.out.println("Element with Position: "+psiElementP);

                System.out.println("prefix: "+result.getPrefixMatcher().getPrefix());


                LookupElement resultElements;

                System.out.println("CompletionType: "+completionParameters.getCompletionType());
                if (psiElement != null) {
                    resultElements = new LookupElement() {
                        @NotNull
                        public String getLookupString() {
                            return "THERE ARE SOMETHING";
                        }
                    };
                    result.addElement(resultElements);
                }

                System.out.println("psiElement Text: "+psiElement.getText());
                if (psiElement.getText().equals("Haha")){
                    resultElements = new LookupElement() {
                        @NotNull
                        public String getLookupString() {
                            return "Found Haha";
                        }
                    };
                    result.addElement(resultElements);
                }else if (psiElement.getText().equals("Yoo")){
                    resultElements = new LookupElement() {
                        @NotNull
                        public String getLookupString() {
                            return "Found Yoo";
                        }
                    };
                    result.addElement(resultElements);
                }

//                result.addLookupAdvertisement("This is suggestion list");
            }
        });
    }

    public void beforeCompletion(@NotNull CompletionInitializationContext context) {
        context.setDummyIdentifier("Yoo");
    }
}
