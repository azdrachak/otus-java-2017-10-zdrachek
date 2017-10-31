package com.github.azdrachak;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ArrayListTest {
    private ArrayList<Integer> list;
    private ListIterator<Integer> listIterator;


    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        listIterator = list.listIterator();
    }

    @Test
    public void testSizeZero() throws Exception {
        assertEquals("Empty list has size 0: ", 0, list.size());
    }

    @Test
    public void testSizeTwo() throws Exception {
        list.add(1);
        list.add(2);
        assertEquals("List has size 2: ", 2, list.size());
    }

    @Test
    public void testIsEmptyTrue() throws Exception {
        assertTrue("List is empty:", list.isEmpty());

    }

    @Test
    public void testIsEmptyFalse() throws Exception {
        list.add(1);
        assertFalse("List is not empty:", list.isEmpty());

    }

    @Test
    public void testContainsTrue() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue("List contains 2", list.contains(2));
    }

    @Test
    public void testContainsFalse() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        assertFalse("List contains 2", list.contains(5));
    }


    @Test
    public void testToArray() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        Object[] arr = new Object[]{1, 2, 3};
        assertArrayEquals(arr, list.toArray());
    }

    @Test
    public void testToArrayOfType() throws Exception {
        assertTrue(false);

    }

    @Test
    public void testAdd() throws Exception {
        int sizeBefore = list.size();
        list.add(1);
        int sizeAfter = list.size();
        assertEquals("List size is increased by 1", 1, sizeAfter - sizeBefore);
        assertTrue("List contains added element", list.contains(1));

    }

    @Test
    public void testAddByIndex() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        int sizeBefore = list.size();
        list.add(1, 9);
        int sizeAfter = list.size();
        assertEquals("List size is increased by 1", 1, sizeAfter - sizeBefore);
        assertTrue("List contains added element", list.contains(9));
        assertTrue("Added element has correct index", list.indexOf(9) == 1);
    }

    @Test
    public void testAddAll() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        java.util.ArrayList<Integer> toAdd = new java.util.ArrayList<>();
        toAdd.add(45);
        toAdd.add(46);
        int sizeBefore = list.size();
        list.addAll(toAdd);
        int sizeAfter = list.size();
        assertEquals("List size is increased by 2", 2, sizeAfter - sizeBefore);
        assertTrue("List contains added element", list.containsAll(toAdd));

    }

    @Test
    public void testAddAllByIndex() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        java.util.ArrayList<Integer> toAdd = new java.util.ArrayList<>();
        toAdd.add(45);
        toAdd.add(46);
        int sizeBefore = list.size();
        list.addAll(1, toAdd);
        int sizeAfter = list.size();
        assertEquals("List size is increased by 2", 2, sizeAfter - sizeBefore);
        assertTrue("List contains added element", list.containsAll(toAdd));
        assertTrue("Added element has correct index", 1 == list.indexOf(45));
        assertTrue("Added element has correct index", 2 == list.indexOf(46));
    }

    @Test
    public void testRemoveByIndex() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        int sizeBefore = list.size();
        list.remove(1);
        int sizeAfter = list.size();
        assertEquals("List size is decreased by 1: ", 1, sizeBefore - sizeAfter);
        assertFalse("List contains added element: ", list.contains(2));

    }

    @Test
    public void testRemoveByIndexFirst() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        int sizeBefore = list.size();
        list.remove(0);
        int sizeAfter = list.size();
        assertEquals("List size is decreased by 1: ", 1, sizeBefore - sizeAfter);
        assertFalse("List contains added element: ", list.contains(1));

    }

    @Test
    public void testRemoveByIndexLast() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        int sizeBefore = list.size();
        list.remove(2);
        int sizeAfter = list.size();
        assertEquals("List size is decreased by 1: ", 1, sizeBefore - sizeAfter);
        assertFalse("List contains added element: ", list.contains(3));

    }

    @Test
    public void testRemoveObject() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        Integer toRemove = 2;
        int sizeBefore = list.size();
        list.remove(toRemove);
        int sizeAfter = list.size();
        assertEquals("List size is decreased by 1: ", 1, sizeBefore - sizeAfter);
        assertFalse("List contains added element: ", list.contains(toRemove));
    }

    @Test
    public void testRemoveObjectNotExist() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        Integer toRemove = 4;
        int sizeBefore = list.size();
        list.remove(toRemove);
        int sizeAfter = list.size();
        assertEquals("List size is decreased by 0: ", 0, sizeBefore - sizeAfter);
    }

    @Test
    public void testRemoveAll() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        java.util.ArrayList<Integer> elems = new java.util.ArrayList<>();
        elems.add(2);
        elems.add(4);
        int sizeBefore = list.size();
        list.removeAll(elems);
        int sizeAfter = list.size();
        assertEquals("List size is decreased by 2: ", 2, sizeBefore - sizeAfter);
        assertFalse("List doesn't contain deleted element 2", list.contains(2));
        assertFalse("List doesn't contain deleted element 4", list.contains(4));
    }

    @Test
    public void testContainsAll() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        java.util.ArrayList<Integer> elems = new java.util.ArrayList<>();
        elems.add(2);
        elems.add(3);
        assertTrue("List contains all elements from collection", list.containsAll(elems));
    }

    @Test
    public void testContainsAllOddElems() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        java.util.ArrayList<Integer> elems = new java.util.ArrayList<>();
        elems.add(2);
        elems.add(3);
        elems.add(4);
        assertFalse("List contains not all elements from collection", list.containsAll(elems));
    }

    @Test
    public void testClear() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertTrue("Cleared list size is 0", list.size() == 0);
    }

    @Test
    public void testGet() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue("Element by index 1 == 2", list.get(1) == 2);
    }

    @Test
    public void testSet() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        int oldElem = list.set(1, 5);
        assertTrue("Element by index 1 == 5", list.get(1) == 5);
        assertTrue("Returned correct element", oldElem == 2);
    }


    @Test
    public void testIndexOf() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue("Index of number 2 is 1", list.indexOf(2) == 1);
    }

    @Test
    public void testLastIndexOf() throws Exception {
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        assertTrue("Last index of number 2 is 3", list.lastIndexOf(2) == 3);
    }

    @Test
    public void testRetainAll() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        java.util.ArrayList<Integer> newList = new java.util.ArrayList<>();
        newList.add(3);
        newList.add(4);
        newList.add(4);
        newList.add(7);
        boolean retained = list.retainAll(newList);
        assertTrue("List size is 2", list.size() == 2);
        assertTrue("Returned true", retained);
        assertTrue("Contains 3", list.contains(3));
        assertTrue("Contains 4", list.contains(4));
    }

    @Test
    public void testRetainAllNoIntersect() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        java.util.ArrayList<Integer> newList = new java.util.ArrayList<>();
        newList.add(4);
        newList.add(5);
        newList.add(6);
        boolean retained = list.retainAll(newList);
        assertTrue("List size is 0", list.size() == 0);
        assertTrue("Returned true", retained);
    }

    @Test
    public void testRetainAllSameData() throws Exception {
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(2);
        java.util.ArrayList<Integer> newList = new java.util.ArrayList<>();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        newList.add(1);
        boolean retained = list.retainAll(newList);
        assertTrue("List size is 4", list.size() == 4);
        assertFalse("Returned false", retained);
        assertTrue("Contains 1", list.containsAll(newList));
    }

    @Test
    public void testSubList() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> newList = new ArrayList<>();
        newList = list.subList(1, 3);
        assertTrue("Sublist has 2 elements", newList.size() == 2);
        assertTrue("Sublist contains 2", newList.contains(2));
        assertTrue("Sublist contains 3", newList.contains(3));
    }

    //Iterator tests
    @Test
    public void testRemoveBeforeNext() throws Exception {
        list.add(2);
        try {
            listIterator.remove();
            fail("remove do not throw the Exception when called before next");
        } catch (final IllegalStateException e) {}
    }

    @Test
    public void testNextOnEmptyCollection() throws Exception {
        list.add(1);
        list.add(2);
        listIterator.next();
        listIterator.remove();
        listIterator.next();
        listIterator.remove();
        try {
            listIterator.next();
            fail("next do not throw the Exception when no more elements");
        } catch (final NoSuchElementException e) {}
    }

    @Test
    public void testHasPreviousWhenIteratorAtTheEndOfTheCollection() {

        list.add(1);
        list.add(2);
        assertFalse("The ArrayList  has no previous items! Your previousIndex() is wrong.", listIterator.hasPrevious());
        listIterator.next();
        assertTrue("The ArrayList has the previous elements! Your previousIndex() is wrong.", listIterator.hasPrevious());
    }

    @Test
    public void testAddInIteratorAfterNext() {

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        listIterator.next();
        listIterator.next();
        assertSame("previousIndex wrong",1, listIterator.previousIndex());
        assertSame("nextIndex wrong",2, listIterator.nextIndex());
        assertSame("previous element ",2, listIterator.previous());
        assertSame(1, list.get(0));
        assertEquals("size",4, list.size());
        listIterator.add(9);
        assertSame("previous element ",9, listIterator.previous());
        listIterator.add(10);
        assertEquals("size",6, list.size());
        assertSame("previousIndex wrong",1, listIterator.previousIndex());
        assertSame("nextIndex wrong",2, listIterator.nextIndex());
        assertSame("previous element ",10, listIterator.previous());
    }

    @Test
    public void testAddInIteratorWhenEmptyList() {

        listIterator.add(1);
        listIterator.add(2);
        assertSame("previousIndex ",1, listIterator.previousIndex());
        assertSame("previous element ", 2, listIterator.previous());
        assertSame("First element ", 1, list.get(0));
        assertEquals("size",2, list.size());
    }

    @Test
    public void testAddInIteratorWhenIsNotEmptyListToTheBeginning() {


        list.add(0);
        list.add(0);
        list.add(0);
        listIterator.add(1);
        assertSame("previousIndex ",0, listIterator.previousIndex());
        assertSame("nextIndex ",1, listIterator.nextIndex());
        assertSame("previous element ", 1, listIterator.previous());
        assertSame("Get first element ",1, list.get(0));
        assertEquals("size",4, list.size());
    }

    @Test
    public void testAddInIteratorLastIsNotSet() {

        listIterator.add(1);
        listIterator.add(2);
        listIterator.add(3);
        try {
            listIterator.set(222);
            fail("set method can not be called after add (E). Wrong last element.");
        } catch (final IllegalStateException e){}

        listIterator.add(4);
    }

    @Test
    public void testSetWhenNeitherNextNorPreviousHaveBeenCalled() throws Exception {
        list.add(1);
        try {
            listIterator.set(null);
            fail("set method do not throw IllegalStateException the if neither next nor previous have been called");
        } catch (final IllegalStateException e){}
        listIterator.add(2);
        try {
            listIterator.set(null);
            fail("set method do not throw IllegalStateException the if neither next nor previous have been called");
        } catch (final IllegalStateException e){}
    }

    @Test
    public void testSetAfterNext() {
        list.add(1);
        list.add(3);
        listIterator.next();
        listIterator.next();
        listIterator.set(2);
        assertEquals("set() should replaces the last element returned by next() or previous()", (Integer)2, list.get(1));
    }

    @Test
    public void testSetAfterPrevious() {
        list.add(1);
        list.add(3);
        list.add(4);
        listIterator.next();
        listIterator.next();
        listIterator.next();
        listIterator.previous();
        listIterator.set(3);
        listIterator.previous();
        listIterator.set(2);

        assertEquals("set() should replaces the last element returned by next() or previous()", (Integer)1, list.get(0));
        assertEquals("set() should replaces the last element returned by next() or previous()", (Integer)2, list.get(1));
        assertEquals("set() should replaces the last element returned by next() or previous()", (Integer)3, list.get(2));
    }

    @Test
    public void testPreviousIndex() {
        list.add(1);
        listIterator.next();
        assertEquals("Your previousIndex() is wrong.", 0, listIterator.previousIndex());
    }

    @Test
    public void testPreviousIndexWhenItEqualsTo1() {

        list.add(1);
        list.add(1);
        listIterator.next();
        listIterator.next();

        assertEquals("Your previousIndex() is wrong.", 1, listIterator.previousIndex());
    }

    @Test
    public void testPreviousIndexWhenEmptyCollection() {
        assertEquals("In an empty collection, previousIndex() must return -1!", -1, listIterator.previousIndex());
    }

    @Test
    public void testPreviousWhenEmptyCollection() throws Exception {

        try {
            listIterator.previous();
            fail("list iterator do not throw the Exception when called previous method on empty collection");
        } catch (final java.util.NoSuchElementException e) {}
    }

    @Test
    public void testHasPreviousWhenEmptyCollection() {
        assertFalse("Your hasPrevious() is wrong.", listIterator.hasPrevious());
    }

    @Test
    public void testRemoveTwoTimeInTheRow() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        listIterator.next();

        listIterator.remove();
        assertEquals("Expected collection size is 4, however actual is not", 4, list.size());
        try {
            listIterator.remove();
            fail("remove do not throw the Exception when called twice");
        } catch (final IllegalStateException e) {}
    }

    @Test
    public void testRemoveAfterThePrevious() throws Exception {
        listIterator.add(0);
        listIterator.add(1);
        listIterator.add(2);
        listIterator.add(3);
        listIterator.add(4);

        listIterator.previous();
        listIterator.previous();
        try {
            listIterator.remove();
        } catch (final IllegalStateException e) {
            throw new RuntimeException("remove() call can only be made once per call to next() or previous(). " +
                    "It can be made only if add(E) has not been called after the last call to next() or previous().");
        }
        //System.out.println(Arrays.deepToString(list.toArray()));
        assertEquals("Expected collection size is 4, however actual is not", 4, list.size());
        assertEquals("Expected element [3] == 4, however actual is not", (Integer)4, list.get(3));
    }

    @Test
    public void testPreviousAfterNextWithOneElement() {
        list.add(1);
        final Integer next = listIterator.next();
        final Integer previous = listIterator.previous();
        assertEquals("From the documentation: \n" +
                "Note that alternating calls to next() and previous()" +
                " will return the same element repeatedly ", next, previous);
    }

    @Test
    public void testPreviousAfterNextMoreElements() {
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //System.out.println(Arrays.deepToString(list.toArray()));
        listIterator.next();
        listIterator.next();
        assertEquals("From the documentation: \n" +
                "Note that alternating calls to next() and previous()" +
                " will return the same element repeatedly ", (Integer) 2, listIterator.next());
        assertEquals("After next() index should be greater", 3, listIterator.nextIndex());

        assertEquals("From the documentation: \n" +
                "Note that alternating calls to next() and previous()" +
                " will return the same element repeatedly ", (Integer) 2, listIterator.previous());
        assertEquals("After previous() index should be less", 2, listIterator.nextIndex());

        assertEquals("From the documentation: \n" +
                "Note that alternating calls to next() and previous()" +
                " will return the same element repeatedly ", (Integer) 2, listIterator.next());
        assertEquals("After next() index should be greater", 3, listIterator.nextIndex());

        assertEquals("From the documentation: \n" +
                "Note that alternating calls to next() and previous()" +
                " will return the same element repeatedly ", (Integer) 2, listIterator.previous());
        assertEquals("After previous() index should be less", 2, listIterator.nextIndex());
    }
}