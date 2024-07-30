public class TestDecoratorPattern {
    public static void main(String[] args) {
        // Create the base notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate with SMS notifier
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Decorate with Slack notifier
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notification via all channels
        slackNotifier.send("This is a test notification.");
    }
}

