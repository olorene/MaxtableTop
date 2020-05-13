package Comparator;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;


public class Message {
    private String message;
    private int id;

    public static void main(String []args){
        List<Message> messages = new ArrayList();
        messages.add(new Message("Hello, World!"));
        messages.add(new Message("Hello, Sun!"));
        System.out.println(messages);
    }

    public Message(String message) {
        this.message = message;
        this.id = new Random().nextInt(1000);
    }
    public String getMessage() {
        return message;
    }
    public Integer getId() {
        return id;
    }
    public String toString() {
        return "[" + id + "] " + message;
    }
}
