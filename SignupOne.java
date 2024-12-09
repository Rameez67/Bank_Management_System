import java.awt.*;
import javax.swing.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JButton next;
    JTextField nameTextField, fTextField, emailTextField, addressTextField, pincodeTextField, cityTextField,
            stateTextField;
    JDateChooser dateChooser;
    JRadioButton male, female, other, married, unmarried;

    SignupOne() {

        setLayout(null);
        setSize(800, 850);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);

        JLabel personDetail = new JLabel("PAGE NO#1 PERSONAL DETAILS ");
        personDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetail.setBounds(260, 80, 400, 30);
        add(personDetail);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fName = new JLabel("Father's Name: ");
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fName.setBounds(100, 190, 200, 30);
        add(fName);

        fTextField = new JTextField();
        fTextField.setFont(new Font("Arial", Font.BOLD, 14));
        fTextField.setBounds(300, 190, 400, 30);
        add(fTextField);

        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 100, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendeGroup = new ButtonGroup();
        gendeGroup.add(female);
        gendeGroup.add(male);

        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 100, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 90, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600, 390, 120, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Arial", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            // Validate all input fields before proceeding
            if (nameTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is required.");
                return;
            }
            if (fTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Father's name is required.");
                return;
            }
            if (((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Date of Birth is required.");
                return;
            }
            if (!male.isSelected() && !female.isSelected() && !other.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please select a gender.");
                return;
            }
            if (emailTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Email is required.");
                return;
            }
            if (addressTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Address is required.");
                return;
            }
            if (cityTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "City is required.");
                return;
            }
            if (stateTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "State is required.");
                return;
            }
            if (pincodeTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pin Code is required.");
                return;
            }
        }
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "married";

        } else if (unmarried.isSelected()) {
            marital = "unmarried";
        } else if (other.isSelected()) {
            marital = "other";

        }
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();
        String address = addressTextField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required here!");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob
                        + "','" + gender + "','" + email + "','" + marital + "','" + city + "','" + state + "','" + pin
                        + "','" + address + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignupOne();

    }
}