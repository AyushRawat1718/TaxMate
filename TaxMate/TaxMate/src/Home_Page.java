import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

class Home_Page extends JFrame implements ActionListener
{
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Declaration of variables.
    JPanel JP_HP_01; // Panel for home page background image.
    JLabel JL_HP_01; // Label for home page background image.
    JLabel JL_HP_02; // Label for Username.
    JLabel JL_HP_03; // Label for Password.
    JLabel JL_HP_04; // Label for Text(New Here ?).
    ImageIcon II_HP_01; // Home page background image.
    JButton JB_HP_01; // Login button.
    JButton JB_HP_02; // Button for redirecting to Signup Page.
    JTextField JT_HP_01; // TextField for username.
    JTextField JT_HP_02; // TextField for password.
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Home_Page Basic Properties

    Home_Page()
    {
        this.setSize(1000,650);
        this.getContentPane().setBackground(new Color(0x202329));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("TaxMate");
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        II_HP_01 = new ImageIcon("C:\\Users\\Ayush Rawat\\Desktop\\TaxMate\\TaxMate\\Images & Logos\\Home_BackGround.png");
        JL_HP_01 = new JLabel();
        JL_HP_01.setIcon(II_HP_01);

        JP_HP_01 = new JPanel();
        JP_HP_01.setLayout(new BorderLayout());
        JP_HP_01.setBounds(30,50,530,492);
        JP_HP_01.add(JL_HP_01);
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JB_HP_01 = new JButton("LOGIN");
        JB_HP_01.setFocusable(false);
        JB_HP_01.setBackground(new Color(0x17C17C));
        JB_HP_01.setBounds(720,200,100,30);
        JB_HP_01.addActionListener(this);
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_HP_02 = new JLabel("Username ");
        JL_HP_02.setFont(new Font("Sans-serif",Font.BOLD,15));
        JL_HP_02.setForeground(new Color(0xC7BDEF));
        JL_HP_02.setBounds(600,100,100,30);

        JT_HP_01 = new JTextField();
        JT_HP_01.setPreferredSize(new Dimension(200,30));
        JT_HP_01.setForeground(new Color(0x9A9AEC));
        JT_HP_01.setBackground(new Color(0x393949));
        JT_HP_01.setCaretColor(Color.BLACK);
        JT_HP_01.setBorder(BorderFactory.createEmptyBorder());
        JT_HP_01.setText("Enter Your Username");
        JT_HP_01.setBounds(720,100,200,30);
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_HP_03 = new JLabel("Password");
        JL_HP_03.setFont(new Font("Sans-serif",Font.BOLD,15));
        JL_HP_03.setForeground(new Color(0xC7BDEF));
        JL_HP_03.setBounds(600,150,100,30);

        JT_HP_02 = new JTextField();
        JT_HP_02.setPreferredSize(new Dimension(200,30));
        JT_HP_02.setForeground(new Color(0x9A9AEC));
        JT_HP_02.setBackground(new Color(0x393949));
        JT_HP_02.setCaretColor(Color.BLACK);
        JT_HP_02.setBorder(BorderFactory.createEmptyBorder());
        JT_HP_02.setText("Enter your Password");
        JT_HP_02.setBounds(720,150,200,30);
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JL_HP_04 = new JLabel("New Here ?");
        JL_HP_04.setForeground(new Color(0x8971E8));
        JL_HP_04.setFont(new Font("Arial",Font.BOLD,45));
        JL_HP_04.setBounds(630,370,300,40);

        JB_HP_02 = new JButton("Sign Up");
        JB_HP_02.setFocusable(false);
        JB_HP_02.setBackground(new Color(0x17C17C));
        JB_HP_02.setBounds(680,430,100,30);
        JB_HP_02.addActionListener(this);

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        this.add(JL_HP_02);
        this.add(JB_HP_01);
        this.add(JB_HP_01);
        this.add(JP_HP_01);
        this.add(JT_HP_01);
        this.add(JT_HP_02);
        this.add(JL_HP_03);
        this.add(JL_HP_04);
        this.add(JB_HP_02);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == JB_HP_01)
        {
            String UserName = JT_HP_01.getText();
            String PassWord = JT_HP_02.getText();

            try{
                Class.forName("com.mysql.cj.jdbc.Driver"); // Loading the Driver.
                String url = "jdbc:mysql://localhost:3306/TaxMate_Database";
                String username = "root";
                String Password = "ayushrawat@2003123" ;
                Connection conn_obj = DriverManager.getConnection(url,username,Password);
                if (conn_obj.isClosed())
                {
                    JOptionPane.showMessageDialog(null, "Some Error Occurred!!", "TaxMate", JOptionPane.ERROR_MESSAGE);

                }
                else{
                    try
                    {
                        String query1 = String.format("SELECT * FROM User_All_Info WHERE PanNumber = '%s'",UserName);
                        Statement stmt = conn_obj.createStatement();
                        ResultSet set = stmt.executeQuery(query1);
                        String ContactNumber = null;
                        while(set.next())
                        {
                            ContactNumber = set.getString("ContactNumber");
                        }
                        if (Objects.equals(PassWord, ContactNumber))
                        {
                            new Profile_Page(UserName,PassWord);
                            this.dispose();
                        }
                    }
                    catch (Exception e1234)
                    {
                        // Here Username or password doesn't match.
                        JOptionPane.showMessageDialog(null, "Username & Password doesn't match!!", "TaxMate", JOptionPane.ERROR_MESSAGE);
                        new Home_Page();
                    }

                }



            }
            catch (Exception e123)
            {
                JOptionPane.showMessageDialog(null, "Some Error Occurred!!", "TaxMate", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (JB_HP_02 == e.getSource())
        {
            this.dispose();
            new Signup_Page();
        }

    }

    public static void main(String[] args) {
        new Home_Page();
    }
}
