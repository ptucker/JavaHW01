import java.util.Random;
//PT -- javadoc comments for class
public class Person {
    private static int lastnumber = 1111111;
    private static int lastID= 200000;
    private String name;
    private int age;
    private int phoneNumber; //PT -- need get for phone number. These should probably be protected instead of private. -1
    private double money;
    private int EmployeeID;


    /**
     * No-arg constructor initializes instance variables to null
     * and gives person a unique phone number. If the person is
     * an employee, they also get a unique Employee ID number.
     */
    public Person(){
        name = "default person";
        age = 0;
        phoneNumber = lastnumber;
        lastnumber++;
        money = 0;

        if (this instanceof Employee){
            EmployeeID = lastID;
            lastID++;
        }

    }


    /**
     * Sets the name
     * @param name is name of person
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Sets the age
     * @param age is name of person
     */
    public void setAge(int age) {
        //PT -- make sure you're getting a legal age. -2
        this.age = age;
    }


    /**
     * gets the money of a person
     * @return a double
     */
    public double getMoney() {
        return money;
    }

    /**
     * sets the money of a person
     * @param money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * gets the employee ID
     * @return an int
     */
    public int getEmployeeID() {
        return EmployeeID;
    }

    /**
     * overloads toString to return the name of the person
     * @return a string
     */
    public String toString(){
        return this.name;
    }
}
