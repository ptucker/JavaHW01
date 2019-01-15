public class Police extends Person implements Employee{

    /**
     * gets the police's role
     * @return policeRole containing role
     */
    public policeRole getRole() {
        return role;
    }


    public enum policeRole {Patrol,Sargent,Captain,Chief};
    private policeRole role;

    /**
     * No-arg constructor initializes instance variable
     */
    public Police(){
        role = policeRole.Patrol;
    }

    /**
     * Police Constructor
     * @param r
     * @param _name
     * @param _age
     * @see #setName(String)
     * @see #setAge(int)
     */
    public Police(policeRole r, String _name,int _age){
        role = r;
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
     * gets the employee ID of a police
     * @return
     */
    public int askID(){
        return this.getEmployeeID();
    }
}
