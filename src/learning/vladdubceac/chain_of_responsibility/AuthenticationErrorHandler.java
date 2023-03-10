package learning.vladdubceac.chain_of_responsibility;

public class AuthenticationErrorHandler implements ReceiverInterface {
    public static final String KEYWORD = "authentication";
    private ReceiverInterface nextChain;

    @Override
    public boolean processMessage(Message message) {
        String text = message.getText();
        MessagePriority priority = message.getMessagePriority();
        if (text.toLowerCase().contains(KEYWORD)) {
            System.out.println("AuthenticationErrorHandler processed the " + priority + " priority issue : " + text);
            return true;
        } else {
            if (nextChain != null) {
                return nextChain.processMessage(message);
            } else {
                System.out.println("Cannot handle the issue with " + priority + " priority : " + text + " ! ");
                return false;
            }
        }
    }

    @Override
    public void setNextChain(ReceiverInterface nextChain) {
        this.nextChain = nextChain;
    }
}
