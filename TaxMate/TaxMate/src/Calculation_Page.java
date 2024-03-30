import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Calculation_Page extends JFrame implements ActionListener {
    // Declaring Variables
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    JButton JB_CP_01; //Profile Button.
    JButton JB_CP_02; //Calculation Button.
    JButton JB_CP_03; //History Button.
    JButton JB_CP_04; //Version Button.
    JPanel JP_CP_01; //Panel for buttons.
    JButton JB_CP_05; //Next Button.
    JPanel JP_CP_02; //Income from Salary Panel
    JLabel JL_CP_02; //Basic salary label.
    JTextField JT_CP_01; //TextField for Basic Salary.
    JLabel JL_CP_03; //Dearness Allowance label.
    JTextField JT_CP_02; //TextField for Dearness Allowance.
    JLabel JL_CP_04; //Travel Allowance label.
    JTextField JT_CP_03; //TextField for Travel Allowance.
    JLabel JL_CP_05; // Medical Allowance Label.
    JTextField JT_CP_04; //TextField for Medical Allowance.
    JLabel JL_CP_06; // Children Education Allowance Label.
    JTextField JT_CP_05; //TextField for  Children Education Allowance
    JLabel JL_CP_07; //House Rent Allowance Label.
    JTextField JT_CP_06; //TextField for House Rent Allowance.
    JPanel JP_CP_03; //House Rent Income Panel.
    JLabel JL_CP_08; //House Rent Income Label.
    JLabel JL_CP_09; //Gross Rent Label.
    JTextField JT_CP_07; //TextField for Gross Rent.
    JLabel JL_CP_10; //Maintenance Expense Label
    JTextField JT_CP_08; //TextField for Maintenance Expense.
    JPanel JP_CP_04; //Capital Gains Panel.
    JLabel JL_CP_11; //Capital Gains Label.
    JLabel JL_CP_12; // Sale of Land/Property Label.
    JTextField JT_CP_09; //TextField of Sale of Land/Property.
    JLabel JL_CP_13; //Sale of Equity/Share Label.
    JTextField JT_CP_10; //TextField of Sale of Equity/Share.
    JLabel JL_CP_14; //Sale of Other Assets Label.
    JLabel JL_CP_15; //(Gold/Car) Label.
    JTextField JT_CP_11; // TextField of Sale of Other Assets.
    JPanel JP_CP_05; // Other Gains Panel
    JLabel JL_CP_16; // Other Gains Label.
    JLabel JL_CP_17; //Interest from Saving A/C.
    JTextField JT_CP_12; //TextField for Interest from Saving A/C.
    JLabel JL_CP_18; //Interest from Saving A/C. (2)
    JLabel JL_CP_19; // Rental Income From Machinery/Plant etc. Label.
    JLabel JL_CP_20; // Rental Income From Machinery/Plant etc.  Label. (2)
    JTextField JT_CP_13; // TextField for Rental Income from Machinery/Plant etc.
    JLabel JL_CP_21; //Family Pension Label.
    JTextField JT_CP_14; //TextField for Family Pension.
    JLabel JL_CP_22; //Cash Gifts Label.
    JTextField JT_CP_15; //TextField for Cash Gifts.
    JTextField JT_CP_16;
    Integer Total_Amount; //
    String UserName_CP;
    String PassWord_CP;
    Calculation_Page(String UserName,String PassWord)
    {
        UserName_CP = UserName;
        PassWord_CP = PassWord;
        this.setSize(1000,650);
        this.getContentPane().setBackground(new Color(0x202329));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("TaxMate");

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Upper Buttons

        JB_CP_01 = new JButton("Profile");
        JB_CP_01.setFocusable(false);
        JB_CP_01.setBackground(new Color(0x17C17C));
        JB_CP_01.addActionListener(this);


        JB_CP_02 = new JButton("Calculation");
        JB_CP_02.setFocusable(false);
        JB_CP_02.setBackground(new Color(0x17C17C));
        JB_CP_02.setEnabled(false);

        JB_CP_03 = new JButton("History");
        JB_CP_03.setFocusable(false);
        JB_CP_03.setBackground(new Color(0x17C17C));
        JB_CP_03.addActionListener(this);

        JB_CP_04 = new JButton("Version");
        JB_CP_04.setFocusable(false);
        JB_CP_04.setBackground(new Color(0x17C17C));
        JB_CP_04.addActionListener(this);


        JP_CP_01 = new JPanel();
        JP_CP_01.setBounds(0,0,1000,50);
        JP_CP_01.setBackground(new Color(0x202329));
        JP_CP_01.setLayout(new FlowLayout());
        JP_CP_01.add(JB_CP_01);
        JP_CP_01.add(JB_CP_02);
        JP_CP_01.add(JB_CP_03);
        JP_CP_01.add(JB_CP_04);

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JB_CP_05 = new JButton("Evaluate ...");
        JB_CP_05.setBounds(830,570,120,30);
        JB_CP_05.setFocusable(false);
        JB_CP_05.setBackground(new Color(0x17C17C));
        JB_CP_05.addActionListener(this);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JP_CP_02 = new JPanel();
        JP_CP_02.setBounds(20,40,480,350);
        JP_CP_02.setBackground(new Color(0x2D2D35));
        JP_CP_02.setLayout(null);

        JL_CP_04 = new JLabel("Income From Salary");
        JL_CP_04.setForeground(new Color(0xC0C0FF));
        JL_CP_04.setBounds(100,10,400,40);
        JL_CP_04.setFont(new Font("Arial",Font.BOLD,30));
        JP_CP_02.add(JL_CP_04);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Basic Salary Column
        JL_CP_02 = new JLabel("> Basic Salary");
        JL_CP_02.setForeground(new Color(0x7C7CDC));
        JL_CP_02.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_02.setBounds(20,60,240,30);
        JP_CP_02.add(JL_CP_02); //Adding Label in Panel

        JT_CP_01 = new JTextField();
        JT_CP_01.setBounds(260,60,180,30);
        JT_CP_01.setBackground(new Color(0x3A3A4A));
        JT_CP_01.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_01.setForeground(Color.WHITE);
        JT_CP_01.setCaretColor(Color.WHITE);
        JT_CP_01.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_02.add(JT_CP_01); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Dearness Allowance Column
        JL_CP_03 = new JLabel("> Dearness Allowance");
        JL_CP_03.setForeground(new Color(0x7C7CDC));
        JL_CP_03.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_03.setBounds(20,100,240,30);
        JP_CP_02.add(JL_CP_03); //Adding Label in Panel

        JT_CP_02 = new JTextField();
        JT_CP_02.setBounds(260,100,180,30);
        JT_CP_02.setBackground(new Color(0x3A3A4A));
        JT_CP_02.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_02.setForeground(Color.WHITE);
        JT_CP_02.setCaretColor(Color.WHITE);
        JT_CP_02.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_02.add(JT_CP_02); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Travel Allowance Column
        JL_CP_04 = new JLabel("> Travel Allowance");
        JL_CP_04.setForeground(new Color(0x7C7CDC));
        JL_CP_04.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_04.setBounds(20,140,200,30);
        JP_CP_02.add(JL_CP_04); //Adding Label in Panel

        JT_CP_03 = new JTextField();
        JT_CP_03.setBounds(260,140,180,30);
        JT_CP_03.setBackground(new Color(0x3A3A4A));
        JT_CP_03.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_03.setForeground(Color.WHITE);
        JT_CP_03.setCaretColor(Color.WHITE);
        JT_CP_03.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_02.add(JT_CP_03); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Medical Allowance Column
        JL_CP_05 = new JLabel("> Medical Allowance");
        JL_CP_05.setForeground(new Color(0x7C7CDC));
        JL_CP_05.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_05.setBounds(20,180,200,30);
        JP_CP_02.add(JL_CP_05); //Adding Label in Panel

        JT_CP_04 = new JTextField();
        JT_CP_04.setBounds(260,180,180,30);
        JT_CP_04.setBackground(new Color(0x3A3A4A));
        JT_CP_04.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_04.setForeground(Color.WHITE);
        JT_CP_04.setCaretColor(Color.WHITE);
        JT_CP_04.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_02.add(JT_CP_04); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Commission  Column
        JL_CP_05 = new JLabel("> Commission");
        JL_CP_05.setForeground(new Color(0x7C7CDC));
        JL_CP_05.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_05.setBounds(20,220,200,30);
        JP_CP_02.add(JL_CP_05); //Adding Label in Panel

        JT_CP_05 = new JTextField();
        JT_CP_05.setBounds(260,220,180,30);
        JT_CP_05.setBackground(new Color(0x3A3A4A));
        JT_CP_05.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_05.setForeground(Color.WHITE);
        JT_CP_05.setCaretColor(Color.WHITE);
        JT_CP_05.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_02.add(JT_CP_05); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Education Allowance  Column
        JL_CP_06 = new JLabel("> Education Allowance");
        JL_CP_06.setForeground(new Color(0x7C7CDC));
        JL_CP_06.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_06.setBounds(20,260,240,30);
        JP_CP_02.add(JL_CP_06); //Adding Label in Panel

        JT_CP_06 = new JTextField();
        JT_CP_06.setBounds(260,260,180,30);
        JT_CP_06.setBackground(new Color(0x3A3A4A));
        JT_CP_06.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_06.setForeground(Color.WHITE);
        JT_CP_06.setCaretColor(Color.WHITE);
        JT_CP_06.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_02.add(JT_CP_06); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //House Rent Allowance Column
        JL_CP_07 = new JLabel("> House Rent Allowance ");
        JL_CP_07.setForeground(new Color(0x7C7CDC));
        JL_CP_07.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_07.setBounds(20,300,240,30);
        JP_CP_02.add(JL_CP_07); //Adding Label in Panel

        JT_CP_07 = new JTextField();
        JT_CP_07.setBounds(260,300,180,30);
        JT_CP_07.setBackground(new Color(0x3A3A4A));
        JT_CP_07.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_07.setForeground(Color.WHITE);
        JT_CP_07.setCaretColor(Color.WHITE);
        JT_CP_07.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_02.add(JT_CP_07); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JP_CP_03 = new JPanel();
        JP_CP_03.setBounds(20,410,480,160);
        JP_CP_03.setBackground(new Color(0x2D2D35));
        JP_CP_03.setLayout(null);

        JL_CP_08 = new JLabel("House Rent Income");
        JL_CP_08.setForeground(new Color(0xC0C0FF));
        JL_CP_08.setBounds(100,10,400,40);
        JL_CP_08.setFont(new Font("Arial",Font.BOLD,30));
        JP_CP_03.add(JL_CP_08);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Gross Rent Column
        JL_CP_09 = new JLabel("> Gross Rent Received");
        JL_CP_09.setForeground(new Color(0x7C7CDC));
        JL_CP_09.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_09.setBounds(20,60,240,30);
        JP_CP_03.add(JL_CP_09); //Adding Label in Panel

        JT_CP_08 = new JTextField();
        JT_CP_08.setBounds(260,60,180,30);
        JT_CP_08.setBackground(new Color(0x3A3A4A));
        JT_CP_08.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_08.setForeground(Color.WHITE);
        JT_CP_08.setCaretColor(Color.WHITE);
        JT_CP_08.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_03.add(JT_CP_08); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Gross Rent Column
        JL_CP_10 = new JLabel("> Maintenance Expense");
        JL_CP_10.setForeground(new Color(0x7C7CDC));
        JL_CP_10.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_10.setBounds(20,100,240,30);
        JP_CP_03.add(JL_CP_10); //Adding Label in Panel

        JT_CP_09 = new JTextField();
        JT_CP_09.setBounds(260,100,180,30);
        JT_CP_09.setBackground(new Color(0x3A3A4A));
        JT_CP_09.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_09.setForeground(Color.WHITE);
        JT_CP_09.setCaretColor(Color.WHITE);
        JT_CP_09.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_03.add(JT_CP_09); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JP_CP_04 = new JPanel();
        JP_CP_04.setBounds(520,40,440,210);
        JP_CP_04.setBackground(new Color(0x2D2D35));
        JP_CP_04.setLayout(null);

        JL_CP_11 = new JLabel("Capital Gains");
        JL_CP_11.setForeground(new Color(0xC0C0FF));
        JL_CP_11.setBounds(120,10,400,40);
        JL_CP_11.setFont(new Font("Arial",Font.BOLD,30));
        JP_CP_04.add(JL_CP_11);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Sale of Land/Property Column
        JL_CP_12 = new JLabel("> Sale of Land/Property");
        JL_CP_12.setForeground(new Color(0x7C7CDC));
        JL_CP_12.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_12.setBounds(20,60,240,30);
        JP_CP_04.add(JL_CP_12); //Adding Label in Panel

        JT_CP_10 = new JTextField();
        JT_CP_10.setBounds(260,60,160,30);
        JT_CP_10.setBackground(new Color(0x3A3A4A));
        JT_CP_10.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_10.setForeground(Color.WHITE);
        JT_CP_10.setCaretColor(Color.WHITE);
        JT_CP_10.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_04.add(JT_CP_10); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Sale of Equity/Share Column
        JL_CP_13 = new JLabel("> Sale of Equity/Share");
        JL_CP_13.setForeground(new Color(0x7C7CDC));
        JL_CP_13.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_13.setBounds(20,100,240,30);
        JP_CP_04.add(JL_CP_13); //Adding Label in Panel

        JT_CP_11 = new JTextField();
        JT_CP_11.setBounds(260,100,160,30);
        JT_CP_11.setBackground(new Color(0x3A3A4A));
        JT_CP_11.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_11.setForeground(Color.WHITE);
        JT_CP_11.setCaretColor(Color.WHITE);
        JT_CP_11.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_04.add(JT_CP_11); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Sale of other Asset Column
        JL_CP_14 = new JLabel("> Sale of Other Assets");
        JL_CP_14.setForeground(new Color(0x7C7CDC));
        JL_CP_14.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_14.setBounds(20,140,240,30);
        JP_CP_04.add(JL_CP_14); //Adding Label in Panel

        JL_CP_15 = new JLabel("(Gold/Car)");
        JL_CP_15.setForeground(new Color(0x7C7CDC));
        JL_CP_15.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_15.setBounds(70,170,240,30);
        JP_CP_04.add(JL_CP_15); //Adding Label in Panel

        JT_CP_12 = new JTextField();
        JT_CP_12.setBounds(260,140,160,30);
        JT_CP_12.setBackground(new Color(0x3A3A4A));
        JT_CP_12.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_12.setForeground(Color.WHITE);
        JT_CP_12.setCaretColor(Color.WHITE);
        JT_CP_12.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_04.add(JT_CP_12); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Other Gains Panel
        JP_CP_05 = new JPanel();
        JP_CP_05.setBounds(520,270,440,280);
        JP_CP_05.setBackground(new Color(0x2D2D35));
        JP_CP_05.setLayout(null);

        JL_CP_16 = new JLabel("Other Gains");
        JL_CP_16.setForeground(new Color(0xC0C0FF));
        JL_CP_16.setBounds(120,10,400,40);
        JL_CP_16.setFont(new Font("Arial",Font.BOLD,30));
        JP_CP_05.add(JL_CP_16);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Interest from Saving Account Column
        JL_CP_17 = new JLabel("> Interest From Saving");
        JL_CP_17.setForeground(new Color(0x7C7CDC));
        JL_CP_17.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_17.setBounds(20,60,240,30);
        JP_CP_05.add(JL_CP_17); //Adding Label in Panel

        JL_CP_18 = new JLabel(" Account");
        JL_CP_18.setForeground(new Color(0x7C7CDC));
        JL_CP_18.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_18.setBounds(30,80,240,30);
        JP_CP_05.add(JL_CP_18); //Adding Label in Panel

        JT_CP_13 = new JTextField();
        JT_CP_13.setBounds(260,60,160,30);
        JT_CP_13.setBackground(new Color(0x3A3A4A));
        JT_CP_13.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_13.setForeground(Color.WHITE);
        JT_CP_13.setCaretColor(Color.WHITE);
        JT_CP_13.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_05.add(JT_CP_13); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------        this.add(JB_CP_05);
        // Rental Income from Machinery etc.
        JL_CP_19 = new JLabel("> Rental Income from");
        JL_CP_19.setForeground(new Color(0x7C7CDC));
        JL_CP_19.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_19.setBounds(20,115,240,30);
        JP_CP_05.add(JL_CP_19); //Adding Label in Panel

        JL_CP_20 = new JLabel("Machinery/Plant etc.");
        JL_CP_20.setForeground(new Color(0x7C7CDC));
        JL_CP_20.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_20.setBounds(35,135,240,30);
        JP_CP_05.add(JL_CP_20); //Adding Label in Panel

        JT_CP_14 = new JTextField();
        JT_CP_14.setBounds(260,115,160,30);
        JT_CP_14.setBackground(new Color(0x3A3A4A));
        JT_CP_14.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_14.setForeground(Color.WHITE);
        JT_CP_14.setCaretColor(Color.WHITE);
        JT_CP_14.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_05.add(JT_CP_14); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Family Pension Column
        JL_CP_21 = new JLabel("> Family Pension");
        JL_CP_21.setForeground(new Color(0x7C7CDC));
        JL_CP_21.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_21.setBounds(20,170,240,30);
        JP_CP_05.add(JL_CP_21); //Adding Label in Panel

        JT_CP_15 = new JTextField();
        JT_CP_15.setBounds(260,170,160,30);
        JT_CP_15.setBackground(new Color(0x3A3A4A));
        JT_CP_15.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_15.setForeground(Color.WHITE);
        JT_CP_15.setCaretColor(Color.WHITE);
        JT_CP_15.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_05.add(JT_CP_15); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Cash Gifts Column
        JL_CP_22 = new JLabel("> Cash Gifts");
        JL_CP_22.setForeground(new Color(0x7C7CDC));
        JL_CP_22.setFont(new Font("Arial",Font.BOLD,20));
        JL_CP_22.setBounds(20,215,240,30);
        JP_CP_05.add(JL_CP_22); //Adding Label in Panel

        JT_CP_16 = new JTextField();
        JT_CP_16.setBounds(260,215,160,30);
        JT_CP_16.setBackground(new Color(0x3A3A4A));
        JT_CP_16.setBorder(BorderFactory.createEmptyBorder());
        JT_CP_16.setForeground(Color.WHITE);
        JT_CP_16.setCaretColor(Color.WHITE);
        JT_CP_16.setFont(new Font("Arial",Font.BOLD,18));
        JP_CP_05.add(JT_CP_16); //Adding TextField in Panel
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        this.add(JB_CP_05);
        this.add(JP_CP_01);
        this.add(JP_CP_02);
        this.add(JP_CP_03);
        this.add(JP_CP_04);
        this.add(JP_CP_05);

        this.setVisible(true);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Calculation Block
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JB_CP_05)
        {
            Total_Amount = 0;
            try {
                    Total_Amount += Integer.parseInt(JT_CP_01.getText());
                    Total_Amount += Integer.parseInt(JT_CP_02.getText());
                    Total_Amount += Integer.parseInt(JT_CP_03.getText());
                    Total_Amount += Integer.parseInt(JT_CP_04.getText());
                    Total_Amount += Integer.parseInt(JT_CP_05.getText());
                    Total_Amount += Integer.parseInt(JT_CP_06.getText());
                    Total_Amount += Integer.parseInt(JT_CP_07.getText());
                    Total_Amount -= Integer.parseInt(JT_CP_08.getText());
                    Total_Amount += Integer.parseInt(JT_CP_09.getText());
                    Total_Amount += Integer.parseInt(JT_CP_10.getText());
                    Total_Amount += Integer.parseInt(JT_CP_11.getText());
                    Total_Amount += Integer.parseInt(JT_CP_12.getText());
                    Total_Amount += Integer.parseInt(JT_CP_13.getText());
                    Total_Amount += Integer.parseInt(JT_CP_14.getText());
                    Total_Amount += Integer.parseInt(JT_CP_15.getText());
                    this.dispose();
                    new Calculation_Extended(Total_Amount,UserName_CP,PassWord_CP);
            }catch(Exception e123)
            {
                JOptionPane.showMessageDialog(null,"Some Error Occurred !!","TaxMate",JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == JB_CP_01)
        {
            new Profile_Page(UserName_CP,PassWord_CP);
        }
        if (e.getSource() == JB_CP_03)
        {
            JOptionPane.showMessageDialog(null,"This Feature Will be available in Next Update","TaxMate",JOptionPane.INFORMATION_MESSAGE);

        }
        if (e.getSource() == JB_CP_04)
        {
            new Version_Page(UserName_CP,PassWord_CP);
        }
    }
}

class Calculation_Extended extends JFrame implements ActionListener
{
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Variable Declaration.
    String Username_CEP;
    String Password_CEP;
    JButton JB_CEP_01; // Back Button
    String FirstName,MiddleName,LastName,PanNumber,DateOfBirth,ContactNumber,Gender; // For User's Data.
    int Income_Tax;
    JLabel JL_CEP_01; // For Text
    JLabel JL_CEP_02;
    JTextField JT_CEP_01;
    JLabel JL_CEP_03;
    JTextField JT_CEP_02;
    JLabel JL_CEP_04;
    JTextField JT_CEP_03;
    JLabel JL_CEP_05;
    JLabel JL_CEP_06;
    JLabel JL_CEP_07;
    int Net_Income;

    Calculation_Extended(int Total,String UserName, String PassWord)
    {
        Net_Income = Total;
        Username_CEP = UserName;
        Password_CEP = PassWord;
        this.setSize(1000,650);
        this.getContentPane().setBackground(new Color(0x202329));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("TaxMate");
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Logic For Income_Tax
        while (Total != 0)
        {
            int amt;
            double taxRate;

            if (Total > 1500000) {
                amt = Total - 1500000;
                taxRate = 0.3;
            } else if (Total > 1200000) {
                amt = Total - 1200000;
                taxRate = 0.2;
            } else if (Total > 900000) {
                amt = Total - 900000;
                taxRate = 0.15;
            } else if (Total > 600000) {
                amt = Total - 600000;
                taxRate = 0.1;
            } else if (Total > 300000) {
                amt = Total - 300000;
                taxRate = 0.05;
            } else {
                amt = Total;
                taxRate = 0.0;
            }
            double tax = amt * taxRate;
            Income_Tax += tax;
            Total -= amt;
        }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JB_CEP_01 = new JButton("Back");
        JB_CEP_01.setFocusable(false);
        JB_CEP_01.setBackground(new Color(0x17C17C));
        JB_CEP_01.setBounds(20,20,100,30);
        JB_CEP_01.addActionListener(this);
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
        JL_CEP_01 = new JLabel("User's Info.");
        JL_CEP_01.setForeground(new Color(0xC0C0FF));
        JL_CEP_01.setBounds(400,60,200,40);
        JL_CEP_01.setFont(new Font("Arial",Font.CENTER_BASELINE,30));
        this.add(JL_CEP_01);


        JL_CEP_02 = new JLabel("Name");
        JL_CEP_02.setForeground(new Color(0xC0C0FF));
        JL_CEP_02.setBounds(300,160,130,40);
        JL_CEP_02.setFont(new Font("Arial",Font.BOLD,20));
        this.add(JL_CEP_02);

        JT_CEP_01 = new JTextField();
        JT_CEP_01.setBounds(380,165,180,30);
        JT_CEP_01.setBackground(new Color(0x3A3A4A));
        JT_CEP_01.setBorder(BorderFactory.createEmptyBorder());
        JT_CEP_01.setForeground(Color.WHITE);
        JT_CEP_01.setCaretColor(Color.WHITE);
        JT_CEP_01.setFont(new Font("Arial",Font.BOLD,20));
        JT_CEP_01.setText(FirstName+" "+MiddleName+" "+LastName);
        JT_CEP_01.setEditable(false);
        JT_CEP_01.setCaretColor(new Color(0x3A3A4A));
        this.add(JT_CEP_01); //Adding TextField in Panel

        JL_CEP_03 = new JLabel("PAN Number");
        JL_CEP_03.setForeground(new Color(0xC0C0FF));
        JL_CEP_03.setBounds(300,220,130,40);
        JL_CEP_03.setFont(new Font("Arial",Font.BOLD,20));
        this.add(JL_CEP_03);

        JT_CEP_02 = new JTextField();
        JT_CEP_02.setBounds(430,225,180,30);
        JT_CEP_02.setBackground(new Color(0x3A3A4A));
        JT_CEP_02.setBorder(BorderFactory.createEmptyBorder());
        JT_CEP_02.setForeground(Color.WHITE);
        JT_CEP_02.setCaretColor(Color.WHITE);
        JT_CEP_02.setFont(new Font("Arial",Font.BOLD,20));
        JT_CEP_02.setText(PanNumber);
        JT_CEP_02.setEditable(false);
        JT_CEP_02.setCaretColor(new Color(0x3A3A4A));
        this.add(JT_CEP_02); //Adding TextField in Panel


        JL_CEP_04 = new JLabel("Contact Number");
        JL_CEP_04.setForeground(new Color(0xC0C0FF));
        JL_CEP_04.setBounds(300,280,180,40);
        JL_CEP_04.setFont(new Font("Arial",Font.BOLD,20));
        this.add(JL_CEP_04);

        JT_CEP_03 = new JTextField();
        JT_CEP_03.setBounds(460,285,130,30);
        JT_CEP_03.setBackground(new Color(0x3A3A4A));
        JT_CEP_03.setBorder(BorderFactory.createEmptyBorder());
        JT_CEP_03.setForeground(Color.WHITE);
        JT_CEP_03.setCaretColor(Color.WHITE);
        JT_CEP_03.setFont(new Font("Arial",Font.BOLD,20));
        JT_CEP_03.setText(ContactNumber);
        JT_CEP_03.setEditable(false);
        JT_CEP_03.setCaretColor(new Color(0x3A3A4A));
        this.add(JT_CEP_03); //Adding TextField in Panel

        JL_CEP_05 = new JLabel("Your Income Tax For Financial Year 2022/2023 \n According to Government Authorised Tax Slab ");
        JL_CEP_05.setBounds(70,350,900,60);
        JL_CEP_05.setFont(new Font("Arial",Font.BOLD,20));
        JL_CEP_05.setForeground(new Color(0xC80D0D));
        this.add(JL_CEP_05);

        JL_CEP_06 = new JLabel("Gross Income : "+Net_Income);
        JL_CEP_06.setBounds(300,420,400,40);
        JL_CEP_06.setFont(new Font("Arial",Font.BOLD,20));
        JL_CEP_06.setForeground(new Color(0x33CED3));
        JL_CEP_07 = new JLabel("Calculated Income Tax : "+Income_Tax);
        JL_CEP_07.setBounds(300,470,400,40);
        JL_CEP_07.setFont(new Font("Arial",Font.BOLD,20));
        JL_CEP_07.setForeground(new Color(0x33CED3));
        this.add(JL_CEP_06);
        this.add(JL_CEP_07);

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        this.setVisible(true);
        this.add(JB_CEP_01);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==JB_CEP_01)
        {
            new Profile_Page(Username_CEP,Password_CEP);
        }
    }
}