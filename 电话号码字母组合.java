class Solution {
    HashMap<Character,String> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        char []a = digits.toCharArray();
        backtrack(a,0);
        return res;
    }
    public void backtrack(char []a,int index){
        if(sb.length()==a.length){
            res.add(new String(sb));
            return ;
        }
        for(int i=index;i<a.length;i++){
            String str = map.get(a[i]);
            for(int j=0;j<str.length();j++){
                sb.append(str.charAt(j));
                backtrack(a,i+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}