import com.intellij.codeInspection.*;
import org.jetbrains.annotations.*;

/**
 * Created by Litash on 2/9/2017.
 */
public class DemoCodeInspection extends LocalInspectionTool {
    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return "Demo Inspection";
    }

    @NotNull
    @Override
    public DemoInspectionVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new DemoInspectionVisitor();
    }
}
