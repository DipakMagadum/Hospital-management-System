package hospital.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.net.URL;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    Login() {
        setSize(750, 500);
        setLocation(400, 200);
        setLayout(null);
        getContentPane().setBackground(new Color(108, 180, 232));


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image image = imageIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(285, 20, 180, 180);
        add(label);


        JLabel namLabel = new JLabel("Username");
        namLabel.setBounds(180, 220, 100, 30);
        namLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        namLabel.setForeground(Color.BLACK);
        add(namLabel);

        textField = new JTextField();
        textField.setBounds(290, 220, 200, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(255, 179, 0));
        add(textField);

        JLabel password = new JLabel("Password");
        password.setBounds(180, 270, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 18));
        password.setForeground(Color.BLACK);
        add(password);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(290, 270, 200, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(255, 179, 0));
        add(jPasswordField);

        b1 = new JButton("Login");
        b1.setBounds(250, 330, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(370, 330, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String user = textField.getText();
                String pass = jPasswordField.getText();
                String q = "select * from login where ID='" + user + "' and pw='" + pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.exit(10);
        }
    }
}
