class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<String> set = Arrays.stream(sentence.split(""))
            .collect(Collectors.toSet());
        return (set.size() == 26);
    }
}