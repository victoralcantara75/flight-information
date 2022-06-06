package entity;

import java.time.Duration;
import java.time.ZonedDateTime;

public class Flight {

    private String origin;
    private String destination;
    private String airline;
    private ZonedDateTime departure;
    private ZonedDateTime arrival;
    private Float price;
    private Long duration;

    public Flight(String origin, String destination, String airline, ZonedDateTime departure, ZonedDateTime arrival, Float price){
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.setDuration();
    }

    public String toString() {
        return "FlightsList{" +
                "aeroportoOrigem='" + this.getOrigin() + '\'' +
                ", aeroportoDestino='" + this.getDestination() + '\'' +
                ", companhiaAerea='" + this.getAirline() + '\'' +
                ", infoSaida=" + this.getDeparture() +
                ", infoChegada=" + this.getArrival() +
                ", valorVoo=" + this.getPrice() +
                ", duraçao=" + this.getDuration() +
                '}';
    }

    public String toCsvFormat(){
        return  this.getOrigin() + ";" +
                this.getDestination() + ";" +
                this.getAirline() + ";" +
                this.getDeparture() + ";" +
                this.getArrival() + ";" +
                this.getPrice() + ";" +
                this.getDuration() + '\n';
    }

    public void setDuration(){
        ZonedDateTime departureDateTime = this.getDeparture();
        ZonedDateTime arrivalDateTimeOnDepartureZone = this.getArrival().withZoneSameInstant(this.getDeparture().getOffset());

        this.duration = Duration.between(departureDateTime, arrivalDateTimeOnDepartureZone).toHours();
    }

    public Long getDuration(){
        return duration;
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

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public ZonedDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(ZonedDateTime departure) {
        this.departure = departure;
    }

    public ZonedDateTime getArrival() {
        return arrival;
    }

    public void setArrival(ZonedDateTime arrival) {
        this.arrival = arrival;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
