import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

class ATM
{
    JFrame loginframe;
    JButton submitbutton,depositbutton,yesbutton,balancebutton,okbutton,withdrawbutton,yeswithdrawbutton,passwordbutton,changebutton;
    JLabel welcome,details,userIDlabel,passwordlabel,depositprompt,depositprompt2,withdrawprompt,passwordprompt;
    JTextField usertext;
    JTextField depositamountText=new JTextField();
    JTextField withdrawamountText=new JTextField();
    JPasswordField passwordtext=new JPasswordField();
    JPasswordField passwordchangetext=new JPasswordField();
    JPanel depositpanel=new JPanel();
    JPanel balancepanel=new JPanel();
    JPanel withdrawpanel=new JPanel();
    JPanel passwordpanel=new JPanel();
    public JLabel welcome()
    {
        welcome = new JLabel("Welcome to ATM services");
        welcome.setForeground(new Color(0xEDEDF3));
        welcome.setFont(new Font("serif", Font.BOLD, 36));
        welcome.setBounds(550, 50, 500, 150);
        return welcome;
    }
    public JLabel details()
    {
        details = new JLabel("Dear Customer, Please Enter Your Account.no And PASSWORD Below");
        details.setFont(new Font("serif", Font.BOLD, 20));
        details.setForeground(new Color(0xECECF1));
        details.setBounds(450, 250, 650, 150);
        return details;
    }
    public JLabel userIDlabel()
    {
        userIDlabel = new JLabel("Card.No");
        userIDlabel.setForeground(new Color(0xF1F1F6));
        userIDlabel.setBounds(520, 300, 200, 150);
        userIDlabel.setFont(new Font("serif", Font.BOLD, 25));
        return userIDlabel;
    }
    public JTextField usertext()
    {
        usertext =new JTextField();
        usertext.setForeground(new Color(0xF3F3F6));
        usertext.setBackground(new Color(0x030354));
        usertext.setFont(new Font("serif", Font.BOLD, 25));
        usertext.setBounds(650, 360, 200, 30);
        return usertext;
    }

    public JLabel passwordlabel()
    {
        passwordlabel = new JLabel("PASSWORD");
        passwordlabel.setBounds(500, 350, 200, 150);
        passwordlabel.setForeground(new Color(0xF9F9FC));
        passwordlabel.setFont(new Font("serif", Font.BOLD, 25));
        return passwordlabel;
    }
    public JPasswordField passwordtext()
    {
        passwordtext.setBackground(new Color(0x030354));
        passwordtext.setFont(new Font("serif", Font.BOLD, 25));
        passwordtext.setBounds(650, 412, 200, 30);
        return passwordtext;
    }
    public JButton submitbutton()
    {
        submitbutton = new JButton("LOGIN");
        submitbutton.setBounds(650, 450, 200, 30);
        submitbutton.setFocusable(false);
        submitbutton.setForeground(new Color(0x4D0372));
        submitbutton.setBackground(new Color(0x08E7C5));
        submitbutton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                super.mouseMoved(e);
                submitbutton.setBackground(new Color(0xFFFCF70B, true));
            }

            public void mouseExited(MouseEvent e)
            {
                super.mouseMoved(e);
                submitbutton.setBackground(new Color(0x08E7C5));
            }
        });
        submitbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                handlelogin();
            }
        });
        return submitbutton;
    }
    public void handlelogin()
    {
        Connection con=null;
        int user = Integer.parseInt(usertext.getText());
        String password = new String(passwordtext.getPassword());
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm1", "root", "jagat6370");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Account_no, password FROM Account WHERE Account_no = " + user);

            if((rs.next() && rs.getString("password").equals(password)))
            {
                JOptionPane.showMessageDialog(null,"Login Successful");
                loginframe.dispose();
                transactionf();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Failed");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public JPanel prompt()
    {
        JLabel prompt1=new JLabel("Dear Customer, Please Select Transaction");
        prompt1.setFont(new Font("serif",Font.BOLD,36));
        JPanel panel=new JPanel();
        panel.setBackground(new Color(0x08E7E7));
        panel.setBounds(0,100,1535,50);
        panel.add(prompt1);
        return panel;
    }
    //Deposit button
    public JButton depositbutton()
    {
        depositbutton=new JButton("Deposit");
        depositbutton.setFocusable(false);
        depositbutton.setBounds(0,500,200,50);
        depositbutton.setForeground(new Color(0x4D0372));
        depositbutton.setBackground(new Color(0x08E7C5));
        int clicked;
        depositpanel.setVisible(false);
        depositbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                depositpanel.setVisible(true);
                depositpanel();
            }
        });
        depositbutton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                super.mouseMoved(e);
                depositbutton.setBackground(new Color(0xFFFCF70B, true));
            }
            public void mouseExited(MouseEvent e)
            {
                super.mouseMoved(e);
                depositbutton.setBackground(new Color(0x08E7C5));
            }
        });
        return depositbutton;
    }
    public JLabel depositprompt()
    {
        depositprompt=new JLabel("Enter The Amount To Be Deposited And Click Yes");
        depositprompt.setFont(new Font("serif",Font.HANGING_BASELINE,20));
        depositprompt.setBounds(300,50,505,50);
        depositprompt.setForeground(new Color(0x090404));
        return depositprompt;
    }
    public JLabel depositprompt2()
    {
        depositprompt2=new JLabel("Enter The Amount Here :-");
        depositprompt2.setFont(new Font("serif",Font.BOLD,20));
        depositprompt2.setBounds(300,150,505,50);
        depositprompt2.setForeground(new Color(0x090404));
        return depositprompt2;
    }
    public JTextField depositamountText()
    {
        depositamountText.setBounds(530,150,200,50);
        depositamountText.setFont(new Font("serif",Font.BOLD,25));
        depositamountText.setText("");
        return depositamountText;
    }
    public void DepositAmount() {
        int userdeposit = Integer.parseInt(usertext.getText());
        try {
            int Amount ;
            Amount= Integer.parseInt(depositamountText.getText());
            int cash=Amount%100;
            if (Amount <= 20000 && Amount > 0)
            {
                if(cash==0)
                {
                    Connection con = null;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm1", "root", "jagat6370");
                        String updateQuery = "UPDATE Account SET Amount=Amount+? WHERE Account_no="+userdeposit;
                        PreparedStatement pstmt = con.prepareStatement(updateQuery);
                        pstmt.setInt(1, Amount);
                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Deposited Successfully ");
                        JOptionPane.showMessageDialog(null,"Transaction Completed");
                    }
                    catch (Exception c)
                    {
                        c.printStackTrace();
                    }
                    finally
                    {
                        if (con != null)
                        {
                            try
                            {
                                con.close();
                            }
                            catch (SQLException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Enter Valid Amount");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please Enter a valid Amount under 20,000 and greater than 0");
            }
        }
        catch (NumberFormatException e)
        {
            // Handle the case where the input cannot be converted to an integer
            JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");
        }
    }

    public JButton yesbutton()
    {
        yesbutton=new JButton("YES");
        yesbutton.setBounds(900,400,80,40);
        yesbutton.setFocusable(false);
        yesbutton.setForeground(new Color(0xF3F3F6));
        yesbutton.setBackground(new Color(0x260338));
        yesbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                DepositAmount();
                depositpanel.setVisible(false);
            }
        });
        return yesbutton;
    }
    public JPanel depositpanel()
    {
        depositpanel.setBackground(new Color(0x08E7E7));
        depositpanel.setBounds(300,200,1000,500);
        depositpanel.setLayout(null);
        depositpanel.add(depositprompt());
        depositpanel.add(depositprompt2());
        depositpanel.add(depositamountText());
        depositpanel.add(yesbutton());
        return  depositpanel;
    }
    //Main balance
    public JButton balancebutton()
    {
        balancebutton=new JButton("Main Balance");
        balancebutton.setFocusable(false);
        balancebutton.setBounds(1350,400,200,50);
        balancebutton.setForeground(new Color(0x4D0372));
        balancebutton.setBackground(new Color(0x08E7C5));
        balancepanel.setVisible(false);
        balancebutton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                super.mouseMoved(e);
                balancebutton.setBackground(new Color(0xFFFCF70B, true));
            }
            public void mouseExited(MouseEvent e)
            {
                super.mouseMoved(e);
                balancebutton.setBackground(new Color(0x08E7C5));
            }
        });
        balancebutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                balancepanel.setVisible(true);
                balancepanel();
                BalanceDisplay();
            }
        });
        return balancebutton;
    }
    public JButton okbutton()
    {
        okbutton=new JButton("OK");
        okbutton.setBounds(900,400,80,40);
        okbutton.setFocusable(false);
        okbutton.setForeground(new Color(0xF3F3F6));
        okbutton.setBackground(new Color(0x260338));
        okbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                balancepanel.setVisible(false);
            }
        });
        return okbutton;
    }
    public JPanel balancepanel()
    {
        balancepanel.setBackground(new Color(0x00FFFF));
        balancepanel.setBounds(300,200,1000,500);
        return balancepanel;
    }
    public void BalanceDisplay()
    {int userbalance = Integer.parseInt(usertext.getText());
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm1", "root", "jagat6370");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select Amount from Account where Account_no="+userbalance);
            if(rs.next())
            {
                String amt=rs.getString(1);
                JLabel message=new JLabel("Your Available Balance Is :- ₹");
                message.setFont(new Font("Serif",Font.BOLD,30));
                message.setBounds(50,100,400,100);
                JLabel AMT=new JLabel();
                AMT.setFont(new Font("Serif",Font.BOLD,25));
                AMT.setBounds(450,100,100,100);
                AMT.setText(amt);
                balancepanel.add(message);
                balancepanel.add(AMT);
                balancepanel.add(okbutton());
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    //withdraw
    public JButton withdrawbutton()
    {
        withdrawbutton=new JButton("Withdraw");
        withdrawbutton.setFocusable(false);
        withdrawbutton.setBounds(0,400,200,50);
        withdrawbutton.setForeground(new Color(0x4D0372));
        withdrawbutton.setBackground(new Color(0x08E7C5));
        withdrawpanel.setVisible(false);
        withdrawbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                withdrawpanel.setVisible(true);
            }
        });
        withdrawbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                withdrawbutton.setBackground(new Color(0xFFFCF70B, true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                withdrawbutton.setBackground(new Color(0x08E7C5));
            }
        });
        return withdrawbutton;
    }
    public JLabel withdrawprompt()
    {
        withdrawprompt=new JLabel("Please Enter Amount.(Cash Available:RS 100,RS 500,RS 2000,RS 200)");
        withdrawprompt.setFont(new Font("serif",Font.HANGING_BASELINE,20));
        withdrawprompt.setBounds(300,50,600,50);
        withdrawprompt.setForeground(new Color(0x090404));
        return withdrawprompt;
    }
    public JTextField withdrawamountText()
    {
        withdrawamountText.setBounds(530,150,200,50);
        withdrawamountText.setFont(new Font("serif",Font.BOLD,25));
        withdrawamountText.setText("");
        return withdrawamountText;
    }
    public JButton yeswithdrawbutton()
    {
        yeswithdrawbutton=new JButton("YES");
        yeswithdrawbutton.setBounds(900,400,80,40);
        yeswithdrawbutton.setFocusable(false);
        yeswithdrawbutton.setForeground(new Color(0xF3F3F6));
        yeswithdrawbutton.setBackground(new Color(0x260338));
        yeswithdrawbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                WithdrawAmount();
                withdrawpanel.setVisible(false);
            }
        });
        return yeswithdrawbutton;
    }
    public JPanel withdrawpanel()
    {
        withdrawpanel.setBackground(new Color(0x08E7E7));
        withdrawpanel.setBounds(300,200,1000,500);
        withdrawpanel.setLayout(null);
        withdrawpanel.add(withdrawprompt());
        withdrawpanel.add(withdrawamountText());
        withdrawpanel.add(yeswithdrawbutton());
        return  withdrawpanel;
    }
    public void WithdrawAmount() {
        int userwithdraw = Integer.parseInt(usertext.getText());
        try {
            int Amount ;
            Amount= Integer.parseInt(withdrawamountText.getText());
            int cash=Amount%100;
            if (Amount <= 20000 && Amount > 0)
            {
                if(cash==0)
                {
                    Connection con = null;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm1", "root", "jagat6370");
                        String updateQuery = "UPDATE Account SET Amount=Amount-? WHERE Account_no="+userwithdraw;
                        PreparedStatement pstmt = con.prepareStatement(updateQuery);
                        pstmt.setInt(1, Amount);
                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Please Collect Your Cash");
                        JOptionPane.showMessageDialog(null,"Transaction Completed");
                    }
                    catch (Exception c)
                    {
                        c.printStackTrace();
                    }
                    finally
                    {
                        if (con != null)
                        {
                            try
                            {
                                con.close();
                            }
                            catch (SQLException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Enter Valid Amount");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please Enter a valid Amount under 10,000 and greater than 0");
            }
        }
        catch (NumberFormatException e)
        {
            // Handle the case where the input cannot be converted to an integer
            JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");
        }
    }
    //password change
    public JButton passwordbutton()
    {
        passwordbutton=new JButton("PIN change");
        passwordbutton.setFocusable(false);
        passwordbutton.setBounds(1350,500,200,50);
        passwordbutton.setForeground(new Color(0x4D0372));
        passwordbutton.setBackground(new Color(0x08E7C5));
        passwordpanel.setVisible(false);
        passwordbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                passwordpanel.setVisible(true);
                passwordpanel();
            }
        });
        passwordbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                passwordbutton.setBackground(new Color(0xFFFCF70B, true));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                passwordbutton.setBackground(new Color(0x08E7C5));
            }
        });
        return passwordbutton;
    }
    public JLabel passwordprompt()
    {
        passwordprompt=new JLabel("Enter New Password");
        passwordprompt.setFont(new Font("serif",Font.HANGING_BASELINE,20));
        passwordprompt.setBounds(100,50,600,50);
        passwordprompt.setForeground(new Color(0x090404));
        return passwordprompt;
    }
    public JPasswordField passwordchangetext()
    {
        passwordchangetext.setBounds(100,100,200,50);
        passwordchangetext.setFont(new Font("serif",Font.BOLD,25));
        passwordchangetext.setText("");
        return passwordchangetext;
    }
    public JButton changebutton()
    {
        changebutton=new JButton("Change");
        changebutton.setBounds(900,400,80,40);
        changebutton.setFocusable(false);
        changebutton.setForeground(new Color(0xF3F3F6));
        changebutton.setBackground(new Color(0x260338));
        changebutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                passwordChange();
                passwordpanel.setVisible(false);
            }
        });
        return changebutton;
    }
    public JPanel passwordpanel()
    {
        passwordpanel.setBackground(new Color(0x08E7E7));
        passwordpanel.setBounds(300,200,1000,500);
        passwordpanel.setLayout(null);
        passwordpanel.add(passwordprompt());
        passwordpanel.add(passwordchangetext());
        passwordpanel.add(changebutton());
        return  passwordpanel;
    }
    public void passwordChange() {
        int userWithdraw = Integer.parseInt(usertext.getText());
        try {
            int newPassword;
            newPassword = Integer.parseInt(passwordchangetext.getText());
            Connection con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm1", "root", "jagat6370");
                String updateQuery = "UPDATE Account SET password=? WHERE Account_no=?";
                PreparedStatement pstmt = con.prepareStatement(updateQuery);
                pstmt.setInt(1, newPassword);
                pstmt.setInt(2, userWithdraw);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Password Changed Successfully");
            }
            catch (Exception c)
            {
                c.printStackTrace();
            }
            finally
            {
                if (con != null)
                {
                    try
                    {
                        con.close();
                    } catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please Enter a Valid Digit");
        }
    }

    public void transactionf()
    {
        JFrame transactionframe=new JFrame("Automated Teller Machine");
        transactionframe.add(prompt());
        transactionframe.add(depositbutton());
        transactionframe.add(depositpanel());
        transactionframe.add(balancebutton());
        transactionframe.add(balancepanel());
        transactionframe.add(withdrawbutton());
        transactionframe.add(withdrawpanel());
        transactionframe.add(passwordbutton());
        transactionframe.add(passwordpanel());
        transactionframe.getContentPane().setBackground(new Color(0x030354));
        transactionframe.setSize(500, 500);
        transactionframe.setLocationRelativeTo(null);
        transactionframe.setLayout(null);
        transactionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        transactionframe.setVisible(true);
        transactionframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public void loginFrame()
    {
        loginframe=new JFrame("Login");
        loginframe.add(welcome());
        loginframe.add(details());
        loginframe.add(userIDlabel());
        loginframe.add(usertext());
        loginframe.add(passwordlabel());
        loginframe.add(passwordtext());
        loginframe.add(submitbutton());
        loginframe.getContentPane().setBackground(new Color(0x030354));
        loginframe.setSize(500, 500);
        loginframe.setLocationRelativeTo(null);
        loginframe.setLayout(null);
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginframe.setVisible(true);
        loginframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public static void main(String args[])
    {
        ATM ob=new ATM();
        ob.loginFrame();
    }
}