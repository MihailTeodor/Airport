public class StandardStrategy extends Strategy {

    private static StandardStrategy instance = null;
    private StandardStrategy(Airport A) {
        super(A);
    }

    public static StandardStrategy getInstance(Airport A){
        if(instance == null) {
            instance = new StandardStrategy(A);
        }
        return instance;
    }
    @Override
    public void recalculateArrivals() {

        displayArrivals();
    }

}
