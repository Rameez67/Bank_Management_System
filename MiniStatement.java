import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        JLabel bank = new JLabel("Habib Bank");
        bank.setBounds(150, 20, 200, 50);
        bank.setFont(new Font("Raleway", Font.BOLD, 20));
        add(bank);

        JLabel mini = new JLabel();
        mini.setBounds(30, 150, 350, 60);
        add(mini);

        JLabel balance = new JLabel();
        balance.setBounds(30, 250, 340, 20);
        add(balance);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        try {

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX"
                        + rs.getString("cardnumber").substring(12));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            int bal = 0;
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + 3344 + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")
                        + "<br><html>");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }

            balance.setText("Your Current balance is Rs " + bal);

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
