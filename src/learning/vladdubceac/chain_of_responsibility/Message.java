package learning.vladdubceac.chain_of_responsibility;

public class Message {
    private String text;
    private MessagePriority messagePriority;

    public Message(String text, MessagePriority messagePriority) {
        this.text = text;
        this.messagePriority = messagePriority;
    }

    public String getText() {
        return text;
    }

    public MessagePriority getMessagePriority() {
        return messagePriority;
    }
}
