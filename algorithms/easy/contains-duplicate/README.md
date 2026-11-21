# 217. Contains Duplicate

## Problem Description

Given an integer array `nums`, return `true` if any number appears more than once. Otherwise, return `false`.

**Example:**
- Input: `nums = [34, 22, 23, 34]`
- Output: `true`

## Approach 1: Brute Force

### Explanation
- I used two nested loops to compare each number with the remaining elements.
- The outer loop selects a number, while the inner loop checks the following numbers.
- If two numbers are equal, the method returns `true`.
- If no duplicates are found, the method returns `false`.

### Complexity Analysis
- **Time Complexity:** O(n²) — Two nested loops compare the elements, resulting in quadratic time complexity.
- **Space Complexity:** O(1) 

## Approach 2: HashSet

### Explanation
- I used a HashSet to store the numbers that have already been visited.
- Initially, the HashSet is empty.
- For each number, I check whether it already exists in the HashSet using `contains()`.
- If the number exists, the method returns `true`. Otherwise, the number is added to the HashSet using `add()`.
- If the loop finishes without finding a duplicate, the method returns `false`.

### Complexity Analysis
- **Time Complexity:** O(n) average — The algorithm iterates through the array once. HashSet's `contains()` and `add()` operations take O(1) time on average.
- **Space Complexity:** O(n)

## What I Learned

- I learned how to solve the same problem using different approaches.
- I understood that HashSet provides O(1) average lookup time, making duplicate detection more efficient.
- I learned about the time-space tradeoff: using additional memory can reduce the time complexity from O(n²) to O(n).