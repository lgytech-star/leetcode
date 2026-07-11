class Solution {
    public String[] findLongestSubarray(String[] array) {
        int zimu = 0,shuzi = 0,index_0 = -1,index_1 = -1;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i=0;i<array.length;i++){
           char c = array[i].charAt(0);
            if (Character.isLetter(c)) {
                zimu++;
            } else {
                shuzi++;
            }
            if(map.containsKey(zimu-shuzi)){
                int x = map.get(zimu-shuzi);
                if(i+1-x>index_1-index_0){
                    index_0 = x;
                    index_1 = i+1;
                }
            }else{
                map.put(zimu-shuzi,i+1);
            }
        }
        if(index_0==-1)
        return new String[]{};
        String[] s = Arrays.copyOfRange(array,index_0,index_1);
        return s;
    }
}