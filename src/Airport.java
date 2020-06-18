import java.util.*;

public class Airport extends Subject {

    private String name;
    private List<Flight> arrivalsFlights = new ArrayList<Flight>();
    private List<Flight> departuresFlights = new ArrayList<Flight>();

    public Airport(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public List<Flight> getArrivalsFlights() {

        return arrivalsFlights;
    }

    public List<Flight> getDeparturesFlights() {

        return departuresFlights;
    }

    public void addArrivingFlight(String code, String state, String departure) {
        this.getArrivalsFlights().add(new Flight(code, state, departure, null));
        notifyObservers();
    }

    public void addDeparturingFlight(String code, String arrival) {
        this.getDeparturesFlights().add(new Flight(code, null, null, arrival));
        notifyObservers();
    }

    public boolean removeArrivingFlight(String code) {
       boolean valid = this.getArrivalsFlights().removeIf(f -> f.getCode().equals(code));
       notifyObservers();
       return valid;
    }

    public boolean removeDeparturingFlight(String code) {
        boolean valid = this.getDeparturesFlights().removeIf(f -> f.getCode().equals(code));
        notifyObservers();
        return valid;
    }
}
