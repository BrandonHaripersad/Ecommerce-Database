import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.Flow;

public class Example {

    public static void main(String[] args) {
        JFrame jf = new JFrame();

        JButton btn1 = new JButton("Select all products that are Headphones and ordery them by LIKE");
        btn1.setSize(500, 20);
        jf.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame inner = new JFrame();
                inner.setSize(500, 500);

                try {
                    Process p = Runtime.getRuntime().exec("wsl echo \"select * from product where productname like 'Wireless%' order by productprice asc;\" | sqlplus.exe taimoor/taimoor");

                    StringBuilder buf = new StringBuilder("<html>");
                    String line;

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(p.getInputStream()) );
                    while ((line = in.readLine()) != null) {
                        //System.out.println(line);
                        buf.append(line).append("<br>");
                    }
                    in.close();

                    buf.append("</html>");

                    System.out.println(buf.toString());

                    JLabel jl = new JLabel(buf.toString());
                    inner.add(jl);
                    inner.pack();
                    inner.validate();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                inner.setLayout(new FlowLayout());
                inner.setVisible(true);
            }
        });

        JButton btn2 = new JButton("Select all users who have placed an order by EXISTS");
        btn2.setSize(500, 20);
        jf.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame inner = new JFrame();
                inner.setSize(500, 1000);

                try {
                    Process p = Runtime.getRuntime().exec("wsl echo \"select ecusername from buyer where exists (select * from checkout where buyer.ecusername = checkout.customer);\" | sqlplus.exe taimoor/taimoor");

                    StringBuilder buf = new StringBuilder("<html>");
                    String line;

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(p.getInputStream()) );
                    while ((line = in.readLine()) != null) {
                        //System.out.println(line);
                        buf.append(line).append("<br>");
                    }
                    in.close();

                    buf.append("</html>");


                    JLabel jl = new JLabel(buf.toString());
                    inner.add(jl);
                    inner.pack();
                    inner.validate();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                inner.setLayout(new FlowLayout());
                inner.setVisible(true);
            }
        });


        JButton btn3 = new JButton("Get avg price of products from BrandonMart by AGGREGATE");
        btn3.setSize(500, 20);
        jf.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame inner = new JFrame();
                inner.setSize(500, 1000);

                try {
                    Process p = Runtime.getRuntime().exec("wsl echo \"select avg(productprice) from product where ofstore = 'BrandonMart';\" | sqlplus.exe taimoor/taimoor");

                    StringBuilder buf = new StringBuilder("<html>");
                    String line;

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(p.getInputStream()) );
                    while ((line = in.readLine()) != null) {
                        //System.out.println(line);
                        buf.append(line).append("<br>");
                    }
                    in.close();

                    buf.append("</html>");

                    JLabel jl = new JLabel(buf.toString());
                    inner.add(jl);
                    inner.pack();
                    inner.validate();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                inner.setLayout(new FlowLayout());
                inner.setVisible(true);
            }
        });


        JButton btn4 = new JButton("Get all purchases of a user by JOIN");
        btn4.setSize(500, 20);
        jf.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame inner = new JFrame();
                inner.setSize(500, 1000);

                try {
                    Process p = Runtime.getRuntime().exec("wsl echo \"select ecusername, purchaseitem from buyer, checkout where buyer.ecusername = checkout.customer and purchaseitem = checkout.purchaseitem;\" | sqlplus.exe taimoor/taimoor");

                    StringBuilder buf = new StringBuilder("<html>");
                    String line;

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(p.getInputStream()) );
                    while ((line = in.readLine()) != null) {
                        //System.out.println(line);
                        buf.append(line).append("<br>");
                    }
                    in.close();

                    buf.append("</html>");

                    JLabel jl = new JLabel(buf.toString());
                    inner.add(jl);
                    inner.pack();
                    inner.validate();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                inner.setLayout(new FlowLayout());
                inner.setVisible(true);
            }
        });


        JButton btn5 = new JButton("Get all products from a store excluding Headphones by MINUS");
        btn5.setSize(500, 20);
        jf.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame inner = new JFrame();
                inner.setSize(500, 1000);

                try {
                    Process p = Runtime.getRuntime().exec("wsl echo \"select * from product where ofstore = 'BrandonMart' minus (select * from product where productname = 'Headphones');\" | sqlplus.exe taimoor/taimoor");

                    StringBuilder buf = new StringBuilder("<html>");
                    String line;

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(p.getInputStream()) );
                    while ((line = in.readLine()) != null) {
                        //System.out.println(line);
                        buf.append(line).append("<br>");
                    }
                    in.close();

                    buf.append("</html>");

                    JLabel jl = new JLabel(buf.toString());
                    inner.add(jl);
                    inner.pack();
                    inner.validate();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                inner.setLayout(new FlowLayout());
                inner.setVisible(true);
            }
        });


        jf.setSize(500, 500);
        jf.setLayout(new FlowLayout());
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
