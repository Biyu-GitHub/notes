import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int[] ints : matrix) {
            for (int i : ints) {
                queue.add(i);
                if (queue.size() > k)
                    queue.remove();
            }
        }
        return queue.peek();
    }
}