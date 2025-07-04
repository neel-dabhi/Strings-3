// TC: O(n)
// SC: O(n)
// Runs on LeetCode: YES
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        s.trim();
        int currNumber = 0;
        int lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)) {
                currNumber = currNumber * 10 + ch - '0';
            } else if (ch == '(') {
                // Opening Bracket
                if (lastSign == '+') {
                    st.push(1);
                } else if (lastSign == '-') {
                    st.push(-1);
                }
                st.push(Integer.MAX_VALUE);
                currNumber = 0;
                lastSign = '+';
            } else if (ch == ')') {
                // Closing Breakcket
                if (lastSign == '+') {
                    st.push(currNumber);
                } else if (lastSign == '-') {
                    st.push(-currNumber);
                }
                int calc = 0;
                while (st.peek() != Integer.MAX_VALUE) {
                    calc = calc + st.pop();
                }
                // remove max int
                st.pop();
                // remove multiple
                calc = calc * st.pop();
                // add result of barcket to stack
                st.push(calc);

                // Reset for next number
                currNumber = 0;
                lastSign = '+';
            } else if (!Character.isDigit(ch) && ch != ' ') {
                // not digit or space => must be a sign
                if (lastSign == '+') {
                    st.push(currNumber);
                } else if (lastSign == '-') {
                    st.push(-currNumber);
                }
                currNumber = 0;
                lastSign = ch;
            }

        }
        // process last element
        if (lastSign == '+') {
            st.push(currNumber);
        } else if (lastSign == '-') {
            st.push(-currNumber);
        }
        // add all the elemets from st
        int result = 0;
        while (!st.isEmpty()) {
            System.out.println(st.peek());
            result = result + st.pop();
        }
        return result;
    }
}