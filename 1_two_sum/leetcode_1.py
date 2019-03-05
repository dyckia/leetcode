class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hashtab = {}
        for i in range(len(nums)):
            num = nums[i]
            if num in hashtab:
                return [hashtab[num], i]
            else:
                hashtab[target - num] = i
        return None
