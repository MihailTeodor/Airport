public class ControlTower {

    private Airport A;

    public ControlTower(Airport A) {

        this.A = A;
    }

    public void insertArrivalFlight(String code, String state, String departure) {

        boolean valid = true;
        for(int i = 0; i < A.getArrivalsFlights().size(); i++) {
            if(A.getArrivalsFlights().get(i).getCode().equals(code)) {
                System.err.println("Inserted code already in the system. Check again the arriving flight code!");
                valid = false;
            }
        }

        if(valid)
            A.addArrivingFlight(code, state, departure);

    }

    public void insertDepartureFlight(String code, String arrival) {

        boolean valid = true;
        for(int i = 0; i < A.getDeparturesFlights().size(); i++) {
            if(A.getDeparturesFlights().get(i).getCode().equals(code)) {
                System.err.println("Inserted code already in the system. Check again the departuring flight code!");
                valid = false;
            }
        }
        if(valid)
            A.addDeparturingFlight(code, arrival);

    }

    public void removeArrivalFlight(String code) {

        boolean valid = true;
        if(A.getArrivalsFlights().size() != 0)
           valid = A.removeArrivingFlight(code);
        else
            System.err.println("No arrivals programmed!");

        if (!valid)
            System.err.println("Inserted code not in the system!");

    }

    public void removeDepartureFlight(String code) {

        boolean valid = true;
        if(A.getDeparturesFlights().size() != 0)
            valid = A.removeDeparturingFlight(code);
        else
            System.err.println("No departures programmed!");

        if (!valid)
            System.err.println("Inserted code not in the system!");

    }

    public void getFlightPassengers(Flight f) {

        System.out.println("");
        System.out.println("                                    PASSENGERS");
        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        for(int i = 0; i < f.getPassenger().size(); i++) {
            System.out.print("| Name: " + f.getPassenger().get(i).getName() + " | ");
            System.out.print("Surname: " + f.getPassenger().get(i).getSurname() + " | ");
            System.out.print("Document ID: " + f.getPassenger().get(i).getDocumentCode() + " | ");
            System.out.println("Flight code: " + f.getCode());
            System.out.println("|-----------------------------------------------------------------------------|");
        }
    }

}
