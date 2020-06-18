import java.util.*;

public abstract class Subject {

    private Vector<Observer> obsList = new Vector<Observer>();

    public void registerObserver(Observer o) {

        obsList.add(o);

    }

    public void removeObserver(Observer o) {

        obsList.remove(o);

    }

    protected void notifyObservers() {

        for(int i = 0; i < obsList.size(); i++)
            obsList.elementAt(i).update();

    }

}

