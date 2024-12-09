import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("BACK");
        back.setBounds(355, 500, 150, 30);
        back.addActionListener(this);
        image.add(back);

        Conn conn = new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (rs.next()) {

                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));

                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel enquiry = new JLabel("Balance Enqury");
        enquiry.setForeground(Color.WHITE);
        enquiry.setBounds(300, 300, 400, 30);
        enquiry.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(enquiry);

        JLabel text = new JLabel("Your Current Balance is: " + balance);
        text.setBounds(170, 400, 400, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
