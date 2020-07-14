class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = addToSet(nums1);
        Set<Integer> set2 = addToSet(nums2);
        
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int i = 0;
        for (int n : set1) {
            res[i++] = n;
        }
        return res;
    }
    
}

/*
Time: m + n

Space: m + n
*/