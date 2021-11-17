package com.company;


import java.util.*;

class IndexError extends Exception {

}

class Stack<T> {
    private ArrayList<T> stack = new ArrayList<>(0);

    public void push(T value) {
        this.stack.add(value);
    }

    public T pop(int index) throws IndexError {
        if (index >= stack.size()) {
            throw new IndexError();
        }
        T value = stack.get(index);
        stack.remove(index);
        return value;
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
}
