import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    long random;
    JButton next;
    JTextField adharTextField, panNum;
    JRadioButton sYes, sNo, eYes, eNo;
    JComboBox religion, category, occupation, education, income;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setSize(800, 850);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

        setTitle("New Account Application Form - Page # 2");

        JLabel additionalDetail = new JLabel("PAGE NO#2: Additonal DETAILS ");
        additionalDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetail.setBounds(260, 80, 400, 30);
        add(additionalDetail);

        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        String valReligion[] = { "Muslims", "Hindu", "Christians", "Budhism" };
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fName = new JLabel("Category: ");
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fName.setBounds(100, 190, 200, 30);
        add(fName);

        String valCategory[] = { "General", "OB", "OBC", "SC", "SCT", "Other" };
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String valIncome[] = { "Null", "<1,50,000", "<2,50,000", "4,50,000", "8,50,000", "Upto 10,00,000" };
        income = new JComboBox<>(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 314, 200, 30);
        add(email);

        String valEducation[] = { "Matriculation", "Intermediate", "Graduate", "Post-Graduate", "Doctrate", "Other" };
        education = new JComboBox<>(valEducation);
        education.setBounds(300, 290, 400, 40);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marital = new JLabel("Occupation: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        String valOccupation[] = { "Salaried", "Self Employed", "Student", "Bussiness", "Retired", "Other" };
        occupation = new JComboBox<>(valOccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN Number: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        panNum = new JTextField();
        panNum.setFont(new Font("Arial", Font.BOLD, 14));
        panNum.setBounds(300, 440, 400, 30);
        add(panNum);

        JLabel city = new JLabel("Aadhar Number: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        adharTextField = new JTextField();
        adharTextField.setFont(new Font("Arial", Font.BOLD, 14));
        adharTextField.setBounds(300, 490, 400, 30);
        add(adharTextField);

        JLabel state = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        sYes = new JRadioButton("Yes");
        sYes.setBackground(Color.WHITE);
        sYes.setBounds(300, 540, 50, 30);
        add(sYes);

        sNo = new JRadioButton("No");
        sNo.setBackground(Color.WHITE);
        sNo.setBounds(370, 540, 50, 30);
        add(sNo);

        ButtonGroup citizeButtonGroup = new ButtonGroup();
        citizeButtonGroup.add(sNo);
        citizeButtonGroup.add(sYes);

        JLabel pincode = new JLabel("Existing Account: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        eYes = new JRadioButton("Yes");
        eYes.setBackground(Color.WHITE);
        eYes.setBounds(300, 590, 50, 30);
        add(eYes);

        eNo = new JRadioButton("No");
        eNo.setBackground(Color.WHITE);
        eNo.setBounds(370, 590, 50, 30);
        add(eNo);

        ButtonGroup eButtonGroup = new ButtonGroup();
        eButtonGroup.add(sNo);
        eButtonGroup.add(sYes);

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

            if (panNum.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Address is required.");
                return;
            }
            if (adharTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "City is required.");
                return;
            }

        }

        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String sadharNumber = adharTextField.getText();
        String spanNumber = panNum.getText();
        String seniorCitizen = null;
        if (sYes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (sNo.isSelected()) {
            seniorCitizen = "No";
        }

        String existingAccount = null;
        if (eYes.isSelected()) {
            existingAccount = "Yes";
        } else if (eNo.isSelected()) {
            existingAccount = "No";
        }

        try {

            Conn c = new Conn();
            String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','"
                    + soccupation
                    + "','" + seducation
                    + "','" + sincome + "','" + sadharNumber + "','" + spanNumber + "','" + seniorCitizen + "','"
                    + existingAccount + "')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignupTwo("");

    }
}