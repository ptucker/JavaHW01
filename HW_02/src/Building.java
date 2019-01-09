//PT -- javadoc for class

public class Building {
    private String name;
    private String address;
    private Person[] currentOccupants;


    /**
     * No-arg Constructor initializes instance variables to null
     */
    public Building(){
        currentOccupants = new Person[0];
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
        currentOccupants = new Person[0];
    }

    /**
     * adds a person object to the array of people in the buildng
     * @param p
     */
    public void addPersonToBuilding(Person p){
        currentOccupants[currentOccupants.length] = p;
    }
    
    //PT -- can we remove someone? -2

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
    public void displayOccupants(){
        //PT -- let the UI do this.
        for (int i = 0; i < currentOccupants.length; i++)
        System.out.println(currentOccupants[i].toString());
    }
}
