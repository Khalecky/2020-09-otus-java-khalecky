package my.homeworks.hw02.DiyArrayList;

import java.util.Iterator;

public class DiyIterator<T> implements Iterator<T>
{
    protected int index = -1;

    protected DiyArrayList<T> diyArrayList;

    public DiyIterator(DiyArrayList<T> diyArrayList)
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
            return at(index);
        }
        return null;
    }

    protected T at(int index)
    {
        return diyArrayList.get(index);
    }
}
