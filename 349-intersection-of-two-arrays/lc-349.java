class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = addToSet(nums1);
        Set<Integer> set2 = addToSet(nums2);
        
        if (set1.size() < set2.size())
            return setInter(set1, set2);
        else 
            return setInter(set2, set1);
    }
    
    private Set<Integer> addToSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        return set;
    }
    
    private int[] setInter(Set<Integer> set1, Set<Integer> set2) {
        // set1.size() < set2.size()
        // or initialize as array and use Arrays.copyOf() method
        List<Integer> list = new ArrayList<>();
        
        for (int num : set1) {
            if (set2.contains(num)) list.add(num);
        }
        
        // can not use toArray() method as Integer can not be converted to int
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}

/*
Time: m + n

Space: m + n
*/