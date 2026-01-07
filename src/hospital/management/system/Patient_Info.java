package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Patient_Info extends JFrame {

    Patient_Info(){

        JPanel panel =new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(table);

        try{

            conn c = new conn();
            String q= "select * from patient_info";
            ResultSet resultSet =c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel label1 = new JLabel("ID");
        label1.setBounds(15, 9, 100, 20);
        panel.add(label1);

        JLabel label2 = new JLabel("NUMBER");
        label2.setBounds(120, 9, 100, 20);
        panel.add(label2);

        JLabel label3 = new JLabel("NAME");
        label3.setBounds(230, 9, 100, 20);
        panel.add(label3);

        JLabel label4 = new JLabel("GENDER");
        label4.setBounds(340, 9, 100, 20);
        panel.add(label4);

        JLabel label5 = new JLabel("DISEASE");
        label5.setBounds(430, 9, 100, 20);
        panel.add(label5);

        JLabel label6 = new JLabel("ROOM_NO");
        label6.setBounds(530, 9, 100, 20);
        panel.add(label6);

        JLabel label7 = new JLabel("TIME");
        label7.setBounds(640, 9, 100, 20);
        panel.add(label7);

        JLabel label8 = new JLabel("DEPOSITE");
        label8.setBounds(730, 9, 100, 20);
        panel.add(label8);

        JLabel label9 = new JLabel("PID");
        label9.setBounds(820, 9, 100, 20);
        panel.add(label9);


        JButton b1 = new JButton("BACK");
        b1.setBounds(380, 510, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });
        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);

    }

    public static void main(String[] args) {

        new Patient_Info();

    }
}
