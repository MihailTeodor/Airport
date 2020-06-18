public class Arrival implements Observer {

    private Airport A;
    private Strategy S;

    public Arrival(Airport A) {

        this.A = A;
        A.registerObserver(this);
    }

    @Override
    public void update() {

        if(A.getArrivalsFlights().size() == 0){
            S = StandardStrategy.getInstance(A);
            S.recalculateArrivals();
            return;
        }

        if(A.getArrivalsFlights().get(A.getArrivalsFlights().size() - 1).getState().equals("emergency")) {
            S = EmergencyStrategy.getInstance(A);
            S.recalculateArrivals();
        }
        else {
            S = StandardStrategy.getInstance(A);
            S.recalculateArrivals();
        }
    }

}
