import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JButton change, back;
    JPasswordField repin, pin;

    String pinnumber;

    PinChange(String pinnnumber) {
        this.pinnumber = pinnnumber;
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = il.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Change Your Pin");
        text.setFont(new Font("System", Font.BOLD, 26));
        text.setForeground(Color.WHITE);
        text.setBounds(250, 300, 500, 35);
        image.add(text);

        JLabel pintext = new JLabel("Enter New Pin");
        pintext.setFont(new Font("Raleway", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(170, 350, 500, 30);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        // pin.setForeground(Color.WHITE);
        pin.setBounds(320, 350, 200, 30);
        image.add(pin);

        JLabel repintext = new JLabel("Re-Enter New Pin");
        repintext.setFont(new Font("Raleway", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(170, 390, 500, 30);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        // repin.setForeground(Color.WHITE);
        repin.setBounds(320, 390, 200, 30);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setFont(new Font("Raleway", Font.BOLD, 16));
        change.setBounds(370, 460, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBounds(370, 495, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Pin Does not Match Plz Re- Enter");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter the new Pin");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter new Pin");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '" + rpin + "'where pin = '" + pinnumber + "'";
                String query2 = "update login set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                String query3 = "update signupthree set pin = '" + rpin + "' where pin = '" + pinnumber + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin Changed Successfully!");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {

                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
