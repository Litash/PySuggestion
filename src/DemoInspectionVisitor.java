import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiPlainTextFile;

/**
 * Created by Litash on 2/9/2017.
 */
public class DemoInspectionVisitor extends PsiElementVisitor {
    @Override
    public void visitElement(PsiElement element) {
        super.visitElement(element);
    }

    @Override
    public void visitPlainTextFile(PsiPlainTextFile file) {
        super.visitPlainTextFile(file);
    }
}
