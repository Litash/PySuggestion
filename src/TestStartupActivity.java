import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
/**
 * Created by Litash on 2/9/2017.
 */
public class TestStartupActivity implements StartupActivity{
    @Override
    public void runActivity(Project project) {
        // This code is executed after the project was opened.
        System.out.println("Hello World! Loaded project: " + project.getName());
    }
}
