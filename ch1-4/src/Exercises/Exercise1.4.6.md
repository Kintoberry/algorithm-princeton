
### 1.4.6 a
a. count the number of iterations:

N/2^0 + N/2^1 + N/2^2 + ... + N/2^lgN = N(1/2^0 + ... + 1/2^lgN)

(1/2^0 + ... + 1/2^lgN) is some value between 0 and 1. So, this is
a constant.

Thus, O(N)

### 1.4.6 b

count the number of iterations:

2^0 + 2^1 + 2^2 + ... + 2^lgN

Let r = 2^0 + 2^1 + 2^2 + ... + 2^lgN 

Then, 2r = 2^1 + 2^2 + .. + 2^(lgN + 1)

r = 2r - r = 2^(lgN + 1) - 2^0 = 2*2^lgN - 1

Since 2^lgN = N, the answer is O(N)

### 1.4.6. c

count the number of iterations:

The inner loop is O(N) irrelevant of the outer loop.

The outer look iterates lgN times since i starts as 1 and doubles
at every iteration to N-1. 

Thus, O(N) * lgN => O(N lgN)