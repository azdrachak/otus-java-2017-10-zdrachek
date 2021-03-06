package com.github.azdrachak;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private int capacity = 8;
    private int size;
    private Object[] data;

    public int size() {
        return size;
    }

    public MyArrayList() {
        this.data = new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null && data[i] == null) {
                return true;
            }
            if (data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    @SuppressWarnings({"unchecked", "SuspiciousSystemArraycopy"})
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) return (T1[]) Arrays.copyOf(data, size, a.getClass());
        System.arraycopy(data, 0, a, 0, size);
        if (a.length > size) a[size] = null;
        return a;
    }

    public boolean add(T t) {
        ensureCapacity();
        data[size] = t;
        size++;
        return true;
    }

    public void add(int index, T element) {
        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null && data[i] == null) {
                remove(i);
                return true;
            }
            if (data[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        for (Object item : c) {
            remove(item);
        }
        return true;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends T> c) {
        for (T item : c) {
            add(item);
        }
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        int increment = 0;
        for (T item : c) {
            add(index + increment, item);
            increment++;
        }
        return true;
    }

    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        Object[] copy = new Object[size];
        System.arraycopy(data, 0, copy, 0, size);
        for (Object item : copy) {
            if (!c.contains(item)) {
                remove(item);
                changed = true;
            }
        }
        return changed;
    }

    public void clear() {
        size = 0;
        capacity = 8;
        data = new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        return (T) data[index];
    }

    @SuppressWarnings("unchecked")
    public T set(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        T previous = (T) data[index];
        data[index] = element;
        return previous;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        T elem = (T) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return elem;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = size - 1; size >= 0; i--) {
            if (data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    public ListIterator<T> listIterator() {
        return new ElementsIterator();
    }

    public ListIterator<T> listIterator(int index) {
        return new ElementsIterator(index);
    }

    @SuppressWarnings("unchecked")
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size) throw new IndexOutOfBoundsException();
        List<T> sub = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            sub.add((T) data[i]);
        }
        return sub;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (capacity == size) {
            capacity *= 2;
            T[] oldData = (T[]) data;
            data = new Object[capacity];
            System.arraycopy(oldData, 0, data, 0, oldData.length);
        }
    }

    private class ElementsIterator implements ListIterator<T> {
        int index;
        boolean lastCalled = false;
        int current;

        ElementsIterator() {
            this.index = 0;
        }

        ElementsIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return size > index;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastCalled = true;
            current = index;
            index++;
            return (T) MyArrayList.this.data[current];
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            lastCalled = true;
            current = index - 1;
            index--;
            return (T) MyArrayList.this.data[current];
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index > 0 ? index - 1 : -1;
        }

        @Override
        public void remove() {
            if (!lastCalled) throw new IllegalStateException();
            MyArrayList.this.remove(current);
            lastCalled = false;
            index--;
        }

        @Override
        public void set(T t) {
            if (!lastCalled) throw new IllegalStateException();
            MyArrayList.this.set(current, t);
        }

        @Override
        public void add(T t) {
            if (!hasPrevious()) {
                MyArrayList.this.add(0, t);
            } else if (!hasNext()) {
                MyArrayList.this.add(t);
            } else {
                MyArrayList.this.add(current, t);
            }
            index++;
        }


    }
}
