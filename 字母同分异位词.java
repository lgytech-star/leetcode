class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String,List<String>> map = new HashMap<>();
       for(int i=0;i<strs.length;i++){
        char []a = strs[i].toCharArray();
        Arrays.sort(a);
        String s = new String(a);
        if(map.containsKey(s)){
            map.get(s).add(strs[i]);
        }
        else{
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            map.put(s,list);
        }
       }
        return new ArrayList<List<String>>(map.values());
    }
}