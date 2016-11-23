package chap6.interfaces.annotations.bankingdemo;

/**
 * Created by Stas on 02/04/2015.
 */
public interface AccountOperationManager {

    public double depositInCash(int accountNumber, int amount);
    public boolean withdraw(int accountNumber, int amount);
    public boolean convert(double amount);
    public boolean transfer(int accountNumber, double amount);
}
