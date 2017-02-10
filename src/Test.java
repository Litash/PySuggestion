import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * Created by Litash on 1/24/2017.
 */
public class Test extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        System.out.println("Menu item clicked!" + e.getPlace());
    }
}
