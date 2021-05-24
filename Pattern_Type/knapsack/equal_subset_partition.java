/*
    Given a set of integers find whether we can divide it into 2 subsets such that thier sum is equal

    Here we try to find whether a set exists which has a sum equal to sum/2 given that sum%2 == 0
    if yes then the left over elements will form a set with sum = sum/2

    if sum%2 != 0 , then we cannot divide the set into 2 parts
    
*/
import java.util.*;
class Test{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of set :");
        int n=sc.nextInt();
        int arr[]=new int[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        if(sum%2 == 0){
            boolean status = equal_subset_brute_force(arr,sum/2,n-1,0);
            if(status)
                System.out.println("Yes");
            else 
                System.out.println("No");
        }
        else 
            System.out.println("No");
    }

    public static boolean equal_subset_brute_force(int arr[], long sum, int index, int curr_sum){
        if(curr_sum == sum)
            return true;
        if(index < 0)
            return false;
        if(curr_sum + arr[index] > sum)
        equal_subset_brute_force(arr, sum, index-1, curr_sum);
         // case 1 : without including
        boolean without_including_curr = equal_subset_brute_force(arr, sum, index-1, curr_sum);
        // case 2 : with including
        boolean including_curr = equal_subset_brute_force(arr, sum, index-1, curr_sum+arr[index]);
        if(without_including_curr || including_curr)
            return true;
        return false;

    }
}