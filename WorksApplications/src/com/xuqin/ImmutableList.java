/**
 * 
 */
package com.xuqin;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImmutableList<T> implements Iterable<T> {
    @SuppressWarnings("unchecked")
    private final static ImmutableList NIL = new ImmutableList(null, null);

    public final T head;
    public final ImmutableList<T> tail;


    public ImmutableList(T head, ImmutableList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public ImmutableList<T> add(T t) {
        return new ImmutableList<T>(t, this);
    }

    public boolean isEmpty() {
        return this == NIL;
    }

    public ImmutableList<T> reverse() {
        ImmutableList<T> result = nil();
        for (T t : this) {
            result = result.add(t);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> ImmutableList<T> nil() {
        return NIL;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private ImmutableList<T> list = ImmutableList.this;

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T t = list.head;
                list = list.tail;
                return t;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}