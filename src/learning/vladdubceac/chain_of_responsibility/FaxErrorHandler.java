package learning.vladdubceac.chain_of_responsibility;

public class FaxErrorHandler implements ReceiverInterface {
    public static final String KEYWORD = "fax";
    ReceiverInterface nextHandler;

    @Override
    public boolean processMessage(Message message) {
        String text = message.getText();
        MessagePriority priority = message.getMessagePriority();
        if(text.toLowerCase().contains(KEYWORD)){
            System.out.println("FaxErrorHandler processed "+priority+" priority issue : "+text);
            return true;
        }else{
           return nextHandler.processMessage(message);
        }
    }

    @Override
    public void setNextChain(ReceiverInterface nextChain) {
        nextHandler = nextChain;
    }
}
