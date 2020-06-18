public abstract class Strategy {

    public Airport A;

    public Strategy(Airport A) {

        this.A = A;
    }

    public abstract void recalculateArrivals();

    public void displayArrivals() {

        System.out.println("                     ARRIVALS");
        for(int i = 0; i < A.getArrivalsFlights().size(); i++) {
            System.out.print(" Code: " + A.getArrivalsFlights().get(i).getCode() + " | ");
            System.out.print(" State: " + A.getArrivalsFlights().get(i).getState() + " | ");
            System.out.println(" Provenance: " + A.getArrivalsFlights().get(i).getDeparture());
        }
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
    }

}
