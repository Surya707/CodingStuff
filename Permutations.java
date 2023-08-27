import java.util.*;
public class Permutations
{
    private void computePermutations(List<Integer> al,int[] arr,int[] hash,int n,List<List<Integer>> sol)
    {
        //Base Case
        if(al.size()==n)
        {
            sol.add(new ArrayList<>(al));
            return;
        }

        for(int i=0;i<n;i++)
        {
            if(hash[i]!=1)
            {
                al.add(arr[i]);
                hash[i]=1;
                computePermutations(al,arr,hash,n,sol);
                //Backtrack -> Removes element from last index in array list and sets hash value to 0
                al.remove(al.size()-1);
                hash[i]=0;
            }
        }
    }

    private List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n];
        //Array consisting of 0s and 1s. If 0, element has not been picked,
        //Else element has been picked
        Arrays.fill(hash,0);
        List<List<Integer>> ans = new ArrayList<>();
        computePermutations(new ArrayList<>(),nums,hash,n,ans);
        return ans;        
        
    }
    public static void main(String[] args) {
        int[] nums = {1,5,7,9};
        List<List<Integer>> listOfPermutations = new ArrayList<List<Integer>>();
        Permutations obj = new Permutations();
        listOfPermutations = obj.permute(nums);
        System.out.print("[ ");
        for(List<Integer> itr:listOfPermutations)
        {
            System.out.print(itr.toString()+" ");
        }
        System.out.println("]");
    }
}