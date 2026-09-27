package Week3.Homework.ProgrammingAssignment;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }
    public Stack(){
        first=null;
        n=0;
    }
    public boolean isEmpty(){return first==null;}
    public int size(){return n;}

    public void push(Item item){
        Node<Item> oldFirst=first;
        first=new Node<Item>();
        first.item=item;
        first.next=oldFirst;
        n++;
    }
    public Item pop(){
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;}
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    public Iterator<Item> iterator() {
        return new Week3.Homework.ProgrammingAssignment.Stack.LinkedIterator(first);
    }

    // the iterator
    private class LinkedIterator implements Iterator<Item> {
        private Week3.Homework.ProgrammingAssignment.Stack.Node<Item> current;

        public LinkedIterator(Week3.Homework.ProgrammingAssignment.Stack.Node<Item> first) {
            current = first;
        }

        // is there a next item?
        public boolean hasNext() {
            return current != null;
        }

        // returns the next item
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

