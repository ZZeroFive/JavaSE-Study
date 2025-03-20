package ml.generic.study;

public class MyList<T> {

    private Object[] elements;
    private int length;
    private int index;

    public MyList() {
    }

    public void add(T t) {
        if (this.length == 0) {
            elements = new Object[128];
            this.length = 128;
            this.index = 0;
        }
        this.elements[this.index] = t;
        this.index++;
    }

    public T get(int index) {
        if (index > this.index) {
            throw new IndexOutOfBoundsException();
        }
        return (T)this.elements[index];
    }
}
