import java.util.*;

public class CityTest {
    private static String [] fnames = {"Alice", "Bob", "Carol", "Dave", "Emily", "Fred", "Gretchen"};
    private static String[] lnames = {"Nelson", "Olson", "Pettis", "Quintana", "Rollins", "Simpson", "Taylor", "Ulrich", "Van Dam" };
    private static Map<Integer, Person> employeeMap = new HashMap<Integer, Person>();
    public static void main(String[] args){
        Random rnd = new Random();
        fillEmployeeMap();

        System.out.println("Lookup an employee by their ID: ");
        Scanner scan = new Scanner(System.in);
        int IDnum = Integer.parseInt(scan.nextLine());
       // System.out.println(employeeMap.get(IDnum).getName());




      //  City City1 = new City();


        //display all the people's names who are in the city


        /*

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
        */
    }

    private static void fillEmployeeMap() {
        Random rnd = new Random();
        for (int i = 0; i <2000;i++){
            Person p = new Person();
            p.setName(fnames[rnd.nextInt(fnames.length)] + " " + lnames[rnd.nextInt(lnames.length)]);
            employeeMap.put(p.getEmployeeID(),p);
        }
    }


}
