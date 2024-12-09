import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JTextField carField;
    JPasswordField pinField;

    Login() {
        setSize(800, 500);
        setTitle("AUTOMATED TELLER MACHINE");
        setLocation(400, 200);
        setVisible(true);

        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpg"));
        Image i2 = il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(120, 150, 150, 30);
        add(cardNo);

        carField = new JTextField();
        carField.setBounds(300, 150, 230, 30);
        carField.setFont(new Font("Arial", Font.BOLD, 16));
        add(carField);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 150, 30);
        add(pin);

        pinField = new JPasswordField();
        pinField.setBounds(300, 220, 230, 30);
        pinField.setFont(new Font("Arial", Font.BOLD, 16));
        add(pinField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 280, 100, 30);
        login.setBackground(Color.BLACK);
        // login.setFont(new Font("SansSerif ",Font.ITALIC,20));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 280, 100, 30);
        clear.setBackground(Color.BLACK);
        // login.setFont(new Font("SansSerif ",Font.ITALIC,20));
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 330, 230, 30);
        signup.setBackground(Color.BLACK);
        // login.setFont(new Font("SansSerif ",Font.ITALIC,20));
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            carField.setText("");
            pinField.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = carField.getText();
            String pinnumber = pinField.getText();
            String query = "Select * from login where cardnumber = '" + cardnumber + "' and pin = '" + pinnumber + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Card and Pin number are not Correct.");
                }
            } catch (Exception e) {

                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}