public class Teacher extends Person implements Employee {
    private int gradeLevel;
    private String certification;

    /**
     * No-arg constructor initializes instance variable
     */
    public Teacher(){
        gradeLevel = 0;
        certification = "Non-descript subject";
    }

    /**
     * Teacher constructor
     * @param level
     * @param cert
     * @param _name
     * @param _age
     * @see #setName(String)
     * @see #setAge(int)
     */
    public Teacher(int level,String cert, String _name,int _age){
        gradeLevel = level;
        certification = cert;
        this.setName(_name);
        this.setAge(_age);
    }

    /**
     * adds an amount of money to a persons money
     * @param amount
     * @see #getMoney()
     * @see #setMoney(double)
     */
    public void payEmployee(int amount) {
        this.setMoney(this.getMoney() + amount);
    }
    /**
     * gets the employee ID of a teacher
     * @return
     */
    public int askID(){
        return this.getEmployeeID();
    }
}
