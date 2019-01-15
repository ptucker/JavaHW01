import java.util.ArrayList;
public class City {
    private ArrayList<Building> buildings = new ArrayList<Building>();
    private ArrayList<Person> citizens = new ArrayList<Person>();
    private String name;



    public City(){
        /*
        citizens.add(new Kid("Johnny",8));
        citizens.add(new Kid("Suzy",10));
        citizens.add( new Kid("Charlie",7));
        citizens.add(new Teacher(1,"Math","Mr. Jones",35));
        citizens.add( new Teacher(2,"English","Mrs. Smith",29));
        */
        name = "Spokane";
        Building cityHall = new Building("Spokane City Hall","808 W Spokane Falls Blvd, Spokane, WA 99201");
        Building school = new Building("Rogers High School", "1622 E Wellesley Ave, Spokane, WA 99207");
        // I know this isn't a building -_-
        Building cityStreets = new Building("City","Anywhere that's not an address");
        this.addBuilding(cityHall);
        this.addBuilding(school);
        this.addBuilding(cityStreets);
    }

    /**
     * this will add a building to the arrayList of buildings
     * @param b is the building that will be added
     */
    public void addBuilding(Building b){
        buildings.add(b);
    }

    /**
     * this will remove a building from the arrayList of buildings
     * @param b is the building that will be removed
     */
    public void removeBuidling(Building b){
        buildings.remove(b);
    }


    /**
     *  this will search through the the arrayList of Person objects by name and if it finds the person it will return that Person
     * @param name is the name of the person you would like to get
     * @return Person object
     */
    public Person getCitizen(String name){
        for (int i = 0; i<citizens.size(); i++){
            if (name == citizens.get(i).toString())
                return citizens.get(i);
        }
        return null;

    }

    /**
     * this will search through the buildings arrayList by name and if it finds the building it will return that building
     * @param s is the name of the building that would like to get
     * @return building object
     */
    public Building getBuilding(String s){
        for (int i = 0; i<buildings.size(); i++){
            if (s == buildings.get(i).toString())
                return buildings.get(i);
        }
        return null;
    }

    /**
     * this will get the building in the array list at a specific index
     * @param i is the index integer that you would like to get the building at
     * @return Builiding object
     */
    public Building getBuilding(int i){
        return buildings.get(i);
    }

    /**
     * this will add a person object to the Person array list
     * @param p is the person object you would like to add
     */
    public void addPersonToCity(Person p){
        citizens.add(p);
    }

    /**
     * this will get the name of the city
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * this will set the name of the city
     * @param name is the desired name of the city
     */
    public void setName(String name) {
        this.name = name;
    }
}
