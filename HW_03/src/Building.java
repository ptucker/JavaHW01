import java.util.ArrayList;

/**
 * Building class holds information about the building such as name, address, current occupants and has functions that get and set these.
 */
public class Building {
    private String name;
    private String address;
    private ArrayList<Person> currentOccupants = new ArrayList<Person>();


    /**
     * No-arg Constructor initializes instance variables to null
     */
    public Building(){
        name ="building";
        address = "1000 Division St";
    }

    /**
     * Building constructor
     * @param n
     * @param a
     */
    public Building(String n, String a){
        name = n;
        address = a;
    }

    /**
     * adds a person object to the array of people in the buildng
     * @param p
     */
    public void addPersonToBuilding(Person p){
        currentOccupants.add(p);
    }

    /**
     * this checks if the building currently contains a person
     * @param P is the person you would like to check if they are in the building
     * @return boolean
     */
    public boolean containsPerson(Person P){

            if (currentOccupants.contains(P))
                return true;
            else
                return false;
    }


    /**
     * this removes a person from a buildings array list of Person objects
     * @param p is the person you would like to remove
     */
    public void removePersonFromBuilding(Person p){
        currentOccupants.remove(p);
    }

    /**
     * gets name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * sets name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * overloads toString to return the name of the object
     * @return a string
     */
    public String toString(){
        return this.name;
    }

    /**
     * displays all the people in the array of people in the building object
     */
    public Person getOccupant(int i){
        return currentOccupants.get(i);
    }

    // recieved help from Levi Russell on this

    /**
     * this will create a string that has all the current occupants name separated by a |
     * @return
     */
    public String getOccupants(){
        String occupants = "";
        for (Person p: currentOccupants){
            occupants = occupants + p.toString() + "  | ";
        }
            return occupants;

    }

    /**
     * this gets the address of the building
     * @return String
     */
    public String getAddress() {
        return address;
    }
}
