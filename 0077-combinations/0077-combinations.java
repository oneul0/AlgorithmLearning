class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        backtrack(n, k, 1, comb, result);

        return result;
    }

    private void backtrack(int n, int k, int start, List<Integer> comb, List<List<Integer>> result) {
        if (comb.size()==k) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i=start; i<=n; i++) {
            comb.add(i);
            backtrack(n, k, i+1, comb, result);
            comb.remove(comb.size()-1);
        }
    }
}