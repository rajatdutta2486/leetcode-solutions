class Solution {
    public int maxSubArray(int[] nums) {
        //[2,-1,3,-3]                                     
        int maxTillPrev = nums[0]; // Selfish kid
        int globalMax_father = maxTillPrev; // Father
        
        int i=1;
        while(i < nums.length) {
            //compare nums[i] vs nums[i] + maxTillPrev
            //if he finds max then replace maxTillPrev
            maxTillPrev = Math.max(nums[i],nums[i]+maxTillPrev);
            globalMax_father = Math.max(maxTillPrev,globalMax_father);
            i++;            
        }
        return globalMax_father;        
    }
}

