// DecoratorPatternDemo.java
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Create a basic EmailNotifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate EmailNotifier with SMS and Slack capabilities
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send a message using the decorated notifier
        slackNotifier.send("Hello, this is a test message!");
    }
}
