/**
 * This interface allows for any class that implements payEmployee and askID to have that functionality
 */
public interface Employee {
    public void payEmployee(int amount);
    public int askID();
}
