import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Profile_Page extends JFrame implements ActionListener {
    JButton JB_PP_01; // Profile Button
    JButton JB_PP_02; // Calculation Button
    JButton JB_PP_03; // History Button
    JButton JB_PP_04; // Version Button
    JPanel JP_PP_01; // Panel for the buttons.
    JLabel JL_PP_01; // Label for User_Logo.
    ImageIcon II_PP_01; // Logo for male.
    ImageIcon II_PP_02; //Logo for female.
    ImageIcon II_PP_03; // Logo for others.
    String FirstName,MiddleName,LastName,PanNumber,DateOfBirth,ContactNumber,Gender; // For User's Data.
    JLabel JL_PP_02; // Label for User's FirstName.
    JTextField JT_PP_01; // TextField for First Name
    JLabel JL_PP_03; //  Label for User's Middle Name.
    JTextField JT_PP_02; //TextField for User's Middle Name.
    JLabel JL_PP_04; //  Label for User's Last Name.
    JTextField JT_PP_03; //TextField for User's Last Name.
    JButton JB_PP_05; //Button for User's Information Update



    Profile_Page(String UserName,String PassWord)
    {
        this.setSize(1000,650);
        this.getContentPane().setBackground(new Color(0x202329));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("TaxMate");
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Creating Connection with database

        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // Loading the Driver.
            String url = "jdbc:mysql://localhost:3306/TaxMate_Database";
            String username = "root";
            String Password = "ayushrawat@2003123" ;
            Connection conn_obj = DriverManager.getConnection(url,username,Password);
                try
                {
                    String query1 = String.format("SELECT * FROM User_All_Info WHERE PanNumber = '%s'",UserName);
                    Statement stmt = conn_obj.createStatement();
                    ResultSet set = stmt.executeQuery(query1);
                    while(set.next())
                    {
                        FirstName = set.getString("FirstName");
                        MiddleName = set.getString("MiddleName");
                        LastName = set.getString("LastName");
                        PanNumber= set.getString("PanNumber");
                        DateOfBirth = set.getString("DateOfBirth");
                        ContactNumber = set.getString("ContactNumber");
                        Gender = set.getString("Gender");
                    }

                }
                catch (Exception e1234)
                {
                    JOptionPane.showMessageDialog(null, "Some Error Occurred !!", "TaxMate", JOptionPane.ERROR_MESSAGE);
                    new Home_Page();
                }
        }
        catch (Exception e123)
        {
            JOptionPane.showMessageDialog(null, "Some Error Occurred!!", "TaxMate", JOptionPane.ERROR_MESSAGE);
        }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Upper Buttons

        JB_PP_01 = new JButton("Profile");
        JB_PP_01.setFocusable(false);
        JB_PP_01.setBackground(new Color(0x17C17C));
        JB_PP_01.setEnabled(false);

        JB_PP_02 = new JButton("Calculation");
        JB_PP_02.setFocusable(false);
        JB_PP_02.setBackground(new Color(0x17C17C));
        JB_PP_02.addActionListener(this);

        JB_PP_03 = new JButton("History");
        JB_PP_03.setFocusable(false);
        JB_PP_03.setBackground(new Color(0x17C17C));
        JB_PP_03.addActionListener(this);

        JB_PP_04 = new JButton("Version");
        JB_PP_04.setFocusable(false);
        JB_PP_04.setBackground(new Color(0x17C17C));
        JB_PP_04.addActionListener(this);


        JP_PP_01 = new JPanel();
        JP_PP_01.setBounds(0,0,1000,50);
        JP_PP_01.setBackground(new Color(0x202329));
        JP_PP_01.setLayout(new FlowLayout());
        JP_PP_01.add(JB_PP_01);
        JP_PP_01.add(JB_PP_02);
        JP_PP_01.add(JB_PP_03);
        JP_PP_01.add(JB_PP_04);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        II_PP_01 = new ImageIcon("C:\\Users\\Ayush Rawat\\Desktop\\TaxMate\\TaxMate\\Images & Logos\\Male_Logo.jpg");
        JL_PP_01 = new JLabel("Hey "+FirstName);
        JL_PP_01.setBounds(50,200,250,300);
        JL_PP_01.setIcon(II_PP_01);
        JL_PP_01.setHorizontalTextPosition(JLabel.CENTER);
        JL_PP_01.setVerticalTextPosition(JLabel.BOTTOM);
        JL_PP_01.setForeground(new Color(0xB8B8D9));
        JL_PP_01.setFont(new Font("MV Boli",Font.BOLD,25));
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_PP_02 = new JLabel("First Name");
        JL_PP_02.setForeground(new Color(0xC0C0FF));
        JL_PP_02.setBounds(300,120,130,40);
        JL_PP_02.setFont(new Font("Arial",Font.BOLD,20));
        this.add(JL_PP_02);

        JT_PP_01 = new JTextField();
        JT_PP_01.setBounds(420,125,100,30);
        JT_PP_01.setBackground(new Color(0x3A3A4A));
        JT_PP_01.setBorder(BorderFactory.createEmptyBorder());
        JT_PP_01.setForeground(Color.WHITE);
        JT_PP_01.setCaretColor(Color.WHITE);
        JT_PP_01.setFont(new Font("Arial",Font.BOLD,20));
        JT_PP_01.setText(FirstName);
        JT_PP_01.setEditable(false);
        JT_PP_01.setCaretColor(new Color(0x3A3A4A));
        this.add(JT_PP_01); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_PP_03 = new JLabel("Middle Name");
        JL_PP_03.setForeground(new Color(0xC0C0FF));
        JL_PP_03.setBounds(530,120,130,40);
        JL_PP_03.setFont(new Font("Arial",Font.BOLD,20));
        this.add(JL_PP_03);

        JT_PP_02 = new JTextField();
        JT_PP_02.setBounds(660,125,100,30);
        JT_PP_02.setBackground(new Color(0x3A3A4A));
        JT_PP_02.setBorder(BorderFactory.createEmptyBorder());
        JT_PP_02.setForeground(Color.WHITE);
        JT_PP_02.setCaretColor(Color.WHITE);
        JT_PP_02.setFont(new Font("Arial",Font.BOLD,20));
        JT_PP_02.setText(MiddleName);
        JT_PP_02.setEditable(false);
        JT_PP_02.setCaretColor(new Color(0x3A3A4A));
        this.add(JT_PP_02); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_PP_04 = new JLabel("Last Name");
        JL_PP_04.setForeground(new Color(0xC0C0FF));
        JL_PP_04.setBounds(770,120,130,40);
        JL_PP_04.setFont(new Font("Arial",Font.BOLD,20));
        this.add(JL_PP_04);

        JT_PP_03 = new JTextField();
        JT_PP_03.setBounds(880,125,100,30);
        JT_PP_03.setBackground(new Color(0x3A3A4A));
        JT_PP_03.setBorder(BorderFactory.createEmptyBorder());
        JT_PP_03.setForeground(Color.WHITE);
        JT_PP_03.setCaretColor(Color.WHITE);
        JT_PP_03.setFont(new Font("Arial",Font.BOLD,20));
        JT_PP_03.setText(LastName);
        JT_PP_03.setEditable(false);
        JT_PP_03.setCaretColor(new Color(0x3A3A4A));
        this.add(JT_PP_03); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_PP_04 = new JLabel("PAN Number");
        JL_PP_04.setForeground(new Color(0xC0C0FF));
        JL_PP_04.setBounds(350,220,130,40);
        JL_PP_04.setFont(new Font("Arial",Font.BOLD,20));
        this.add(JL_PP_04);

        JT_PP_03 = new JTextField();
        JT_PP_03.setBounds(485,225,180,30);
        JT_PP_03.setBackground(new Color(0x3A3A4A));
        JT_PP_03.setBorder(BorderFactory.createEmptyBorder());
        JT_PP_03.setForeground(Color.WHITE);
        JT_PP_03.setCaretColor(Color.WHITE);
        JT_PP_03.setFont(new Font("Arial",Font.BOLD,20));
        JT_PP_03.setText(PanNumber);
        JT_PP_03.setEditable(false);
        JT_PP_03.setCaretColor(new Color(0x3A3A4A));
        this.add(JT_PP_03); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_PP_04 = new JLabel("Date Of Birth");
        JL_PP_04.setForeground(new Color(0xC0C0FF));
        JL_PP_04.setBounds(700,220,130,40);
        JL_PP_04.setFont(new Font("Arial",Font.BOLD,20));
        this.add(JL_PP_04);

        JT_PP_03 = new JTextField();
        JT_PP_03.setBounds(830,225,130,30);
        JT_PP_03.setBackground(new Color(0x3A3A4A));
        JT_PP_03.setBorder(BorderFactory.createEmptyBorder());
        JT_PP_03.setForeground(Color.WHITE);
        JT_PP_03.setCaretColor(Color.WHITE);
        JT_PP_03.setFont(new Font("Arial",Font.BOLD,20));
        JT_PP_03.setText(DateOfBirth);
        JT_PP_03.setEditable(false);
        JT_PP_03.setCaretColor(new Color(0x3A3A4A));
        this.add(JT_PP_03); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_PP_04 = new JLabel("Contact Number");
        JL_PP_04.setForeground(new Color(0xC0C0FF));
        JL_PP_04.setBounds(400,320,180,40);
        JL_PP_04.setFont(new Font("Arial",Font.BOLD,20));
        this.add(JL_PP_04);

        JT_PP_03 = new JTextField();
        JT_PP_03.setBounds(570,325,130,30);
        JT_PP_03.setBackground(new Color(0x3A3A4A));
        JT_PP_03.setBorder(BorderFactory.createEmptyBorder());
        JT_PP_03.setForeground(Color.WHITE);
        JT_PP_03.setCaretColor(Color.WHITE);
        JT_PP_03.setFont(new Font("Arial",Font.BOLD,20));
        JT_PP_03.setText(ContactNumber);
        JT_PP_03.setEditable(false);
        JT_PP_03.setCaretColor(new Color(0x3A3A4A));
        this.add(JT_PP_03); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_PP_04 = new JLabel("Gender");
        JL_PP_04.setForeground(new Color(0xC0C0FF));
        JL_PP_04.setBounds(730,320,180,40);
        JL_PP_04.setFont(new Font("Arial",Font.BOLD,20));
        this.add(JL_PP_04);

        JT_PP_03 = new JTextField();
        JT_PP_03.setBounds(810,325,100,30);
        JT_PP_03.setBackground(new Color(0x3A3A4A));
        JT_PP_03.setBorder(BorderFactory.createEmptyBorder());
        JT_PP_03.setForeground(Color.WHITE);
        JT_PP_03.setCaretColor(Color.WHITE);
        JT_PP_03.setFont(new Font("Arial",Font.BOLD,25));
        JT_PP_03.setText(Gender);
        JT_PP_03.setEditable(false);
        JT_PP_03.setCaretColor(new Color(0x3A3A4A));
        this.add(JT_PP_03); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JB_PP_05 = new JButton("Update Profile ");
        JB_PP_05.setBounds(550,450,200,40);
        JB_PP_05.setBackground(new Color(0x17C17C));
        JB_PP_05.setFocusable(false);
        this.add(JB_PP_05);
        JB_PP_05.addActionListener(this);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        this.add(JP_PP_01);
        this.add(JL_PP_01);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JB_PP_02)
        {
            new Calculation_Page(PanNumber,ContactNumber);
            this.dispose();
        }
        if (e.getSource() == JB_PP_03)
        {
            JOptionPane.showMessageDialog(null,"This Feature Will be available in Next Update","TaxMate",JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == JB_PP_04)
        {
            this.dispose();
            new Version_Page(PanNumber,ContactNumber);
        }
        if (e.getSource() == JB_PP_05)
        {
            JOptionPane.showMessageDialog(null,"This Feature will be Available in Next Version","TaxMate",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
