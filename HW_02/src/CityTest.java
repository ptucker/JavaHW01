public class CityTest {
    public static void main(String[] args){
        Person[] Citizens = {new Kid("Johnny",8),new Kid("Suzy",10), new Kid("Charlie",7), new Teacher(1,"Math","Mr. Jones",35), new Teacher(2,"English","Mrs. Smith",29), new Police(Police.policeRole.Patrol,"Mr. Dennis",28), new Police(Police.policeRole.Captain,"Captain James Harris", 42), new Police(Police.policeRole.Chief, "Mrs. Trefry", 25)};

        //display all the people's names who are in the city
        System.out.println("All the people in the city are: ");
        for (int i = 0; i<Citizens.length;i++){
            System.out.println(Citizens[i].toString());
        }

        //display the names of all the buildings in the city
        System.out.println("\nAll the buildings in the city are: ");
         Building[] Buildings = {new School("Mead High School","302 W Hastings Rd, Spokane, WA 99218"),new School("Rogers High School","1622 E Wellesley Ave, Spokane, WA 99207"),new CityHall("Spokane City Hall","808 W Spokane Falls Blvd, Spokane, WA 99201"),new CityHall("Spokane Valley City Hall","10210 E Sprague Ave, Spokane Valley, WA 99206")};
        for (int i = 0; i<Buildings.length;i++){
            System.out.println(Buildings[i].toString());
        }


        //assign people to each building in the city
        // kept getting an error here and was unable to add people objects to the buildings currentOccupants array
        Buildings[0].addPersonToBuilding(Citizens[0]);
        Buildings[0].addPersonToBuilding(Citizens[3]);
        Buildings[1].addPersonToBuilding(Citizens[1]);
        Buildings[1].addPersonToBuilding(Citizens[2]);
        Buildings[1].addPersonToBuilding(Citizens[4]);
        Buildings[2].addPersonToBuilding(Citizens[5]);
        Buildings[3].addPersonToBuilding(Citizens[6]);
        Buildings[3].addPersonToBuilding(Citizens[7]);



        //display all the people in each building separately
        for(int i =0; i <Buildings.length; i++){
            System.out.println("Everyone in " + Buildings[i].toString() + " is: ");
            Buildings[i].displayOccupants();
        }


        //pay all people who are employees
        for(int i = 0; i < Citizens.length;i++){
            if (Citizens[i] instanceof Employee){
                if(Citizens[i] instanceof Teacher) {
                    ((Employee) Citizens[i]).payEmployee(2000);
                     System.out.println(Citizens[i].toString() + " was paid $2000");
                }
                else if(Citizens[i] instanceof Police) {
                    ((Employee) Citizens[i]).payEmployee(2500);
                    System.out.println(Citizens[i].toString() + " was paid $2500");
                }
            }
        }
    }

}
