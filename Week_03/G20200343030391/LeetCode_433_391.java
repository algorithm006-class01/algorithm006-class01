package G20200343030391;

import java.util.HashSet;

public class LeetCode_433_391 {

    public static void main(String[] args) {

        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};

        int minMutation = new LeetCode_433_391().minMutation(start, end, bank);
        System.out.println(minMutation);
    }

    int minStep = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> changedStep = new HashSet<>();
        changeToNext(changedStep, 0, start, end, bank);
        return (minStep == Integer.MAX_VALUE) ? -1 : minStep;
    }

    /**
     * @param changedStep
     * @param step
     * @param current
     * @param end
     * @param bank
     * @return
     */
    private void changeToNext(HashSet<String> changedStep, int step, String current, String end, String[] bank) {
        //terminator
        if (current.equals(end)) {
            minStep = Math.min(minStep, step);
        }
        for (int i = 0; i < bank.length; i++) {
            String str = bank[i];
            int diffCharCount = 0;
            for (int j = 0; j < str.length(); j++) {
                if (current.charAt(j) != str.charAt(j)) {
                    diffCharCount++;
                    if (diffCharCount > 1) {
                        break;
                    }
                }
            }
            if (diffCharCount == 1 && !changedStep.contains(str)) {
                changedStep.add(str);
                changeToNext(changedStep, step + 1, str, end, bank);
                changedStep.remove(str);
            }
        }
    }


}
