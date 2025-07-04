// TC: O(1) max 4 triplets and each triplet has 3 oprations;
// SC: O(1)
// Runs on LeetCode YES
class Solution {
    String[] below20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    String[] tens = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"
    };

    String[] thousands = {
            "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String result = "";
        int i = 0;
        while (num > 0) {
            int triplet = num % 1000;

            if (triplet != 0) {
                result = helper(triplet).trim() + " " + thousands[i] + " " + result;
            }
            num = num / 1000;
            i++;
        }
        return result.trim();
    }

    private String helper(int num) {

        if (num < 20) {
            // lookup 20s array
            return below20[num];
        } else if (num < 100) {
            // lookup 10s array
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            // lookup 100s array
            return below20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}