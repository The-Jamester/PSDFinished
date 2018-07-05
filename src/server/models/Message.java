package server.models;
import org.json.simple.JSONObject;

import java.util.ArrayList;


public class Message {
    private int id;
    private String msgText;
    private String datePosted;
    private String author;

    public static ArrayList<Message>msgContent = new ArrayList<Message>();

    public Message(int id, String msgText, String datePosted, String author) {
        this.id = id;
        this.msgText = msgText;
        this.datePosted = datePosted;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msgText='" + msgText + '\'' +
                ", datePosted='" + datePosted + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static int nextId() {
        int id=0;
        for(Message m: msgContent) {
            if( m.getId() > id) {
                id=m.getId();
            }
        }
        return id+1;
    }
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject j = new JSONObject();
        j.put("id", getId());
        j.put("text", getMsgText());
        j.put("postDate", getDatePosted());
        j.put("author", getAuthor());
        return j;
    }

}
