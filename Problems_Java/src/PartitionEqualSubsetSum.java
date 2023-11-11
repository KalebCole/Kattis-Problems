import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        PartitionEqualSubsetSum p1 = new PartitionEqualSubsetSum(new int[]{1,5,11,5});
        PartitionEqualSubsetSum p2 = new PartitionEqualSubsetSum(new int[]{1,2,3,5});
        System.out.println(p1.canPartition(p1.nums));
        System.out.println(p2.canPartition(p2.nums));
    }

    public int[] nums;

    public PartitionEqualSubsetSum(int[] nums){
        this.nums = nums;
    }

    /**
     * Using the set method of 0/1 Knapsacking, create a set that contains all the possible totals
     * Because it is a set, duplicates will be deleted
     * @param nums
     * @return true or false
     */
    public boolean canPartition(int[] nums) {
        if(sum(nums) % 2 != 0) return false;
        int target = sum(nums)/2;
        Set<Integer> totals = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(totals.contains(target)) return true;
            // we are adding the current index to the totals in the set
            for (Integer total : totals) {
                temp.add(nums[i] + total);
                temp.add(total);
            }
            for (Integer tem : temp) {
                totals.add(tem);
            }
            totals.add(nums[i]); //add the current index to the set
        } 
        
        return false;
    

    }
    public int sum(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        return total;
    }
}
