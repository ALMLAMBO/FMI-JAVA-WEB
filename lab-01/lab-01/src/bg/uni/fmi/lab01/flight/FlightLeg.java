package bg.uni.fmi.lab01.flight;

import java.time.LocalDate;

public class FlightLeg {
    private String fromAirport;
    private String toAirport;
    private LocalDate date;

    public FlightLeg(String fromAirport, String toAirport, LocalDate date) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.date = date;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FlightLeg{" +
                "fromAirport='" + fromAirport + '\'' +
                ", toAirport='" + toAirport + '\'' +
                ", date=" + date +
                '}';
    }
}
