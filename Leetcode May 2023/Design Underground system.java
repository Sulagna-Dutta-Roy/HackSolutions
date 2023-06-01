class UndergroundSystem {
    private Map<Integer, CheckInRecord> checkIns; // Maps customer ID to CheckInRecord
    private Map<String, StationRecord> stationRecords; // Maps startStation + "->" + endStation to StationRecord

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        stationRecords = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInRecord(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInRecord checkInRecord = checkIns.get(id);
        String route = checkInRecord.station + "->" + stationName;
        int travelTime = t - checkInRecord.time;
        
        // Update the station record or create a new one if it doesn't exist
        stationRecords.computeIfAbsent(route, key -> new StationRecord())
                     .update(travelTime);
        
        checkIns.remove(id); // Remove the check-in record
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        StationRecord stationRecord = stationRecords.get(route);
        
        // Calculate and return the average time
        return stationRecord.getAverageTime();
    }
}
class CheckInRecord {
    String station;
    int time;

    public CheckInRecord(String station, int time) {
        this.station = station;
        this.time = time;
    }
}

class StationRecord {
    int totalTravelTime;
    int count;

    public void update(int travelTime) {
        totalTravelTime += travelTime;
        count++;
    }

    public double getAverageTime() {
        return (double) totalTravelTime / count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
