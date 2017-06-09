// Although this is a ubiquitous algo problem, I found it interesting because it made me study bitwise operators 
// deeply enough to understand the best solution to the problem
//
// The algorithm is based on 'shedding' the XOR result of the 2 integers until it turns zero,
// then return the number of times the 'shedding' is done
//
// Efficiency is dependent on how large the hamming distance is


class Solution {
    func hammingDistance(_ x: Int, _ y: Int) -> Int {
        var distance = 0
        var xorResult = x ^ y
        
        while (xorResult != 0) {
            // increment for number of times of bit difference
            distance = distance + 1 
            // Wegner's (1960) algorithm for clearing lowest order non-zero value           
            xorResult &= xorResult - 1;
        }
        
        return distance
    }
}