public class Test {

    /**
     * Calculate the period of string that passed in.
     * The period of a string is the smallest positive integer P such that:
     * <ol>
     * <li>P &lt;= Q/2 and
     * <li>S[K] = S[K+P] for 0&lt;=K&lt;Q-P.
     * </ol>
     * <br />
     * 计算传入的字符串的周期长度。
     * @param str
     *            The string to be parsed.
     * @return the period length of string. Or -1 if no period exists.
     */
    public int calculateStringPeriod(String str) {
        int result = -1;
        String reg, left;
        // 最长的重复字串，极端情况就比如abcabc，最长重复字串就是abc
        // 即为字符串长度的一半，当然这是极端情况，通常都是小于串长一半的
        for (int len = str.length() / 2; len > 0; len--) {
            // 获取“最长字串”
            reg = str.substring(0, len);
            // 刨去“最长字串”剩下的串
            left = str.substring(len);
            //
            boolean valid = true;
            // 将字符串分隔成若干个“最长字串”。
            for (int startIndex = 0; startIndex <= left.length(); startIndex += len) {
                int endIndex = startIndex + len;
                if (endIndex > left.length()) {
                    endIndex = left.length();
                }
                String fragment = left.substring(startIndex, endIndex);
                // System.out.print("len = " + len);
                // System.out.print(", startIndex = " + startIndex);
                // System.out.print(", reg = " + reg);
                // System.out.print(", left = " + left);
                // System.out.print(", endIndex = " + endIndex);
                // System.out.println(", fragment = " + fragment);
                if (!(fragment.length() <= reg.length() && reg
                        .indexOf(fragment) == 0)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result = reg.length();
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int str = new Test().calculateStringPeriod("ababababababababa");
        System.out.println("Result is " + str);
        System.out.println(new Test().calculateStringPeriod("abcdabcdabcd"));
        System.out
                .println(new Test()
                        .calculateStringPeriod("111111111111110000000000000011111111111111000000000000001111111111111100000000000000"));
        System.out.println(new Test().calculateStringPeriod("abcd1abcd2abcd"));
        System.out.println(new Test()
                .calculateStringPeriod("javajavakljalksdfaskjavakaljkljjavaj"));
    }
}
