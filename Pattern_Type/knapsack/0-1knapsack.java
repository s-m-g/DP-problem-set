/*
    When given a set of n items, their values, weights and the maximum weight allowed
    find the maximum value that you can get out of it by following 0-1 property 
*/

import java.util.*;
class Test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of items : ");
        int n =sc.nextInt();
        int weights[]=new int[n];
        int values[]=new int[n];
        System.out.println("Enter the weights :");
        for(int i=0;i<n;i++)
            weights[i]=sc.nextInt();
        System.out.println("Enter the values :");
        for(int i=0;i<n;i++)
            values[i]=sc.nextInt();
        System.out.println("Enter the maximum weight :");
        int max_weight=sc.nextInt();
        System.out.println(knapsack_brute_force(values, weights, max_weight, n));
        // System.out.println(knapsack_)
    }

    public static int knapsack_brute_force(int values[], int weights[], int max_weight, int size){
        if(size == 0)
            return 0;
        if(max_weight == 0)
            return 0;
        if(weights[size-1] > max_weight)
            return knapsack_brute_force(values, weights, max_weight, size-1);
        int with_curr_weight = values[size-1] + knapsack_brute_force(values, weights, max_weight-weights[size-1], size-1);
        int without_curr_weight = knapsack_brute_force(values, weights, max_weight, size-1);
        return Math.max(with_curr_weight, without_curr_weight);
    }
}