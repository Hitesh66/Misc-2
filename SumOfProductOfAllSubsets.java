//Time Complexity O(N)
//Space Complexity O(1) 
//Leetcode tested

public class SumOfProductOfAllSubsets {
    public int productOfSubsetSums(int arr[], int n)
    {
        int ans = 1;
        for (int i = 0; i < n; ++i )
            ans = ans * (arr[i] + 1);
        return ans-1;
    }
}
