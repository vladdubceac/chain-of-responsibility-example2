package learning.vladdubceac.chain_of_responsibility;

public class ChainOfResponsibilityPatternEx {

    public static void main(String[] args) {
        System.out.println("*** Chain of Responsibility Pattern Demo ***");

        AuthenticationErrorHandler authenticationErrorHandler = new AuthenticationErrorHandler();
        EmailErrorHandler emailErrorHandler = new EmailErrorHandler();
        ReceiverInterface faxErrorHandler = new FaxErrorHandler();
        faxErrorHandler.setNextChain(emailErrorHandler);

        IssueRaiser issueRaiser = new IssueRaiser(faxErrorHandler);
        Message message1 = new Message("Fax is reaching late to the destination", MessagePriority.NORMAL);
        Message message2 = new Message("Email is not going", MessagePriority.HIGH);
        Message message3 = new Message("In Email, BCC field is disabled occasionally", MessagePriority.NORMAL);
        Message message4 = new Message("Fax is not reaching destination", MessagePriority.HIGH);
        Message message5 = new Message("Authentication error", MessagePriority.HIGH);

        issueRaiser.raiseMessage(message1);
        issueRaiser.raiseMessage(message2);
        issueRaiser.raiseMessage(message3);
        issueRaiser.raiseMessage(message4);
        issueRaiser.raiseMessage(message5);
        emailErrorHandler.setNextChain(authenticationErrorHandler);
        issueRaiser.raiseMessage(message5);
    }
}
