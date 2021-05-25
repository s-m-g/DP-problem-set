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
        int sum = 0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        if(sum%2 == 0){
            sum/=2;
            int dp[][]=new int[n+1][sum+1];
            for(int i=0;i<=n;i++)
                for(int j=0;j<=sum;j++)
                    dp[i][j]=-1;
            int status = equal_subset_memoization(arr, sum, n-1, dp);
            // boolean status = equal_subset_sum_brute_force(arr,sum/2,n-1,0);

            if(status==1)
                System.out.println("Yes");
            else 
                System.out.println("No");
        }
        else 
            System.out.println("No");
    }

    // public static boolean equal_subset_sum_brute_force(int arr[], int sum, int index, int curr_sum){
    //     if(curr_sum == sum)
    //         return true;
    //     if(index < 0)
    //         return false;
    //     if(curr_sum + arr[index] > sum)
    //         return equal_subset_sum_brute_force(arr, sum, index-1, curr_sum);
    //      // case 1 : without including
    //     boolean without_including_curr = equal_subset_sum_brute_force(arr, sum, index-1, curr_sum);
    //     // case 2 : with including
    //     boolean including_curr = equal_subset_sum_brute_force(arr, sum, index-1, curr_sum+arr[index]);
    //     if(without_including_curr || including_curr)
    //         return true;
    //     return false;

    // }

    // state of dp : dp[index][sum] => at size i the sum of (sum/2) is possible or not
    public static int equal_subset_memoization(int arr[], int sum, int index, int dp[][]){
        if(sum == 0)
            return 1;
        if(sum<0 || index<0)
            return 0;
        if(dp[index][sum] != -1)
            return dp[index][sum];
        int val1 = equal_subset_memoization(arr,sum,index-1,dp);
        int val2 = equal_subset_memoization(arr,sum-arr[index],index-1,dp);
        dp[index][sum] =( val1==1 || val2==1 ) ? 1 : 0 ;
        return dp[index][sum];
    }
}