import java.util.HashMap;

public class BankSystem {
    private HashMap<String, Account> accounts = new HashMap<>();

    public boolean createAccount(String name, String accNo, double balance) {
        if (accounts.containsKey(accNo)) return false;
        accounts.put(accNo, new Account(name, accNo, balance));
        return true;
    }

    public Account getAccount(String accNo) {
        return accounts.get(accNo);
    }
}

