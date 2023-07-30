package com.Graduation.TeacherAssistantProject.Scheduling.Models;

import java.util.PriorityQueue;

public class GenericPriorityQueue<T> {
    private class QueueEntry<T> implements Comparable<QueueEntry<T>> {
        private T value;
        private double priority;

        public QueueEntry(T value, double priority) {
            this.value = value;
            this.priority = priority;
        }

        @Override
        public int compareTo(QueueEntry<T> other) {
            // Implement comparison based on priorities (smaller priority is higher)
            return Double.compare(this.priority, other.priority);
        }
    }

    private PriorityQueue<QueueEntry<T>> priorityQueue;

    public GenericPriorityQueue() {
        // Use custom QueueEntry's compareTo method to compare priorities
        this.priorityQueue = new PriorityQueue<>();
    }

    public void enqueue(T value, double priority) {
        QueueEntry<T> entry = new QueueEntry<>(value, priority);
        priorityQueue.offer(entry);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return priorityQueue.poll().value;
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    public int size() {
        return priorityQueue.size();
    }
}