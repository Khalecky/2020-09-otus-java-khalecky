package my.homeworks.hw02.DiyArrayList;

import java.util.ListIterator;

public class DiyListIterator<T> implements ListIterator<T>
{
    private int index = -1;

    private DiyArrayList<T> diyArrayList;

    public DiyListIterator(DiyArrayList<T> diyArrayList)
    {
        this.diyArrayList = diyArrayList;
    }

    @Override
    public boolean hasNext()
    {
        return index + 1 < diyArrayList.size();
    }

    private void incrIndex()
    {
        ++index;
    }

    @Override
    public T next() {
        if (hasNext()) {
            incrIndex();
            return diyArrayList.get(index);
        }
        return null;
    }

    @Override
    public boolean hasPrevious()
    {
        return previousIndex() >= 0;
    }

    @Override
    public T previous() {
        decrIndex();
        return diyArrayList.get(index);
    }

    private void decrIndex()
    {
        if (index >= 0) {
            --index;
        }
    }

    @Override
    public int nextIndex() {
        return index + 1;
    }

    @Override
    public int previousIndex() {
        return index - 1;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(T t)
    {
        diyArrayList.set(index, t);
    }

    @Override
    public void add(T t) {

    }
}
