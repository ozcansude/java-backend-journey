# Length of Last Word

## Goal
Find the length of the last word in a given string.

## Examples

- "Hello World" -> 5
- "   fly me   to   the moon  " -> 4
- "luffy is still joyboy" -> 6

## Approach

I start from the end of the string.
First, I skip the spaces at the end.
Then, I count the characters of the last word until I reach another space or the beginning of the string.

## Why two while loops?
The first while loop skips trailing spaces.
The second while loop counts the last word.

## Time Complexity
O(n)
n = length of the string

## Space Complexity
O(1)
Because I only use variables, not extra data structures.
