package deque;

import afu.org.checkerframework.checker.igj.qual.I;

public class ArrayDeque<T> {
    private int size;
    private T[] items;
    public int nextFirst;
    public int nextLast;
    private void resize(int capacity){
//        Item[] a = (Item[]) new Object[capacity];
//        System.arraycopy(items, 0, a, 0, size);
//        items = a;

        T[] a = (T[]) new Object[capacity];
        int current = plusOne(nextFirst);
        for (int i = 0; i < size; i++){
            a[i] = items[current];
            current = plusOne(current);
        }
        nextFirst = capacity - 1;
        nextLast = size;

    }
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }
    private int minusOne(int index){
        return (index - 1 + items.length) % items.length;
    }
    private int plusOne(int index){
        return (index + 1) % items.length;
    }
    public void addFirst(T x){
//        if (size == items.length){
//            resize(size * 2);
//        }
//
//        for (int i = size; i > 0; i--){
//            items[i] = items[i - 1];
//        }
//        items[0] = x;
//        size ++;
        if (size == items.length){
            resize(size * 2);
        }
        items[nextFirst] = x;
        nextFirst = minusOne(nextFirst);
        size ++;
//        nextLast =

    }

    public void addLast(T x){
        if (size == items.length){
            resize(size * 2);
        }
//        items[size - 1] = x;这个是刻舟求剑，是错的
        items[nextLast] = x;
        nextLast = plusOne(nextLast);
        size ++;
    }
    public boolean isEmpty(){
//        if (size == 0){
//            return true;
//        }else return false;
        return size == 0;
    }


    public int size(){
        return size;
    }
    public void printDeque(){
//        for (int i = 0; i < size; i ++){
//            System.out.print(items[i] + " ");
//        }
//        System.out.println();

        T[] a = (T[]) new Object[items.length];
        int current = plusOne(nextFirst);
        for (int i = 0; i < size; i++){
            a[i] = items[current];
            current = plusOne(current);
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }

    public T removeFirst(){
        if (size == 0){
            return null;
        }
        int first = plusOne(nextFirst);
        T itemToReturn = items[first];
        items[first] = null;
        nextFirst = first;
        size --;
        if (size < items.length * 0.25 && items.length >= 16){
            resize(items.length / 2);
        }
        return itemToReturn;

    }
    public T removeLast(){
        if (size == 0){
            return null;
        }
        int last = minusOne(nextLast);
        T itemToReturn = items[last];
        items[last] = null;
        nextLast = last;
        size --;
        if (size < items.length * 0.25 && items.length >= 16){
            resize(items.length / 2);
        }
        return itemToReturn;
    }

    public T get(int index){
        if (size == 0 || index < 0 || index >= size){
            return null;
        }
        int actualIndex = plusOne(nextFirst) % items.length;
        return items[actualIndex];
    }
//    public Iterator<T> iterator(){
//
//    }
//    public boolean equals(Object o){
//
//    }

}
