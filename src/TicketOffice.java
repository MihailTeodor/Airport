public class TicketOffice {

    private Person p;
    private Flight f;

    public void insertPassenger(String name, String surname, String documentCode, Flight f) {

        Person p = new Person(name, surname, documentCode);
        f.getPassenger().add(p);
    }

}
