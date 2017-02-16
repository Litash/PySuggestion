package completion; /**
 * Created by Litash on 2/15/2017.
 */
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;


public class CompletionContributor extends com.intellij.codeInsight.completion.CompletionContributor {
    public CompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext processingContext, @NotNull CompletionResultSet completionResultSet) {

                PsiElement psiElement = completionParameters.getOriginalPosition();
                if (psiElement == null ) {
                    return;
                }

                CompletionContributorParameter parameter = null;

                for(GotoCompletionContributor contributor: GotoCompletionUtil.getContributors(psiElement)) {
                    GotoCompletionProviderInterface formReferenceCompletionContributor = contributor.getProvider(psiElement);
                    if(formReferenceCompletionContributor != null) {
                        completionResultSet.addAllElements(
                                formReferenceCompletionContributor.getLookupElements()
                        );

                        if(parameter == null) {
                            parameter = new CompletionContributorParameter(completionParameters, processingContext, completionResultSet);
                        }

                        formReferenceCompletionContributor.getLookupElements(parameter);
                    }
                }

            }
        });
    }
}
