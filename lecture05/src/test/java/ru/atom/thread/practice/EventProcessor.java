package ru.atom.thread.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author apomosov
 * @since 15.03.17
 */
public class EventProcessor {
    public static void produceEvents(List<EventProducer> eventProducers) {
        List<Thread> threads = new ArrayList<>(eventProducers.size());
        eventProducers.forEach(p -> threads.add(new Thread(p)));
        threads.forEach(t -> t.start());
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static long countTotalNumberOfGoodEvents() {
        return EventQueue.getInstance()
                .stream()
                .filter(event -> event.getEventType().equals(Event.EventType.GOOD))
                .count();
    }

    public static long countTotalNumberOfBadEvents() {
        return EventQueue.getInstance()
                .stream()
                .filter(event -> event.getEventType().equals(Event.EventType.BAD))
                .count();
    }
}
