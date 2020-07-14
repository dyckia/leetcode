class RandomizedSet {
    private Map<Integer, Integer> indexMap;
    private List<Integer> valList;
        
    /** Initialize your data structure here. */
    public RandomizedSet() {
        indexMap = new HashMap<>();
        valList = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        // val already exists in the set
        if (indexMap.containsKey(val)) return false; 
        
        valList.add(val); // add the val to the end of the list
        indexMap.put(val, valList.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // val does not exist in the set
        if (!indexMap.containsKey(val)) return false;

        // swap the value of element to be removed with the last element to achieve O(1) time
        int valIndex = indexMap.get(val);
        int tailIndex = valList.size() - 1;
        if (valIndex != tailIndex) {
            // swap value
            int tmp = valList.get(tailIndex);
            valList.set(tailIndex, val);
            valList.set(valIndex, tmp);
            // update map
            indexMap.replace(val, tailIndex);
            indexMap.replace(tmp, valIndex);
        } 
        
        // delete val in the list and map
        valList.remove(tailIndex);
        indexMap.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int k = random.nextInt(valList.size());
        return valList.get(k);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */