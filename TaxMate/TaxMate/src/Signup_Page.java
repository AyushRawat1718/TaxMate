import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


class Signup_Page extends JFrame implements ActionListener {
    JLabel JL_SP_01; // For the text(Sign Up !!).
    JLabel JL_SP_02; // For the text(First Name).
    JLabel JL_SP_03; // For the text(Middle Name).
    JLabel JL_SP_04; // For the text(Last Name).
    JLabel JL_SP_05; // For the text(Pan Number).
    JLabel JL_SP_06; // For the text(Date of birth).
    JLabel JL_SP_07; // For the text(Contact Number).
    JLabel JL_SP_08; // For the text(Gender).
    JLabel JL_SP_09; // For the text(Note);
    JLabel JL_SP_10; // For the text(Your Username will be your Pan Number & your Password will be your Contact Number).
    JTextField JT_SP_01; // TextField for First Name.
    JTextField JT_SP_02; // TextField for Middle Name.
    JTextField JT_SP_03; // TextField for Last Name.
    JTextField JT_SP_04; // TextField for Pan Number.
    JTextField JT_SP_05; // TextField for Date of birth.
    JTextField JT_SP_06; // TextField for Contact Number
    JComboBox JC_SP_01; // Combo-box for Gender Selection.
    JButton JB_SP_01; // Button for Register.

    Signup_Page() {
        this.setSize(1000, 650);
        this.getContentPane().setBackground(new Color(0x202329));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("TaxMate");
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_SP_01 = new JLabel("Sign Up !!");
        JL_SP_01.setForeground(new Color(0x03C39A));
        JL_SP_01.setFont(new Font("Arial", Font.BOLD, 25));
        JL_SP_01.setBounds(450, 30, 200, 30);
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_SP_02 = new JLabel("First Name");
        JL_SP_02.setForeground(new Color(0x799C42D8, true));
        JL_SP_02.setFont(new Font("Arial", Font.BOLD, 20));
        JL_SP_02.setBounds(30, 130, 120, 20);

        JT_SP_01 = new JTextField();
        JT_SP_01.setFont(new Font("Arial", Font.BOLD, 20));
        JT_SP_01.setForeground(new Color(0x9A9AEC));
        JT_SP_01.setBackground(new Color(0x393949));
        JT_SP_01.setCaretColor(Color.BLACK);
        JT_SP_01.setBorder(BorderFactory.createEmptyBorder());
        JT_SP_01.setBounds(160, 125, 130, 30);
////-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_SP_03 = new JLabel("Middle Name");
        JL_SP_03.setForeground(new Color(0x799C42D8, true));
        JL_SP_03.setFont(new Font("Arial", Font.BOLD, 20));
        JL_SP_03.setBounds(350, 130, 130, 20);

        JT_SP_02 = new JTextField();
        JT_SP_02.setFont(new Font("Arial", Font.BOLD, 20));
        JT_SP_02.setForeground(new Color(0x9A9AEC));
        JT_SP_02.setBackground(new Color(0x393949));
        JT_SP_02.setCaretColor(Color.BLACK);
        JT_SP_02.setBorder(BorderFactory.createEmptyBorder());
        JT_SP_02.setBounds(490, 125, 130, 30);
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_SP_04 = new JLabel("Last Name");
        JL_SP_04.setForeground(new Color(0x799C42D8, true));
        JL_SP_04.setFont(new Font("Arial", Font.BOLD, 20));
        JL_SP_04.setBounds(680, 130, 130, 20);

        JT_SP_03 = new JTextField();
        JT_SP_03.setFont(new Font("Arial", Font.BOLD, 20));
        JT_SP_03.setForeground(new Color(0x9A9AEC));
        JT_SP_03.setBackground(new Color(0x393949));
        JT_SP_03.setCaretColor(Color.BLACK);
        JT_SP_03.setBorder(BorderFactory.createEmptyBorder());
        JT_SP_03.setBounds(820, 125, 130, 30);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_SP_05 = new JLabel("PAN Number");
        JL_SP_05.setForeground(new Color(0x799C42D8, true));
        JL_SP_05.setFont(new Font("Arial", Font.BOLD, 20));
        JL_SP_05.setBounds(30, 240, 130, 20);

        JT_SP_04 = new JTextField();
        JT_SP_04.setFont(new Font("Arial", Font.BOLD, 20));
        JT_SP_04.setForeground(new Color(0x9A9AEC));
        JT_SP_04.setBackground(new Color(0x393949));
        JT_SP_04.setCaretColor(Color.BLACK);
        JT_SP_04.setBorder(BorderFactory.createEmptyBorder());
        JT_SP_04.setBounds(160, 235, 170, 30);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_SP_06 = new JLabel("Date Of Birth (DD/MM/YYYY)");
        JL_SP_06.setForeground(new Color(0x799C42D8, true));
        JL_SP_06.setFont(new Font("Arial", Font.BOLD, 20));
        JL_SP_06.setBounds(370, 240, 270, 20);

        JT_SP_05 = new JTextField();
        JT_SP_05.setFont(new Font("Arial", Font.BOLD, 20));
        JT_SP_05.setForeground(new Color(0x9A9AEC));
        JT_SP_05.setBackground(new Color(0x393949));
        JT_SP_05.setCaretColor(Color.BLACK);
        JT_SP_05.setBorder(BorderFactory.createEmptyBorder());
        JT_SP_05.setBounds(650, 235, 170, 30);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_SP_07 = new JLabel("Contact Number");
        JL_SP_07.setForeground(new Color(0x799C42D8, true));
        JL_SP_07.setFont(new Font("Arial", Font.BOLD, 20));
        JL_SP_07.setBounds(30, 350, 170, 20);

        JT_SP_06 = new JTextField();
        JT_SP_06.setFont(new Font("Arial", Font.BOLD, 20));
        JT_SP_06.setForeground(new Color(0x9A9AEC));
        JT_SP_06.setBackground(new Color(0x393949));
        JT_SP_06.setCaretColor(Color.BLACK);
        JT_SP_06.setBorder(BorderFactory.createEmptyBorder());
        JT_SP_06.setBounds(200, 345, 180, 30);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_SP_08 = new JLabel("Gender");
        JL_SP_08.setForeground(new Color(0x799C42D8, true));
        JL_SP_08.setFont(new Font("Arial", Font.BOLD, 20));
        JL_SP_08.setBounds(410, 350, 100, 20);

        String[] Gender = {"Male", "Female"};
        JC_SP_01 = new JComboBox(Gender);
        JC_SP_01.addActionListener(this);
        JC_SP_01.setBounds(520, 345, 100, 30);
        JC_SP_01.setBackground(new Color(0x393949));
        JC_SP_01.setForeground(new Color(0x9A9AEC));
        JC_SP_01.setFocusable(false);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_SP_09 = new JLabel("Note :");
        JL_SP_09.setForeground(new Color(0xCA1212));
        JL_SP_09.setFont(new Font("Arial", Font.BOLD, 20));
        JL_SP_09.setBounds(30, 490, 60, 20);

        JL_SP_10 = new JLabel("Your Username will be your Pan Number & Your Password will be your Contact Number.");
        JL_SP_10.setForeground(new Color(0xCA1212));
        JL_SP_10.setFont(new Font("Arial", Font.BOLD, 20));
        JL_SP_10.setBounds(100, 490, 900, 20);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JB_SP_01 = new JButton("Register");
        JB_SP_01.setFocusable(false);
        JB_SP_01.setBackground(new Color(0x17C17C));
        JB_SP_01.setBounds(450, 550, 100, 30);
        JB_SP_01.addActionListener(this);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        this.add(JL_SP_01);
        this.add(JL_SP_02);
        this.add(JL_SP_03);
        this.add(JL_SP_04);
        this.add(JL_SP_05);
        this.add(JL_SP_06);
        this.add(JL_SP_07);
        this.add(JL_SP_08);
        this.add(JL_SP_09);
        this.add(JL_SP_10);
        this.add(JT_SP_01);
        this.add(JT_SP_02);
        this.add(JT_SP_03);
        this.add(JT_SP_04);
        this.add(JT_SP_05);
        this.add(JT_SP_06);
        this.add(JC_SP_01);
        this.add(JB_SP_01);
        this.setVisible(true);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Overriding Action Listener Methods.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JC_SP_01) {
            System.out.println("Logic of selection of combo box goes here ......");
        } else if (e.getSource() == JB_SP_01) {
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            // Data Loading in the database.
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Loading the Driver.
                String url = "jdbc:mysql://localhost:3306/TaxMate_Database";
                String username = "root";
                String Password = "ayushrawat@2003123";

                Connection conn_obj = DriverManager.getConnection(url, username, Password);
                if (conn_obj.isClosed()) {
                    JOptionPane.showMessageDialog(null, "Some Error Occurred!!", "TaxMate", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Data adding in database

                    try {
                        String query = "insert into User_All_Info(FirstName,MiddleName,LastName,PanNumber,DateOfBirth,ContactNumber,Gender) values (?,?,?,?,?,?,?)";
                        PreparedStatement prepared_Statement = conn_obj.prepareStatement(query);
                        prepared_Statement.setString(1, JT_SP_01.getText());
                        prepared_Statement.setString(2, JT_SP_02.getText());
                        prepared_Statement.setString(3, JT_SP_03.getText());
                        prepared_Statement.setString(4, JT_SP_04.getText());
                        prepared_Statement.setString(5, JT_SP_05.getText());
                        prepared_Statement.setString(6, JT_SP_06.getText());
                        prepared_Statement.setString(7, (String) JC_SP_01.getSelectedItem());

                        prepared_Statement.execute();
                        JOptionPane.showMessageDialog(null, "Data has been added successfully", "TaxMate", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        new Home_Page();
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, "Some Error Occurred!!", "TaxMate", JOptionPane.ERROR_MESSAGE);
                        this.dispose();
                        new Home_Page();
                    }
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Some Error Occurred!!", "TaxMate", JOptionPane.INFORMATION_MESSAGE);
                new Home_Page();
            }
        }

    }

}