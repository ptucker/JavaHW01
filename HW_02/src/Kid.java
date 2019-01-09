public class Kid extends Person {
    private String favoriteCandy;

    /**
     * No-arg constructor initializes instance variables
     */
    public Kid(){
        favoriteCandy = "Snickers";
        this.setAge(8);
    }

    /**
     * Kid Constructor
     * @param _name
     * @param _age
     * @see #setName(String)
     * @see #setAge(int)
     */
    public Kid(String _name,int _age){
        this.setName(_name);
        this.setAge(_age);
    }
}
