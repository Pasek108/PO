package Kanban;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Observer {
    Kanban subscriber;
    public static Observer observer = new Observer();

    public Observer() {}

    public void addSubscriber(Kanban subscriber) {
        this.subscriber = subscriber;
    }

    public void sendDataToSubscriber(String title, int priority, Calendar date) {
        this.subscriber.addTask(title, priority, date);
    }
}
