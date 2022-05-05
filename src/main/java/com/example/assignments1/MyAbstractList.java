package HomeWorks;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0; // The size of the list


    protected MyAbstractList() {
    }


    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }


    public void add(E e) {
        add(size, e);
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else
            return false;
    }


    public boolean retainAll(MyList<E> otherList) {
        int lastSize = size;

        this.forEach(item -> {
            if (!otherList.contains(item)) {
                remove(item);
            }
        });
        return lastSize != size;
    }


    public boolean removeAll(MyList<E> otherList) {
        int lastSize = size;
        otherList.forEach(this::remove);
        return lastSize != size;
    }


    public boolean addAll(MyList<E> otherList) {
        int lastSize = size;
        otherList.forEach(this::add);
        return lastSize != size;
    }
}
