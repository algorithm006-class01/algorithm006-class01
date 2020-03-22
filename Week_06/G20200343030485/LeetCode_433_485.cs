public class Solution {
    public int MinMutation(string start, string end, string[] bank) {
        if (start == end) return 0;

        var bankSet = new HashSet<string>(bank);
        var isVisited = new HashSet<string>();

        var queue = new Queue<string>();
        queue.Enqueue(start);

        var choices = new char[] { 'A', 'C', 'G', 'T' };

        var steps = 1;

        while (queue.Any()) {
            var size = queue.Count;

            for (int s = 0; s < size; s++) {
                var cur = queue.Dequeue();
                var curArray = cur.ToArray();
                for (int i = 0; i < curArray.Length; i++) {
                    foreach (var c in choices) {
                        curArray[i] = c;
                        var tempCur = new string(curArray);
                        if (isVisited.Contains(tempCur)) continue;
                        
                        if (bankSet.Contains(tempCur)) {
                            if (tempCur == end) {
                                return steps;
                            }
                            isVisited.Add(tempCur);
                            queue.Enqueue(tempCur);
                        }

                        curArray[i] = cur[i];
                    }
                }
            }

            steps++;
        }

        return -1;

    }
}