# Circle Link

This program uses a double link data structure, and navigates back and fourth around the link structure removing elements and tying the elements back together

Think of the link structure like a circle. This program takes in three variables from the user:

### N
The number of items in the circle

### M
Amount of turns to make clockwise

### O
Amount of turns to take counter-clockwise

The program will start at the root of the circle (1) and will go forward to the Mth link and remove the it, keeping the circle intact. Then the program will go to the Oth link counter-clockwise and remove it. This process is repeated until all elements in the circle are removed.

## Example
N = 7, M = 4, O = 3

![circle steps](https://i.imgur.com/XM9DY9g.png)