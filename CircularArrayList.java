package edu.touro.mco264;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CircularArrayList implements List<String> {

    // Private variables are only accessible by methods
    // within the class.
    private int iP;
    private int dP;
    private String[] backingStore = new String[10];
    private int size = 0;


    @Override
    public int size() { return iP; }


    // isEmpty() does not make the array set to 0. It returns when it is empty or not.
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    @Override
    public boolean contains(Object o) {
        boolean bool = false;
        for (String s : backingStore) {
            if (s == o) {
                bool = true;
            }
        }
        return bool;
    }


    // Whenever we add, iP++.
    @Override
    public boolean add(String s) {
        ensureCapacity();
        backingStore[iP] = s;
        iP++;
        size++;
        return true;
    }


    // Whenever we remove, dP++.
    @Override
    public String remove(int index) {
        ensureCapacity();
        String removedElement = backingStore[index];
        backingStore[index] = null;
        dP++;
        size--;
        return removedElement;
    }


    @Override
    public String get(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(String.format("Index [%d] is not in bounds. Size = [%d]",
                    index, size()));

        return backingStore[index];
    }


    @Override
    public void clear() {
        backingStore = new String[10];
        iP=0;
        dP=0;
    }


    @Override
    public boolean addAll(Collection<? extends String> collection) {
        ensureCapacity();
        for (String s : collection) {
            add(s);
        }
        return true;
    }


    private void ensureCapacity() {
        // Sets the Insertion Point at 0.
        if(iP >= backingStore.length && size <= backingStore.length){
            iP= 0;
        }
        else if(iP == backingStore.length || iP == dP && iP != 0){
            String[] tempArray = new String[backingStore.length * 2 + 1]; // [21]
            System.arraycopy(backingStore,0, tempArray,0, iP);

            if(iP < backingStore.length){
                System.arraycopy(backingStore, iP, tempArray, tempArray.length - (backingStore.length - iP)
                        +1, backingStore.length - iP - 1); // destPos: [6], length: [15]

                dP = tempArray.length - (backingStore.length - iP) + 1; // dP = 6
                backingStore = tempArray;
            }

        }
    }


    //////////////////////////////////////////////////////////////////////////////////
    // METHODS NOT BEING USED IN QUEUE ARE EXCLUDED IN THE PRINTOUT///////////////////
    //////////////////////////////////////////////////////////////////////////////////

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public void add(int index, String element) {
        checkBoundsForException(index, iP - 1);

        System.arraycopy(backingStore, index, backingStore, index + 1, iP);

        backingStore[index] = element;
        iP++;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String set(int index, String element) {
        checkBoundsForException(index, iP - 1);
        String oldElement = backingStore[index];
        backingStore[index] = element;
        return oldElement;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> collection) {
        checkBoundsForException(index, iP - 1);
        ensureCapacity();
        for(String s: collection){
            add(index, s);
            index++;
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean bool = false;
        for(Object o: collection){
            bool = contains(o);
        }
        return bool;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if(containsAll(c)){
            for(int i = 0; i < iP; i++){
                for(Object o: c){
                    if(backingStore[i].equals(o)){
                        remove(i);
                    }
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    // Removes from this list all of its elements that are
    // not contained in the specified collection.
    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < iP; i++) {
            if(! c.contains(backingStore[i])){
                remove(i);
                i--;
            }

        }
        return true;
    }

    // For lists, The iterator inherited from Collection returns
    // list elements in order of increasing index, and it's next()
    // method ALWAYS moves "forward" through the list.
    @Override
    public Iterator<String> iterator() {
        return new CircularArrayList.MyListIterator();
    }

    private class MyListIterator implements Iterator<String>{
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < iP;
        }

        @Override
        public String next() {
            return backingStore[index++];
        }
    }

    // checkBoundsForException() is not needed because the set limit is String[10]
    // and when iP reaches 10, iP starts at [0] again. iP will never be lower than 0.
    private void checkBoundsForException(int index, int highPoint) {
        if(index < 0){
            throw new IndexOutOfBoundsException("Your index: " + index + " is lower than index 0.");
        }
        else if(index > highPoint){
            throw new IndexOutOfBoundsException("Your index: " + index + " is greater than the arrays size.");
        }
    }
}
