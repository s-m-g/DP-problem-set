import java.util.*;
class Test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        int dp[][]=new int[n+1][sum+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=sum;j++)
                dp[i][j]=-1;
        System.out.println(get_min_diff_memoized(arr,sum,n,0,dp));
        System.out.println(get_min_diff_brute_force(arr,sum,n,0));
    }

    static int get_min_diff_brute_force(int arr[], int sum, int index,int curr_sum){
        if(index == 0){
            int sum1 = curr_sum;
            int sum2 = sum-curr_sum;
            return Math.abs(sum1-sum2);
        }

        int val1 = get_min_diff_brute_force(arr,sum,index-1,curr_sum);
        int val2 = get_min_diff_brute_force(arr,sum,index-1,curr_sum+arr[index-1]);
        return Math.min(val1,val2);
    }

    static int get_min_diff_memoized(int arr[], int sum, int index, int curr_sum, int dp[][]){
        if(dp[index][curr_sum] != -1)
            return dp[index][curr_sum];
        
        if(index==0){
            int sum1= curr_sum;
            int sum2=sum-curr_sum;
            return Math.abs(sum1-sum2);
        }
        int val1 = get_min_diff_memoized(arr,sum,index-1,curr_sum,dp);
        int val2 = get_min_diff_memoized(arr,sum,index-1,curr_sum+arr[index-1],dp);
        
        dp[index][curr_sum] = Math.min(val1,val2);
        return dp[index][curr_sum];
    }
}