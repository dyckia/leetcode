class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

            // the tricky part here is that same number is allowed to be chose mutiple times
            // but that combination must be unique, thus we can not use set here

            // to ensure the combination is unique, we do not consider the numbers before cur element
            // e.g. [2, 3] target 8
            // [2, 2, 3] other combinations: [2, 3, 2], [3, 2, 2]
            // when we're at 3, we no longer consider the previous element 2

            List<List<Integer>> solutions = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
                    
            backTrack(candidates, target, 0, path, solutions);

            return solutions;
        }

        private void backTrack(int[] nums, int curTarget, int start, List<Integer> path, List<List<Integer>> solutions) {
            // found a solution
            if (curTarget == 0) {
                // since we are changing the path, we need to make a copy of current path
                solutions.add(new ArrayList<Integer>(path));
                return;
            }

            // not possible to achieve target
            if (curTarget < 0) {
                return;
            }

            for (int i = start; i < nums.length; i++) {
                // add nums[i] to path
                path.add(nums[i]);
                // not i + 1 because repeated number is allowed
                backTrack(nums, curTarget - nums[i], i, path, solutions);
                // when returned, we need to remove the last element in path before choosing another element
                path.remove(path.size() - 1);
            }

            return;
        }
    
}

/*
Time: O(l^k)
where l is the length of the array, k is the longest possible combination (target / minInArray)
(if the min value in array is 1, and target is 9, the longest length of possible combination is 9)

Space: O(longest possible combination)
the path
*/