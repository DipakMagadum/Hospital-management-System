package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {

    Employee_info() {
        // Panel cropped to white-bordered area (900x500)
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 900, 500);
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 34, 880, 400);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from EMP_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Headers aligned properly
        JLabel label1 = new JLabel("NAME");
        label1.setBounds(40, 9, 100, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("AGE");
        label2.setBounds(200, 9, 100, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Contact");
        label3.setBounds(340, 9, 100, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel label4 = new JLabel("Salary");
        label4.setBounds(520, 9, 100, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        JLabel label5 = new JLabel("Mail");
        label5.setBounds(700, 9, 100, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);

        // Back button repositioned
        JButton b1 = new JButton("BACK");
        b1.setBounds(380, 440, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900, 500); // reduced to fit content only
        setLayout(null);
        setLocation(370, 200);
        getContentPane().setBackground(new Color(109, 164, 170));
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_info();
    }
}
