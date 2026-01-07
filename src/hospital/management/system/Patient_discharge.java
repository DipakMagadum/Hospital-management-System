package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Patient_discharge extends JFrame {

    Patient_discharge(){


        JPanel panel =new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JLabel label = new JLabel("CUSTOMER ID");
        label.setBounds(30, 80, 150, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label1 = new JLabel("CHECK-OUT");
        label1.setBounds(100, 20, 150, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 15));
        label1.setForeground(Color.white);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);


        try{

            conn c = new conn();
            ResultSet resultSet =c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){

                choice.add(resultSet.getString("Number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel label2 = new JLabel("ROOM NUMBER");
        label2.setBounds(30, 130, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setForeground(Color.white);
        panel.add(label2);

        JLabel Rno = new JLabel();
        Rno.setBounds(200, 130, 150, 20);
        Rno.setFont(new Font("Tahoma", Font.BOLD, 15));
        Rno.setForeground(Color.white);
        panel.add(Rno);

        JLabel label3 = new JLabel("IN-TIME");
        label3.setBounds(30, 180, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel INTime = new JLabel();
        INTime.setBounds(200, 180, 280, 20);
        INTime.setFont(new Font("Tahoma", Font.BOLD, 15));
        INTime.setForeground(Color.white);
        panel.add(INTime);


        JLabel label4 = new JLabel("OUT-TIME");
        label4.setBounds(30, 230, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        label4.setForeground(Color.white);
        panel.add(label4);

        Date date =new Date();

        JLabel OUTTime = new JLabel(""+date);
        OUTTime.setBounds(200, 230, 280, 20);
        OUTTime.setFont(new Font("Tahoma", Font.BOLD, 15));
        OUTTime.setForeground(Color.white);
        panel.add(OUTTime);

        JButton Discharge = new JButton("Discharge");
        Discharge.setBounds(30,300,120,30);
        Discharge.setBackground(Color.BLACK);
        Discharge .setForeground(Color.WHITE);
        panel.add(Discharge);
        Discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c =new conn();
                try {
                    c.statement.executeUpdate("delete from patient_info where Number ='"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update Room set  Available= ' Yes' where Room_Number='"+Rno.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);

                } catch (SQLException E) {

                    E.printStackTrace();

                }
            }
        });


        JButton check= new JButton("Check");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.BLACK);
        check .setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                conn c =new conn();
                try{
                    ResultSet resultSet =c.statement.executeQuery("select * from patient_info where Number ='"+choice.getSelectedItem()+"'");
                    while (resultSet.next()){
                        Rno.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));

                        choice.add(resultSet.getString("Number"));
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }

            }
        });

        JButton back= new JButton("Back");
        back.setBounds(300,300,120,30);
        back.setBackground(Color.BLACK);
        back .setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);

    }

    public static void main(String[] args) {

         new Patient_discharge ();

    }
}
