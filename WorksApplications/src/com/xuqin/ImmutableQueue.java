/**
 * 
 */
package com.xuqin;

import java.util.NoSuchElementException;

public class ImmutableQueue<T> {

    private final ImmutableList<T> front;
    private final ImmutableList<T> back;


    private ImmutableQueue(ImmutableList<T> front, ImmutableList<T> back) {
        this.front = front;
        this.back = back;
    }

    public static <T> ImmutableQueue<T> empty() {
        return new ImmutableQueue<T>(ImmutableList.<T>nil(), ImmutableList.<T>nil());
    }

    public boolean isEmpty() {
        return front.isEmpty() && back.isEmpty();
    }

    public ImmutableQueue<T> enqueue(T t) {
        return new ImmutableQueue<T>(front.add(t), back);
    }

    public DequeueResult<T> dequeue(T t) {
        if (isEmpty()) throw new NoSuchElementException();
        if (back.isEmpty()) {
            ImmutableList<T> tnorf = front.reverse();
            return new DequeueResult<T>(tnorf.head, new ImmutableQueue<T>(ImmutableList.<T>nil(), tnorf.tail));
        } else {
           return new DequeueResult<T>(back.head, new ImmutableQueue<T>(front, back.tail));
        }
    }

    //Sorry, no tuples in Java land...
    public static class DequeueResult<T> {
        public final T t;
        public final ImmutableQueue<T> queue;

        public DequeueResult(T t, ImmutableQueue<T> queue) {
            this.t = t;
            this.queue = queue;
        }
    }
}