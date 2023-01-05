package com.ajd.prep.dsa.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
public class MyStackImplTest {

    @Test
    public void myStackImplTest() {
        MyStackImpl<Integer> stack = new MyStackImpl<>();
        assertThrows(RuntimeException.class, () -> stack.peek());
        assertThrows(RuntimeException.class, () -> stack.pop());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(40, stack.peek());
        assertEquals(40, stack.peek());
        assertEquals(40, stack.pop());
        assertEquals(30, stack.peek());
        assertEquals(30, stack.pop());
        stack.push(30);
        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertThrows(RuntimeException.class, () -> stack.pop());
    }
}
