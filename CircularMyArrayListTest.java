package edu.touro.mco264;

import static org.junit.jupiter.api.Assertions.*;

public class CircularMyArrayListTest {

    // FIFO
    // Arrange
    private CircularArrayList list = new CircularArrayList();

    @org.junit.jupiter.api.Test
    void size(){
        // Arrange & Act
        list.add("Index 0");
        list.add("Index 1");
        list.add("Index 2");
        list.add("Index 3");
        list.add("Index 4");
        list.add("Index 5");
        list.add("Index 6");
        list.add("Index 7");
        list.add("Index 8");
        list.add("Index 9");
        // Assert
        assertEquals(10, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty(){
        // Arrange
        list.add("Index 0");
        list.add("Index 1");
        list.add("Index 2");
        list.add("Index 3");
        list.add("Index 4");
        list.add("Index 5");
        list.add("Index 6");
        list.add("Index 7");
        list.add("Index 8");
        list.add("Index 9");
        // Act
        list.clear();
        // Assert
        assertTrue(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void contains(){
        // Arrange
        list.add("Index 0");
        list.add("Index 1");
        list.add("Index 2");
        list.add("Index 3");
        list.add("Index 4");
        list.add("Index 5");
        list.add("Index 6");
        list.add("Index 7");
        list.add("Index 8");
        list.add("Index 9");
        // Act & Assert
        assertTrue(list.contains("Index 4"));
        assertEquals("Index 4", list.get(4));

    }

    @org.junit.jupiter.api.Test
    void add(){
        // Arrange & Act
        list.add("Index 0");
        list.add("Index 1");
        list.add("Index 2");
        list.add("Index 3");
        list.add("Index 4");
        list.add("Index 5");
        list.add("Index 6");
        list.add("Index 7");
        list.add("Index 8");
        list.add("Index 9");
        // Assert
        assertEquals("Index 0", list.get(0));
        list.add("Index 10");
        assertEquals("Index 10", list.get(0));
    }

    @org.junit.jupiter.api.Test
    void remove(){
        // Arrange
        list.add("Index 0");
        list.add("Index 1");
        list.add("Index 2");
        list.add("Index 3");
        list.add("Index 4");
        list.add("Index 5");
        list.add("Index 6");
        list.add("Index 7");
        list.add("Index 8");
        list.add("Index 9");
        list.add("Index 10");
        // Act
        list.remove(0);
        // Assert
        assertNull(list.get(0));
    }

    @org.junit.jupiter.api.Test
    void get(){
        // Arrange
        list.add("Index 0");
        list.add("Index 1");
        list.add("Index 2");
        list.add("Index 3");
        list.add("Index 4");
        list.add("Index 5");
        list.add("Index 6");
        list.add("Index 7");
        list.add("Index 8");
        list.add("Index 9");
        // Act & Assert
        assertEquals("Index 0", list.get(0));
        list.add("Index 10"); // 0
        list.add("Index 11"); // 1
        list.add("Index 12"); // 2
        assertEquals("Index 12", list.get(2));
    }

    @org.junit.jupiter.api.Test
    void clear(){
        // Arrange
        list.add("Index 0");
        list.add("Index 1");
        list.add("Index 2");
        list.add("Index 3");
        list.add("Index 4");
        list.add("Index 5");
        list.add("Index 6");
        list.add("Index 7");
        list.add("Index 8");
        list.add("Index 9");
        // Act
        list.clear();
        // Assert
        assertEquals(0, list.size());
    }
}
