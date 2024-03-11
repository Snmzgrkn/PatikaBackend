package Week_04.ListWork;

import java.util.Arrays;

public class MyList <T>{
    private static final int defaultCapacity = 10;
    private Object[] array;
    private int size;

    public MyList() {
        this.array = new Object[defaultCapacity];
        this.size = 0;
    }
    public MyList(int capacity){
        this.array=new Object[capacity];
        this.size=0;
    }

    public int size() {
        return size;
    }
    public int getCapacity(){
        return array.length;
    }
    public void add(T data){
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
        array[size++]=data;
    }
    public T get(int index){
        if (index < 0 || index >= size){
            return null;
        }
        return (T) array[index];
    }

    public T remove(int index){
        if (index < 0 || index >= size){
            return null;
        }
        T removedData = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null; // En son elemanı null yaparak temizleme
        return removedData;
    }

    public T set(int index, T data) {
        if (index < 0 || index >= size) {
            return null;
        }
        T oldData = (T) array[index];
        array[index] = data;
        return oldData;
    }
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

}
