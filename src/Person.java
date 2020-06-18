public class Person {

    private String name;
    private String surname;
    private String documentCode;

    public Person(String name, String surname, String documentCode) {

        this.name = name;
        this.surname = surname;
        this.documentCode = documentCode;
    }

    public String getName() {

        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDocumentCode() {

        return documentCode;
    }

}