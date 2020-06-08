class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        #[2,-1,3,-3]                                     
        maxTillPrev = nums[0]; # Selfish kid
        globalMax_father = maxTillPrev; # Father
                
        for i in range(1,len(nums)):      
            maxTillPrev = max(nums[i],nums[i]+maxTillPrev)
            globalMax_father = max(maxTillPrev,globalMax_father)                     
        
        return globalMax_father
