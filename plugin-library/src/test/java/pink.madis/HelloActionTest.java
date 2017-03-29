package pink.madis;

import com.intellij.notification.Notification;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.testFramework.IdeaTestCase;
import com.intellij.testFramework.TestActionEvent;
import com.intellij.util.messages.MessageBusConnection;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class HelloActionTest extends IdeaTestCase {
  public void testSanity() {
    assertTrue(true);
  }

  @Override
  public void setUp() throws Exception {
    super.setUp();
  }

  public void testAction() throws Exception {
    HelloAction hello = new HelloAction();

    // set up a completable future for our notification
    CompletableFuture<Object[]> future = new CompletableFuture<>();
    MessageBusConnection conn = ApplicationManager.getApplication().getMessageBus().connect();
    conn.setDefaultHandler((event, params) -> future.complete(params));
    conn.subscribe(Notifications.TOPIC);

    // perform the action
    hello.actionPerformed(new TestActionEvent(hello));

    // wait for the notification to be posted on the bus
    Object[] params = future.get(1, TimeUnit.SECONDS);

    // assert a few things about our notification
    assertNotNull(params);
    assertTrue(params.length > 0);
    assertTrue(params[0] instanceof Notification);
    assertEquals("Hello World!", ((Notification) params[0]).getTitle());
  }
}
