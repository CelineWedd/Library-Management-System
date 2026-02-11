/**
* Celine Wedderburn
* CEN-3024C - Software Development 1
* Jan 5, 2026
* Patron.java

* The purpose of this class is to store information of each patron entered into the system. This information includes storing
* the patrons ID, name, address and overdue fine amount. This class is important to the application as a whole because it allows
* for easy management and organization of patron information.
*/

// Patron information
public class Patron {
    int patronId;
    String firstName;
    String lastName;
    String street;
    String city;
    String state;
    String zip;
    float overdueFine;

    // This allows the patron to be created within the system with its new data
    public Patron(int patronId, String firstName, String lastName,
                  String street, String city, String state,
                  String zip, float overdueFine) {
        this.patronId = patronId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.overdueFine = overdueFine;

    // Gets Patrons Information
    }

    public int getPatronId() {
        return patronId;
    }

    public void setPatronId(int patronId) {
        this.patronId = patronId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public float getOverdueFine() {
        return overdueFine;
    }

    public void setOverdueFine(float overdueFine) {
        this.overdueFine = overdueFine;

    }

    @Override
    public String toString() {
        return
                patronId + "-" + firstName + " " + lastName + " " + street + "." + city + "," + state + " " + zip + "-" + overdueFine;
    }}