/**
 *      Class: BankAccount
 *      @author: Evan Sellers
 *      Purpose: Create and store information for bank accounts.
 * 
 *      use: Use in bank for keeping track of information
 */

public class BankAccount {

    public String name;         // name of person account name
    public int balance = 0;     // current balance of account


    /** BankAcount Init (Master)
     * This will init a new bank account.
     * Setting the name and the balance.
     * 
     * @param name { String } Name of the account to open
     * @param balance { int } Starting balance of account
     * 
     */
    public BankAccount( String name, int balance ) {
        this.name    = name;
        this.balance = balance;
    }

    
    /** BankAcount Init (Overloaded)
     * This will init a new bank account.
     * Setting the name and the balance. Uses
     * the master to create bank account. Default
     * name is `\0` while, default balance is 0.
     * 
     */
    public BankAccount() {
        this( "", 0 );
    }


    /** Set Name (Setter)
     * This will set the account name.
     * 
     * @param newName { String } updated name
     * 
     */
    public void setName( String newName ) {
        name = newName;
    }


    /** Set Name (Getter)
     * This will get the account name.
     * 
     * @return name { String } name on account
     * 
     */
    public String getName() {
        return name;
    }


    /** Deposit Money (Modifer)
     * This will add money to an users account
     * 
     * @param amount { int } amount to add to balance
     * @return balance { int } amount currently in account
     * 
     */
    public Integer deposit( int amount ) {
        balance += amount;
        return getBalance();
    }


    /** Withdraw Money (Modifer)
     * This will remove money to an users account
     * 
     * @param amount { int } amount to remove to balance
     * @return balance { int } amount currently in account
     * 
     */
    public Integer withdraw( int amount ) {
        balance -= amount;
        return getBalance();
    }

    /** Get Balance (Getter)
     * Get the balance of the account
     * 
     * @return balance { int } amount currently in account
     * 
     */
    public Integer getBalance() {
        return balance;
    }

}
