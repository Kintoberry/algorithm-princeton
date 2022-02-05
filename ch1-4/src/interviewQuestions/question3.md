# Problem Statement
Egg drop. Suppose that you have an n-story building (with floors 1 through nn) 
and plenty of eggs. An egg breaks if it is dropped from floor TT or 
higher and does not break otherwise. Your goal is to devise a strategy
to determine the value of  TT given the following limitations on the
number of eggs and tosses:

- Version 0: 1 egg, ≤T tosses.

- Version 1: ∼1lgn eggs and ∼1lgn tosses.

- Version 2: ∼lgT eggs and ∼2lgT tosses.

- Version 3: 22 eggs and  \sim 2 \sqrt n∼2 n tosses.

- Version 4: 22 eggs and  \le c \sqrt T≤c T ​ tosses for some fixed constant cc.

# Solution
### Version 0
Idea: Brute Force.

Start from floor 1 and throw an egg at each floor as you climb up the stairs to floor n. If egg breaks at floor t, then the answer is t.

### Version 1
Idea: Divide and Conquer. In particualr, use binary search.

Go to floor n/2, throw an egg. If it breaks, go down to interval
(0, n/2 - 1). Otherwise, go to interval (n/2 + 1, n).

Repeat this process lgn times. 

### Version 2



