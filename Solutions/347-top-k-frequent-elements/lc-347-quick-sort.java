class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count the occurrance of each unique number
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            int count = counts.getOrDefault(n, 0);
            counts.put(n, ++count);
        }
        
        // unqiue nums array
        int[] arr = new int[counts.size()];
        int i = 0;
        for (int n : counts.keySet()) {
            arr[i++] = n;
        }
        // shuffle the array
        shuffleArray(arr);
        
        // use quick sort to put top k elements in the first part
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int pivotPos = getPivotPos(arr, l, r, counts);
            // there are k elements before pivot, NOTE 0 index
            if (pivotPos == k) break;
            if (pivotPos > k) {
                r = pivotPos - 1;
            } else {
                l = pivotPos + 1;
            }
        }
        
        // after quick sort, top k elements are the first k elements in arr
        return Arrays.copyOf(arr, k);
    }
    
    private int getPivotPos(int[] arr, int l, int r, Map<Integer, Integer> counts) {
        int pivot = arr[l];
        while (l < r) {
            // sort in reverse order
            // numbers come before pivot are all >= pivot
            while (l < r && counts.get(arr[r]) < counts.get(pivot)) r--;
            arr[l] = arr[r];
            while (l < r && counts.get(arr[l]) >= counts.get(pivot)) l++;
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }

    private void shuffleArray(int[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i >= 0; i--) {
                // switch the value of i with the value of random
                int randInd = random.nextInt(i + 1);
                int temp = arr[i];
                arr[i] = arr[randInd];
                arr[randInd] = temp;
        }
    }
}