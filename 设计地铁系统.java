class UndergroundSystem {
    HashMap<String,double[]> map;
    HashMap<Integer,People> map1;
    public UndergroundSystem() {
        map = new HashMap<>();
        map1 = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        map1.put(id,new People(stationName,(double)t));
    }
    public void checkOut(int id, String stationName, int t) {
        People people = map1.get(id);
        people.endStation = stationName;
        people.endTime = (double)t;
        String station = people.startStation +"."+ people.endStation;
        double time = people.endTime - people.startTime;
        if(!map.containsKey(station)){
            map.put(station,new double[]{time,1});
        }else{
            double []a = map.get(station);
            a[0]+=time;
            a[1]++;
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double []a = map.get(startStation+"."+endStation);
        return a[0]/a[1];
    }
}
class People{
    String startStation;
    String endStation;
    double startTime;
    double endTime;
    public People(String startStation,double startTime){
        this.startStation = startStation;
        this.startTime = startTime;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */