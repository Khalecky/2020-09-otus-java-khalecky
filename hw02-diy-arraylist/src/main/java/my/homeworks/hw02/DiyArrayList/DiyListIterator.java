package my.homeworks.hw02.DiyArrayList;

import java.util.ListIterator;

public class DiyListIterator<T> extends DiyIterator<T> implements ListIterator<T>
{

    public DiyListIterator(DiyArrayList<T> diyArrayList)
    {
        super(diyArrayList);
    }

    @Override
    public boolean hasPrevious()
    {

        return previousIndex() >= 0;
    }

    @Override
    public T previous() {
        decrIndex();
        return at(index);
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
