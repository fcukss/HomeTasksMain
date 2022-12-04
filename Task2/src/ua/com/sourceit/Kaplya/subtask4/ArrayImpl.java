package ua.com.sourceit.Kaplya.subtask4;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayImpl implements Array {

    Object[] array = new Object[0];

    @Override
    public void add(Object element) {
        Object[] arrayTemp = new Object[array.length + 1];
        for (int i = 0; i < arrayTemp.length; i++) {
            if (i == arrayTemp.length - 1) {
                arrayTemp[i] = element;
            } else {
                arrayTemp[i] = array[i];
            }
        }
        array = new Object[arrayTemp.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayTemp[i];
        }
    }

    @Override
    public void set(int index, Object element) {

        if (index < 0)
            throw new NoSuchElementException("введите индекс больше 0");

        if (index < array.length) {
            for (int i = 0; i < array.length; i++) {
                if (i == index)
                    array[i] = element;
            }
        } else {
            Object[] arrayTemp = new Object[array.length + 1];
            for (int i = 0; i < arrayTemp.length; i++) {
                if (i == index) {
                    arrayTemp[i] = element;
                } else {
                    arrayTemp[i] = array[i];
                }
            }
            array = new Object[arrayTemp.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = arrayTemp[i];
            }
        }
    }


    @Override
    public Object get(int index) {
        if (index<0 || index>=array.length)
            throw new NoSuchElementException("нет елемента в массиве");
        return array[index];
    }

    @Override
    public int indexOf(Object element) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                index = i;
              break;
            } else {
                index = -1;
            }
        }
        return index;
    }

    @Override
    public void remove(int index) {
        if (index<0 || index>=array.length)
            throw new NoSuchElementException("нет елемента в массиве");

        Object[] arrRemove = new Object[array.length - 1];
        int current = 0;

        for (int i = 0; i < array.length; i++) {
            if (i != index) {
                arrRemove[current] = array[i];
                current++;
            }
        }

        array = new Object[arrRemove.length];

        for (int i = 0; i < arrRemove.length; i++) {
            array[i] = arrRemove[i];
        }
    }

    @Override
    public void clear() {
        if (array != null)
            array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public IteratorImpl iterator() {
        return new IteratorImpl();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) sb.append(array[i]);
            else sb.append(array[i]).append(", ");
        }

        return "[" + sb.toString() + "]";
    }

    class IteratorImpl implements Iterator<Object> {
        int current = 0;

        @Override
        public boolean hasNext() {
            if (array == null || array.length == 0)
                throw new NoSuchElementException("нет елементов в массиве");

            return array[current + 1] != null;
        }

        @Override
        public Object next() {
            if (array == null || array.length == 0)
                throw new NoSuchElementException("нет елементов в массиве");
            return array[current++];
        }

        @Override
        public void remove() {
            if (array == null || array.length == 0)
                throw new NoSuchElementException("нет елементов в массиве");

            int newLength = size() - 1;
            Object[] arrRemove = new Object[newLength];

            for (int i = 0; i < size(); i++) {
                if (i != current - 1) {
                    arrRemove[i < current - 1 ? i : i - 1] = array[i];
                }
            }
            array = arrRemove;
            current--;
        }
    }

    public static void main(String[] args) {

        Array array = new ArrayImpl();
        array.add("A");
        array.add("B");
        array.add("D");
        System.out.println(array);

        array.set(0, "D");
        System.out.println(array);
        System.out.println(array.get(0));
        System.out.println(array.indexOf("D"));
        System.out.println("**************");
        array.remove(2);
        System.out.println(array.size());
        System.out.println(array);
        array.clear();
        System.out.println(array);
        System.out.println("**************");

        array.add("A");
        array.add("B");
        array.add("D");

        Iterator iterator = array.iterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(array);

    }
}
