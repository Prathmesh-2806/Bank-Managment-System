import javax.swing.*;
import java.awt.event.*;

public class BankUI {
    private BankSystem bank = new BankSystem();

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Bank Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton createBtn = new JButton("Create Account");
        JButton viewBtn = new JButton("View Account");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");

        createBtn.setBounds(120, 30, 150, 30);
        viewBtn.setBounds(120, 70, 150, 30);
        depositBtn.setBounds(120, 110, 150, 30);
        withdrawBtn.setBounds(120, 150, 150, 30);

        frame.add(createBtn);
        frame.add(viewBtn);
        frame.add(depositBtn);
        frame.add(withdrawBtn);

        createBtn.addActionListener(e -> showCreateDialog());
        viewBtn.addActionListener(e -> showViewDialog());
        depositBtn.addActionListener(e -> showDepositDialog());
        withdrawBtn.addActionListener(e -> showWithdrawDialog());

        frame.setVisible(true);
    }

    private void showCreateDialog() {
        JTextField nameField = new JTextField();
        JTextField accField = new JTextField();
        JTextField balField = new JTextField();
        Object[] fields = {
            "Name:", nameField,
            "Account Number:", accField,
            "Initial Balance:", balField
        };

        int result = JOptionPane.showConfirmDialog(null, fields, "Create Account", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String acc = accField.getText();
            double bal = Double.parseDouble(balField.getText());

            if (bank.createAccount(name, acc, bal)) {
                JOptionPane.showMessageDialog(null, "Account Created Successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Account Number Already Exists!");
            }
        }
    }

    private void showViewDialog() {
        String acc = JOptionPane.showInputDialog("Enter Account Number:");
        Account account = bank.getAccount(acc);
        if (account != null) {
            String info = "Name: " + account.getName() +
                          "\nAccount No: " + account.getAccountNumber() +
                          "\nBalance: $" + account.getBalance();
            JOptionPane.showMessageDialog(null, info);
        } else {
            JOptionPane.showMessageDialog(null, "Account Not Found!");
        }
    }

    private void showDepositDialog() {
        String acc = JOptionPane.showInputDialog("Enter Account Number:");
        Account account = bank.getAccount(acc);
        if (account != null) {
            String amtStr = JOptionPane.showInputDialog("Enter Amount to Deposit:");
            double amt = Double.parseDouble(amtStr);
            account.deposit(amt);
            JOptionPane.showMessageDialog(null, "Deposit Successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Account Not Found!");
        }
    }

    private void showWithdrawDialog() {
        String acc = JOptionPane.showInputDialog("Enter Account Number:");
        Account account = bank.getAccount(acc);
        if (account != null) {
            String amtStr = JOptionPane.showInputDialog("Enter Amount to Withdraw:");
            double amt = Double.parseDouble(amtStr);
            if (account.withdraw(amt)) {
                JOptionPane.showMessageDialog(null, "Withdrawal Successful!");
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient Balance!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account Not Found!");
        }
    }
}

