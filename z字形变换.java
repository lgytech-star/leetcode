class Solution {
    public String convert(String s, int numRows) {
         if (numRows == 1)
            return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int cycle = 2 * numRows - 2; 
        for (int i = 0; i < s.length(); i++) {
            int b = i % cycle; 
            int row;
            if (b < numRows) {
                row = b;
            } else {
                row = cycle - b;
            }
            rows[row].append(s.charAt(i));
        }
        String res = "";
        for (StringBuilder sb : rows) {
            res += sb;
        }
        return res;
    }
}