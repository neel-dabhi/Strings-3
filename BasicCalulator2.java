// TC : O(n)
// SC : O(n)
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currNum = 0;
        int lastSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + ch - '0';
            } else if (!Character.isDigit(ch) && ch != ' ') {
                if (lastSign == '+') {
                    st.push(currNum);
                } else if (lastSign == '-') {
                    st.push(-currNum);
                } else if (lastSign == '*') {
                    int popped = st.pop();
                    st.push(popped * currNum);
                    System.out.println(st.peek());
                } else if (lastSign == '/') {
                    int popped = st.pop();
                    st.push(popped / currNum);
                }
                currNum = 0;
                lastSign = ch;
            }
        }

        if (lastSign == '+') {
            st.push(currNum);
        } else if (lastSign == '-') {
            st.push(-currNum);
        } else if (lastSign == '*') {
            int popped = st.pop();
            st.push(popped * currNum);
            System.out.println(st.peek());
        } else if (lastSign == '/') {
            int popped = st.pop();
            st.push(popped / currNum);
        }


        int result = 0;
        while (!st.isEmpty()) {
            System.out.println(st.peek());
            result = result + st.pop();
        }
        return result;
    }
}