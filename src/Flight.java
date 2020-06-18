import java.util.*;
public class Flight {

    private String code;
    private String state;
    private String departure;
    private String arrival;
    private Vector<Person> passenger = new Vector<Person>();

    public Flight(String code, String state, String departure, String arrival) {

        this.code = code;
        this.state = state;
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getCode() {

        return code;
    }

    public String getState() {

        return state;
    }

    public String getDeparture() {

        return departure;
    }

    public String getArrival() {

        return arrival;
    }

    public Vector<Person> getPassenger() {

        return passenger;
    }

}
