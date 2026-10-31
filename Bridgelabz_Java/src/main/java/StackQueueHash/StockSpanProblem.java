package StackQueueHash;

/*
 * Problem: Stock Span Problem
 *
 * Description:
 * Given an array of stock prices, calculate the span of each day.
 * The span is the number of consecutive days for which the
 * stock price was less than or equal to the current day's price.
 *
 * Approach:
 * Use a stack to store indices of stock prices.
 * Remove previous smaller or equal prices to find the
 * nearest previous greater price.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.Stack;
import java.util.Arrays;

public class StockSpanProblem {

    static int[] calculateSpan(int[] prices) {

        int n = prices.length;

        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Remove smaller or equal prices
            while (!stack.isEmpty() &&
                    prices[stack.peek()] <= prices[i]) {

                stack.pop();
            }

            // Calculate span
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            // Store current index
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] result = calculateSpan(prices);

        System.out.println("Stock Prices: " +
                Arrays.toString(prices));

        System.out.println("Stock Span: " +
                Arrays.toString(result));
    }
}
