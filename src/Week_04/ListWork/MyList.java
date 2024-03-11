package Week_04.ListWork;

import java.util.Arrays;

public class MyList <T>{
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MyList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Kapasite negatif olamaz.");
        }
        this.array = new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }

    public void add(T data) {
        ensureCapacity();
        array[size++] = data;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T removedData = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        return removedData;
    }

    @SuppressWarnings("unchecked")
    public T set(int index, T data) {
        if (index < 0 || index >= size) {
            return null;
        }
        T oldData = (T) array[index];
        array[index] = data;
        return oldData;
    }

    public T[] toArray() {
        return (T[]) Arrays.copyOf(array, size);
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || start >= size || finish < 0 || finish >= size || start > finish) {
            throw new IllegalArgumentException("Geçersiz indeks aralığı");
        }

        MyList<T> subList = new MyList<>();
        subList.array = Arrays.copyOfRange(array, start, finish + 1);
        subList.size = finish - start + 1;

        return subList;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}
