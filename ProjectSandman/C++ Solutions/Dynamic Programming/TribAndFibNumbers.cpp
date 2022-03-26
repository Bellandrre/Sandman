/**
 * Tribonacci and Fibonacci Numbers using DP/variables
 */

#include<iostream>

using namespace std;

int fibNumbers(int n){
    if(n == 0){
        return 0;
    }
    int fib_0 = 0;
    int fib_1 = 1;

    for(int i =2; i <= n; i++){
        int fib_n = fib_1 + fib_0;
        fib_0 = fib_1;
        fib_1 = fib_n;
    }
    return fib_1;
}

int tribNumbers(int n){
    if(n == 0){
        return 0;
    }
    int trib_0 = 0;
    int trib_1 = 1;
    int trib_2 = 1;

    for(int i = 3; i <= n; i++){
        int trib_n = trib_2 + trib_1 + trib_0;
        trib_0 = trib_1;
        trib_1 = trib_2;
        trib_2 = trib_n;
    }
    return trib_2;
}

int main(){
    std::cout << " Fib " <<  fibNumbers(10) << std::endl;
    std::cout << " Trib " <<  tribNumbers(10) << std::endl;
    return 0;
}