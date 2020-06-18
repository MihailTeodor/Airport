public class Departure implements Observer {

    private Airport A;

    public Departure(Airport A) {

        this.A = A;
        A.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("                    DEPARTURES");
        for(int i = 0; i < A.getDeparturesFlights().size(); i++) {
            System.out.print(" CODE: " + A.getDeparturesFlights().get(i).getCode() + " | ");
            System.out.println(" DESTINATION: " + A.getDeparturesFlights().get(i).getArrival());
        }
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.println();
        System.out.println();
    }

}
