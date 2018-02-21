package com.ruchij;

import java.util.Arrays;
import java.util.LinkedList;

public class TestUtils
{
    static <T> LinkedList<T> createLinkedList(T ...args)
    {
        LinkedList list = new LinkedList<T>();

        list.addAll(Arrays.asList(args));

        return list;
    }
}
