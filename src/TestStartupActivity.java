import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Litash on 2/9/2017.
 */
public class TestStartupActivity implements StartupActivity{
    public void runActivity(@NotNull Project project) {
        // This code is executed after the project was opened.
        System.out.println("Hello World! Loaded project: " + project.getName());
    }
}
