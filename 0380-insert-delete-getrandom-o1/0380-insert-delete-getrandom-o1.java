class RandomizedSet {
    Set<Integer> st;
    public RandomizedSet() {
        st = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(st.contains(val)) {
            return false;
        }
        st.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!st.contains(val)) {
            return false;
        }
        st.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int x = random.nextInt(st.size());
        List<Integer> list = new ArrayList<>(st);
        return list.get(x);
    }
}