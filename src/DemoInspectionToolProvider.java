import com.intellij.codeInspection.InspectionToolProvider;

/**
 * Created by Litash on 2/9/2017.
 */
public class DemoInspectionToolProvider implements InspectionToolProvider {
    public Class[] getInspectionClasses() {
        return new Class[]{DemoCodeInspection.class};
    }
}
