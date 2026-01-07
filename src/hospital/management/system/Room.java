package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table;

    Room() {

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 700, 600);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(545, 480, 120, 120);
        panel.add(label);

        table = new JTable();
        table.setBounds(40, 120, 600, 400);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        table.setRowHeight(25);
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from Room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Room No");
        label1.setBounds(40, 95, 100, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(170, 95, 100, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(310, 95, 100, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(420, 95, 100, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(label4);

        JButton back = new JButton("BACK");
        back.setBounds(290, 540, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700, 600);
        setLayout(null);
        setLocation(350, 100);
        getContentPane().setBackground(new Color(90, 156, 163));
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
