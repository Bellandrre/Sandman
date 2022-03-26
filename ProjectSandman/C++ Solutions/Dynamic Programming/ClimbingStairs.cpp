//
// Created by Karthik Kolathumani.
//

#include <iostream>
using namespace std;
/**
 * Brute force O(2^n)
 * @param n
 * @return
 */
int climbStairs(int n){
    if(n < 0){
        return 0;
    }
    if(n == 0){
        return 1;
    }
    return climbStairs(n-2) + climbStairs(n-1);
}

/**
 * Top down memoization approach
 * @param n
 * @param memo
 * @return
 */
int climbStairsDP(int n, int memo[]){
    if(n < 0){
        return 0;
    }else if(n == 0){
        return 1;
    }else if(memo[n] > -1){
        return memo[n];
    }else{
        memo[n] = climbStairs(n - 2) + climbStairs( n - 1);
        return memo[n];
    }
}

int main(){
    int n = 44;
    int* memo = new int[n+1];
    int size = (sizeof(memo)/sizeof(memo[0]));
    fill(memo, memo + size, -1);

    cout << "Total possible number of steps is - " << climbStairsDP(n, memo) << endl;
    return 0;
}