class Solution {
public:
    int removeDuplicates(vector<int>& arr) {
        int i = 0, j = 0, n = arr.size();
        if(n < 2) return n;
        for(int i = 0; i < n-1; i++) {
            if(arr[i] != arr[i+1]){
                arr[j++] = arr[i];
            }
        }        
        arr[j++] = arr[n-1];
        return j;
    }
};