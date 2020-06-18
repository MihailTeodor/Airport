public class EmergencyStrategy extends Strategy {

    static int position = 0;
    private static EmergencyStrategy instance = null;
    private EmergencyStrategy(Airport A) {

        super(A);
    }

    public static EmergencyStrategy getInstance(Airport A) {
        if(instance == null) {
            instance = new EmergencyStrategy(A);
        }
        return instance;

    }

    @Override
    public void recalculateArrivals() {
        position = (int) (A.getArrivalsFlights().stream().filter(fl -> fl.getState().equals("emergency")).count() - 1 );
        Flight f = new Flight(null, null, null, null);
        if(A.getArrivalsFlights().get(A.getArrivalsFlights().size() - 1).getState().equals("emergency")) {
            if (A.getArrivalsFlights().stream().allMatch(fl -> fl.getState().equals("emergency"))) {
                displayArrivals();
                return;
            }
            f = A.getArrivalsFlights().get(A.getArrivalsFlights().size() - 1);
            A.getArrivalsFlights().remove(A.getArrivalsFlights().size() - 1);
            A.getArrivalsFlights().add(position, f);
        }
        displayArrivals();
    }

}
