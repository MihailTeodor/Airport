import java.util.*;
public class AirportManager {

    public static void main(String[] args) {

        Airport FlorenceAirport = new Airport("Florence");
        ControlTower CT = new ControlTower(FlorenceAirport);
        Arrival A = new Arrival(FlorenceAirport);
        Departure D = new Departure(FlorenceAirport);
        TicketOffice TO = new TicketOffice();

        int choice;
        String arrivalCode;
        String departureCode;
        String state;
        String provenance;
        String destination;
        String departuringRemovalCode;
        String arrivingRemovalCode;

        String name;
        String surname;
        String documentId;
        String flightCode;

        for(;;) {
            try
            {
                Thread.sleep(50);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }

            System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
            System.out.println("| 1 - Insert arrival            |");
            System.out.println("| 2 - Insert departure          |");
            System.out.println("| 3 - Remove arrival            |");
            System.out.println("| 4 - Remove departure          |");
            System.out.println("|-------------------------------|");
            System.out.println("| 5 - Insert passengers         |");
            System.out.println("| 6 - Print flight passengers   |");
            System.out.println("|-------------------------------|");
            System.out.println("| 7 - Exit                      |");
            System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
            System.out.println();

            System.out.print("Choose an action from above: ");
            Scanner S = new Scanner(System.in);
            choice = S.nextInt();
            System.out.println();

            switch (choice) {
                case 1:

                    System.out.print("Insert flight code: ");
                    arrivalCode = S.next();
                    System.out.print("Insert state: ");
                    state = S.next();
                    System.out.print("Insert provenance: ");
                    provenance = S.next();

                    System.out.println();
                    System.out.println();

                    CT.insertArrivalFlight(arrivalCode, state, provenance);
                    break;

                case 2:

                    System.out.print("Insert flight code: ");
                    departureCode = S.next();
                    System.out.print("Insert destination: ");
                    destination = S.next();

                    System.out.println();
                    System.out.println();

                    CT.insertDepartureFlight(departureCode, destination);
                    break;

                case 3:

                    if(FlorenceAirport.getArrivalsFlights().size() == 0) {
                        System.err.println("No arrivals flights programmed!");
                        break;
                    }
                    System.out.println("Insert arriving flight code to remove: ");
                    arrivingRemovalCode = S.next();
                    CT.removeArrivalFlight(arrivingRemovalCode);
                    break;

                case 4:

                    if(FlorenceAirport.getDeparturesFlights().size() == 0) {
                        System.err.println("No departuring flights programmed!");
                        break;
                    }
                    System.out.println("Insert departuring flight code to remove: ");
                    departuringRemovalCode = S.next();
                    CT.removeDepartureFlight(departuringRemovalCode);
                    break;

                case 5:

                    if(FlorenceAirport.getDeparturesFlights().size() == 0) {
                        System.err.println("No departuring flights programmed!");
                        System.out.println("");
                        break;
                    }


                    System.out.print("Insert name: ");
                    name = S.next();
                    System.out.print("Insert surname: ");
                    surname = S.next();
                    System.out.print("Insert document Id: ");
                    documentId = S.next();
                    System.out.print("Insert departuring flight code: ");
                    flightCode = S.next();

                    int i = 0;
                    boolean found = false;
                    while(i < FlorenceAirport.getDeparturesFlights().size() && !found) {
                        if(FlorenceAirport.getDeparturesFlights().get(i).getCode().equals(flightCode)) {
                            found = true;
                            Flight f = FlorenceAirport.getDeparturesFlights().get(i);
                            TO.insertPassenger(name, surname, documentId, f);
                            CT.getFlightPassengers(FlorenceAirport.getDeparturesFlights().get(i));
                        }
                        i++;
                    }
                    if (!found)
                        System.err.println("Inserted departuring flight code does not exist!");
                    System.out.println("");

                    break;

                case 6:

                    if(FlorenceAirport.getDeparturesFlights().size() == 0) {
                        System.err.println("No departuring flights programmed!");
                        System.out.println("");
                        break;
                    }

                    System.out.print("Insert departuring flight code: ");
                    flightCode = S.next();

                    int j = 0;
                    boolean found2 = false;
                    while(j < FlorenceAirport.getDeparturesFlights().size() && !found2) {
                        if (FlorenceAirport.getDeparturesFlights().get(j).getCode().equals(flightCode)){
                            found2 = true;
                            Flight f = FlorenceAirport.getDeparturesFlights().get(j);
                            CT.getFlightPassengers(f);
                        }
                        j++;
                    }
                    if (!found2)
                        System.err.println("Inserted departuring flight code does not exist!");
                    System.out.println("");

                    break;

                case 7:

                    return;
            }
        }
    }

}
