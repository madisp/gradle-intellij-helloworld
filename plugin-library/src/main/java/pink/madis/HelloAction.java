package pink.madis;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class HelloAction extends AnAction {
  @Override
  public void actionPerformed(AnActionEvent e) {
    // just send "Hello World" to the event log
    Notifications.Bus.notify(new Notification(
        "hello",
        "Hello World!",
        "Hello world from the hello plugin",
        NotificationType.INFORMATION
    ));
  }
}
