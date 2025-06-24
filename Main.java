public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            BankUI ui = new BankUI();
            ui.createAndShowGUI();
        });
    }
}

