import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o2[0] - o1[0];
            }
        });

        ArrayList<int[]> list = new ArrayList<>(people.length);

        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[people.length][2]);
    }
}