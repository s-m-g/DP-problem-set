import java.util.*;
class Test{
    static int count = 0;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int x = sc.nextInt();
        get_total_subsets_brute_force(arr,n,0,x);
        System.out.println(count);
    }
    static void get_total_subsets_brute_force(int arr[], int index, int curr_sum, int tar){
        //every possible subset is generated when the index is 0
        if(index == 0){
            if(curr_sum == tar)
               count++;
            return;  
        }
        get_total_subsets_brute_force(arr,index-1,curr_sum,tar);
        get_total_subsets_brute_force(arr,index-1,curr_sum+arr[index-1],tar);
        return;
    }
    static void get_total_subsets_memoized(int arr[], int index, int curr_sum, int tar,int dp[][]){
         
    }
}