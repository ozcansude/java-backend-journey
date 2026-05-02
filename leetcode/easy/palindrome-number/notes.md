# PalindromeNumber Number

## Goal

Check if an integer reads the same forward and backward.

## Examples

- 121 -> true
- -121 -> false
- 10 -> false

## Approach

First, negative numbers are not palindrome.

Then I convert the number to a String and compare characters from left and right.

Example:

121

Left character: 1  
Right character: 1  

If all matching characters are equal, return true.

## Time Complexity

O(n)

n = number of digits

## Space Complexity

O(n)

Because the integer is converted to a String.
