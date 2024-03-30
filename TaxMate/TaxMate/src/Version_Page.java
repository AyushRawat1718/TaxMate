import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Version_Page extends JFrame implements ActionListener
{
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Variable Declaration.
    JButton JB_VP_01; //Profile Button.
    JButton JB_VP_02; //Calculation Button.
    JButton JB_VP_03; //History Button.
    JButton JB_VP_04; //Version Button.
    JPanel JP_VP_01; //Button Panel
    String UserName_VP = "";
    String Password_VP = "";
    JLabel JL_VP_01;
    JPanel JP_VP_02;
    JLabel JL_VP_02;
    JLabel JL_VP_03;
    JLabel JL_VP_04;
    JLabel JL_VP_05;
    JLabel JL_VP_06;
    JPanel JP_VP_03;


    Version_Page(String UserName,String PassWord)
    {
        UserName_VP = UserName;
        Password_VP = PassWord;
        this.setSize(1000,650);
        this.getContentPane().setBackground(new Color(0x202329));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("TaxMate");
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Upper Buttons

        JB_VP_01 = new JButton("Profile");
        JB_VP_01.setFocusable(false);
        JB_VP_01.setBackground(new Color(0x17C17C));
        JB_VP_01.addActionListener(this);

        JB_VP_02 = new JButton("Calculation");
        JB_VP_02.setFocusable(false);
        JB_VP_02.setBackground(new Color(0x17C17C));
        JB_VP_02.addActionListener(this);

        JB_VP_03 = new JButton("History");
        JB_VP_03.setFocusable(false);
        JB_VP_03.setBackground(new Color(0x17C17C));
        JB_VP_03.addActionListener(this);

        JB_VP_04 = new JButton("Version");
        JB_VP_04.setFocusable(false);
        JB_VP_04.setBackground(new Color(0x17C17C));
        JB_VP_04.setEnabled(false);


        JP_VP_01 = new JPanel();
        JP_VP_01.setBounds(0,0,1000,50);
        JP_VP_01.setBackground(new Color(0x202329));
        JP_VP_01.setLayout(new FlowLayout());
        JP_VP_01.add(JB_VP_01);
        JP_VP_01.add(JB_VP_02);
        JP_VP_01.add(JB_VP_03);
        JP_VP_01.add(JB_VP_04);
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_VP_01 = new JLabel("Current Version : 1.0.0");
        JL_VP_01.setBounds(400,60,400,40);
        JL_VP_01.setFont(new Font("Arial",Font.BOLD,20));
        JL_VP_01.setForeground(new Color(0xC0C0FF));

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JP_VP_02 = new JPanel();
        JP_VP_02.setLayout(null);
        JP_VP_02.setBackground(new Color(0x2D2D35));
        JP_VP_02.setBounds(60,150,400,250);

        JP_VP_02.add(JL_VP_01);
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_VP_02 = new JLabel("Features Of Current Version");
        JL_VP_02.setBounds(60,10,400,40);
        JL_VP_02.setFont(new Font("Arial",Font.BOLD,20));
        JL_VP_02.setForeground(new Color(0x27A96F));

        JL_VP_03 = new JLabel("> Dark Theme Modern UI");
        JL_VP_03.setBounds(20,60,400,40);
        JL_VP_03.setFont(new Font("Arial",Font.BOLD,20));
        JL_VP_03.setForeground(new Color(0x27A96F));

        JL_VP_04 = new JLabel("> Easy to use User Interface");
        JL_VP_04.setBounds(20,100,400,40);
        JL_VP_04.setFont(new Font("Arial",Font.BOLD,20));
        JL_VP_04.setForeground(new Color(0x27A96F));

        JL_VP_05 = new JLabel("> Various Factors for Tax Calculation");
        JL_VP_05.setBounds(20,140,400,40);
        JL_VP_05.setFont(new Font("Arial",Font.BOLD,20));
        JL_VP_05.setForeground(new Color(0x27A96F));

        JL_VP_06 = new JLabel("> Secured Database");
        JL_VP_06.setBounds(20,180,400,40);
        JL_VP_06.setFont(new Font("Arial",Font.BOLD,20));
        JL_VP_06.setForeground(new Color(0x27A96F));

        JP_VP_02.add(JL_VP_02);
        JP_VP_02.add(JL_VP_03);
        JP_VP_02.add(JL_VP_04);
        JP_VP_02.add(JL_VP_05);
        JP_VP_02.add(JL_VP_06);
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JP_VP_03 = new JPanel();
        JP_VP_03.setLayout(null);
        JP_VP_03.setBackground(new Color(0x2D2D35));
        JP_VP_03.setBounds(400,150,400,250);

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        this.add(JL_VP_01);
        this.add(JP_VP_02);
        this.add(JP_VP_01);
        this.add(JP_VP_03);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JB_VP_01)
        {
            this.dispose();
            new Profile_Page(UserName_VP,Password_VP);
        }
        if (e.getSource() == JB_VP_02)
        {
            this.dispose();
            new Calculation_Page(UserName_VP,Password_VP);
        }
        if (e.getSource() == JB_VP_03)
        {
            JOptionPane.showMessageDialog(null,"This Feature Will be available in Next Update","TaxMate",JOptionPane.INFORMATION_MESSAGE);
        }
    }

}