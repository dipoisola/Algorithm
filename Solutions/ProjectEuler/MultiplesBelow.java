PROJECTEULER1: Find the sum of all the multiples of 3 or 5 below 1000

// BARE SOLUTION
static int sumBelow1000 () {
    int sum = 0;
    
    for (int i = 0; i < 1000; i++) {
        if (i % 3 == 0 || i % 5 == 0) {
            sum += i;
        }
    }
    
    return sum;
}

---------------------------------------------------------------------------------------------

// MORE MATHEMATICAL SOLUTION
static int multiplesBelow (int maximum, int... x) {
    int sum = 0,
        // Prevent edge overflow when dividing
        max = maximum - 1;
    
    // ASSUMPTION: x has only 2 elements!
    int lcm = lcm(x[0], x[1]);
    
    // Sum of 1+2+3+4+..+N= N(N+1)/2,
    // hence K+2K+3K+..+KN = KN(N+1)/2
    for (int i : x) {
        sum += (i * (max / i) * (max/i + 1)) / 2; 
    }
    
    // Subtract instance where same numbers were added twice 
    return sum - (lcm * (max / lcm) * (max/lcm + 1)) / 2;
}

// Greatest Common Factor of 2 numbers
static int gcf(int x, int y) {
    while (x != y) {
        if (x > y) x -= y;
        else y -= x;
    }

    return x;
}

// Lowest Common Multiple of 2 numbers
static int lcm(int i, int j) {
    return (i * j) / gcf(i, j);
}