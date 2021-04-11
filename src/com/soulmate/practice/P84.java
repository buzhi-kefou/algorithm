package com.soulmate.practice;

import java.util.*;

public class P84 {

    public int largestRectangleArea(int[] heights) {
        int len=heights.length;
        if(len==0)
            return 0;
        if(len==1)
            return heights[0];

        ArrayList<Integer> array = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        array.add(0);
        for (int height : heights) {
            array.add(height);
        }
        array.add(0);
        stack.add(0);

        int area=0;
        int size=len+2;
        for (int i = 1; i < size; i++) {
            while (array.get(stack.peek()) > array.get(i)) {
                int width = i - stack.peek() - 1;
                int height = array.get(stack.poll());
                area = Math.max(area, width * height);
            }
            stack.push(i);
        }
        return area;
    }

}
