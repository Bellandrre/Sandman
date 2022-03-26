//
// Created by Karthik Kolathumani.
//

#include <iostream>
#include <vector>
using namespace std;

int minCostClimbingHelper(vector<int>& cost, int minCost[], int n){
    if(n <= 0){
        return 0;
    }else if(minCost[n] == -1){
        return cost[n];
    }else if(minCost[n] > -1){
        return minCost[n];
    }else{
        minCost[n] = min(minCostClimbingHelper(cost, minCost, n -2), minCostClimbingHelper(cost, minCost, n - 1));
        return minCost[n];
    }
}

int minCostClimbingStairs(vector<int>& cost){
    int* minCost = new int[cost.size() + 1];
    fill(minCost, minCost + cost.size(), -1);
    cout<< cost.size() << endl;
    int minimumCost = minCostClimbingHelper(cost, minCost, cost.size());
    return minimumCost;
}

int main(){
    vector<int> vect{10,15,20};
    cout<< "The minimum cost is " << minCostClimbingStairs(vect) << endl;
    return 0;
}