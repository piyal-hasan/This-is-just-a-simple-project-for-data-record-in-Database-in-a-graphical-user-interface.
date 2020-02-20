package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import entity.*;

/**
 * Created by tasmidur on 1/21/2018.
 */
public class GetFrame
{
    private Container cont;
    private JLabel lbl1,lbl2,lbl3,imlbl;
    private Font font1,font2,font3;
    private ImageIcon im;
    private JTextField jtf1,jtf2,jtf3,jtf4,Nametf,IDtf;
    private JFrame jf1,jf2;
    private JButton jb1,jb2,jb3,jb4,Okay;

    private int counter;

    public void Testt()
    {
        jf1=new JFrame("Algoset");
        jf1.setDefaultCloseOperation(2);
        jf1.setBounds(100,100,500,400);

        lbl1=new JLabel();
        lbl1.setBounds(0,0,500,400);

        font1=new Font("Times New Roman",Font.BOLD,14);

        jb1=new JButton("Insert");
        jb1.setBounds(40,40,100,30);


        jb2=new JButton("Delete");
        jb2.setBounds(100+10+40,40,100,30);


        jb3=new JButton("Update");
        jb3.setBounds(40+100+10+100+10,40,100,30);

        jb4=new JButton("Search");
        jb4.setBounds(40+100+10+100+10+100+10,40,100,30);


        jtf1=new JTextField();
        jtf1.setBounds(40,90,200,30);
        jtf1.setVisible(true);

        jtf2=new JTextField();
        jtf2.setBounds(40,130,200,30);
        jtf2.setVisible(true);

        Okay=new JButton("Okay");
        Okay.setBounds(40,170,100,30);

        lbl1.add(jtf1);
        lbl1.add(jtf2);

        lbl1.add(Okay);

        lbl1.add(jb1);
        lbl1.add(jb2);
        lbl1.add(jb3);
        lbl1.add(jb4);

        jf1.add(lbl1);

        jf1.setVisible(true);

        counter=1;

        jb1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jtf2.setVisible(true);
                System.out.println("Inserting");
                counter=1;
                Okay.setVisible(true);
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete");
                jtf2.setVisible(false);
                counter=2;
                Okay.setVisible(true);
                counter=2;

            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Update");
                jtf2.setVisible(true);
                counter=3;
                Okay.setVisible(true);
            }
        });

        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Searching");
                jtf2.setVisible(false);
                counter=4;
            }
        });

        Okay.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(jtf1.getText().isEmpty()==true && (counter==2 || counter==3 || counter==4))
                    JOptionPane.showMessageDialog(null, "Please Give me Email");
                else if(jtf1.getText().isEmpty()==true || jtf2.getText().isEmpty()==true && counter==1)
                    JOptionPane.showMessageDialog(null,"Please Give me Email and Name");
                else {
                    boolean tt=new IsItPresent().test((String) jtf1.getText());
                    if(counter==1) {
                        System.out.println("Counter = "+counter);

                        if(tt==false) {
                            new Insert().Insertt((String) jtf1.getText(), (String) jtf2.getText());
                            JOptionPane.showMessageDialog(null, "Successfully Inserted Your Data");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Sorry This Id is present, add new Id");
                        }
                    }
                    else if(counter==2) {
                        if(tt==true) {
                            new Delete().Deletee((String) jtf1.getText());
                            JOptionPane.showMessageDialog(null, "Successfully Deleted Your Data");
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Sorry This person is not present");
                    }
                    else if(counter==3) {
                        System.out.println("Counter = "+counter);
                        if (tt == true) {
                            new Update().Updatee((String) jtf1.getText(), (String) jtf2.getText());
                            JOptionPane.showMessageDialog(null, "Successfully Updated Your Data");
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Sorry This person is not present");
                    }
                    else  if(counter==4){
                        customer c;
                        if( tt== false)
                            JOptionPane.showMessageDialog(null,"Sorry This person is not present");
                        else {
                            c = new Retrip().Retripp((String) jtf1.getText());
                            JOptionPane.showMessageDialog(null, ("Id = " + c.getId() + "\nName = " + c.getName()));
                        }
                    }
                }
            }
        });
    }
}
