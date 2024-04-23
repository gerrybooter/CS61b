package deque;

public class LinkedListDeque<T> {
    private class StuffNode {
        public StuffNode prev;
        public T item;
        public StuffNode next;

        public StuffNode(T i, StuffNode n) {
//            prev = j;
            item = i;
            next = n;
        }
    }

    public int size;
    private StuffNode sentinel;//不靠构造方法也行？！！
    public StuffNode first;
    public StuffNode last;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new StuffNode(item, sentinel.next);
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
        size ++;
    }

    public void addLast(T item) {
        sentinel.prev.next = new StuffNode(item, sentinel);
        sentinel.prev.next.prev = sentinel.prev;
        sentinel.prev = sentinel.prev.next;
        size++;
    }

    public boolean isEmpty() {
//        StuffNode p = sentinel;
//        if (p.next == null){
//            return true;
//        }else return false;
        if (size == 0) {
            return true;
        } else return false;
    }

    public int size() {
        return size;
    }

    //从第一个到最后一个打印双端队列中的项目，以空格分隔。打印完所有项目后，打印一个新行。
    public void printDeque() {
        StuffNode p = sentinel.next;
        while (p != sentinel){
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0){
            return null;
        }
        sentinel.next = sentinel.next.next;
        StuffNode firstNode = sentinel.next.prev;
        sentinel.next.prev = sentinel;
        size--;
        return firstNode.item;

    }

    public T removeLast() {

        if (size == 0){
            return null;
        }
        sentinel.prev.prev.next = sentinel;
        StuffNode lastNode = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return lastNode.item;


    }

    public T get(int index) {//使用迭代,输入序号得对应结果
        if (size == 0 || index < 0 || index >= size){
            return null;
        }
        StuffNode currentNode = sentinel.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.item;

    }
//    public Iterator<T> iterator(){
//
//    }
//    public boolean equals(Object o){
//
//    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);//不用p.xxxx直接这样就相当于this
    }

    public T getRecursiveHelper(StuffNode p, int index) {
        if (p == sentinel) {
            return null;
        }
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(p.next, index - 1);

    }

}
