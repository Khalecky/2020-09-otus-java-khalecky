package my.homeworks.hw02.DiyArrayList;

import java.util.*;

public class DiyArrayList<T> implements List<T>
{
    private T[] storage;

    public DiyArrayList()
    {
    }

    @Override
    public int size()
    {
        return storage == null? 0 : storage.length;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        return new DiyIterator(this);
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(storage, storage.length);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T t)
    {
        extendStorage();
        storage[storage.length - 1] = t;
        return true;
    }

    private void extendStorage()
    {
        if (storage == null) {
            storage = (T[]) new Object[1];
        } else {
            storage = Arrays.copyOf(storage, storage.length + 1);
        }
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t: c) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T get(int index)
    {
        return storage[index];
    }

    @Override
    public T set(int index, T element) {
        storage[index] = element;
        return element;
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator()
    {
        return new DiyListIterator<>(this);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

}
