package learning.vladdubceac.chain_of_responsibility;

public class IssueRaiser {
    ReceiverInterface receiver;

    public IssueRaiser(ReceiverInterface receiver) {
        this.receiver = receiver;
    }

    public void raiseMessage(Message message){
        if(receiver!=null) {
            receiver.processMessage(message);
        }
    }
}
