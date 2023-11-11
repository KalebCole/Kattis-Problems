public class GroupSum {
    public static void main(String[] args) {
        System.out.println(GroupSum.groupSum6(0, new int[]{3, 3, 3,6}, 9));
    }

    public  boolean groupSum(int start, int[] nums, int target) {
        // base cases
        // can either subtract from target to get solution or run out of numbers to subtract
        if (target == 0) return true;
        // do you have to wait until you get to the last element of the array?
        if(start >= nums.length || target < 0) return false; // now we don't have to check unneccesary branches

        // recursive call   
        // do it twice becuase we either check the branch or not
        return groupSum(start+1, nums, target - nums[start]) || groupSum(start+1, nums, target); 
        // by or operator, this will always return true if one of the child nodes is true
    }

    public boolean groupSum6(int start, int[] nums, int target) {
        // base cases
        if(target == 0 && start >= nums.length) return true; //we have checked all 6's
        if(target == 0 && start == 6) return false;
        if(target < 0) return false;
        if(target > 0 && start >= nums.length) return false;

        
        // recursive call
        // if 6, we must choose that path of the tree
        if(nums[start] == 6) return groupSum6(start+1, nums, target-nums[start]);
        if (target != 0) return groupSum6(start+1, nums, target-nums[start]) || groupSum6(start+1, nums, target);
        return false;
        

    }


}
