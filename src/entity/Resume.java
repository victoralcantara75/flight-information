package entity;

public class Resume {

    private String origin;
    private String destination;
    private Integer shortestFlight;
    private Integer longestFlight;
    private Double cheapest;
    private Double mostExpensive;
    private Double averageTime;
    private Double averagePrice;


    public Resume(String origin, String destination, Integer shortestFlight, Integer longestFlight, Double cheapest, Double mostExpensive, Double averageTime, Double averagePrice) {
        this.origin = origin;
        this.destination = destination;
        this.shortestFlight = shortestFlight;
        this.longestFlight = longestFlight;
        this.cheapest = cheapest;
        this.mostExpensive = mostExpensive;
        this.averageTime = averageTime;
        this.averagePrice = averagePrice;
    }

    public String toCsvFormat(){
        return this.getOrigin() + ";" +
                this.getDestination() + ";" +
                this.getShortestFlight() + ";" +
                this.getLongestFlight() + ";" +
                this.getCheapest() + ";" +
                this.getMostExpensive() + ";" +
                this.getAverageTime() + ";" +
                this.getAveragePrice() + "\n";
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getShortestFlight() {
        return shortestFlight;
    }

    public void setShortestFlight(Integer shortestFlight) {
        this.shortestFlight = shortestFlight;
    }

    public Integer getLongestFlight() {
        return longestFlight;
    }

    public void setLongestFlight(Integer longestFlight) {
        this.longestFlight = longestFlight;
    }

    public Double getCheapest() {
        return cheapest;
    }

    public void setCheapest(Double cheapest) {
        this.cheapest = cheapest;
    }

    public Double getMostExpensive() {
        return mostExpensive;
    }

    public void setMostExpensive(Double mostExpensive) {
        this.mostExpensive = mostExpensive;
    }

    public Double getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(Double averageTime) {
        this.averageTime = averageTime;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }
}
