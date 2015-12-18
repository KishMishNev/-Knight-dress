import HistoryRoom.HistRoom;
import ImagePanel.ImageKnights;
import Proxy.ProxyObj;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.InputEvent;
import java.io.*;
import java.util.Random;

/**
 * Created by KishMish on 15.12.2015.
 */
public class Main {
    static int g;
    static ImageKnights solution = new ImageKnights("Ваш рыцарь");
    static ImageKnights problem = new ImageKnights("Задание");

    public static void main(String args[]) {


        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(4, 0));
        String[] items = {
                "Шлем",
                "Верх доспеха",
                "Штаны",
                "Ботинки",
                "Оружие",
                "Конь"
        };
        final JComboBox comboBox = new JComboBox(items);
        buttons.add(comboBox);
        final JButton[] jButtons = new JButton[3];
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = comboBox.getSelectedIndex();
                String path = "images/";
                g=id;
                switch (id) {
                    case 0:
                        path+="helm/";
                        break;
                    case 1:
                        path+="upp/";
                        break;
                    case 2:
                        path+="low/";
                        break;
                    case 3:
                        path+="boot/";
                        break;
                    case 4:
                        path+="weap/";
                        break;
                    case 5:
                        path+="horse/";
                        break;
                }
                for(int i=0; i<3; i++) {
                    Image img = new ImageIcon(path + (i + 1) + ".png").getImage() ;
                    Image newimg = img.getScaledInstance( jButtons[i].getWidth(), jButtons[i].getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;
                    ImageIcon icon = new ImageIcon( newimg );
                    jButtons[i].setIcon(icon);
                }
            }
        });
        jButtons[0] = new JButton();
        jButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solution.knight[g].draw(1);
                solution.repaint();
            }
        });
        jButtons[1] = new JButton();
        jButtons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solution.knight[g].draw(2);
                solution.repaint();
            }
        });
        jButtons[2] = new JButton();
        jButtons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solution.knight[g].draw(3);
                solution.repaint();
            }
        });
        for(int g=0; g<3; g++) {

            buttons.add(jButtons[g]);
        }
        final JFrame jf = new JFrame("Knight Dress");
        jf.setLayout(new GridLayout(0,3));


        jf.add(problem);
        jf.add(solution);
        jf.add(buttons);
        jf.setVisible(true);
        jf.setSize(1000, 700);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1 && e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    System.out.println(e.getX());
                    if (e.getX()<jf.getWidth()/3) newProblem(); else compare();
                }
                if(e.getClickCount() == 2 && e.getModifiers() == InputEvent.BUTTON3_MASK) {
                    HistRoom histRoom = new HistRoom();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        jf.addMouseListener(mouseListener);
    }

    private static void newProblem() {
        Random random = new Random();
        for(int i=0; i<4; i++) {
            problem.knight[i].draw(Math.abs(random.nextInt())%3+1);
            System.out.println(problem.knight[i].getNumberImage());
        }
        for(int i=4; i<6; i++) {
            problem.knight[i].draw(Math.abs(random.nextInt())%4);
            System.out.println(problem.knight[i].getNumberImage());
        }
        problem.repaint();
    }

    private static void compare() {
        boolean flag=true;
        for(int i=0; i<6; i++)
            if (problem.knight[i].getNumberImage()!=solution.knight[i].getNumberImage()) {
                JOptionPane.showMessageDialog(null, "Неправильно");
                flag=false;
            }

        if (flag) {
            JOptionPane.showMessageDialog(null, "Правильно");
            try {
                FileWriter out = new FileWriter("History.txt", true);

                out.append("" + problem.knight[0].getNumberImage() + problem.knight[1].getNumberImage()
                        + problem.knight[2].getNumberImage() + problem.knight[3].getNumberImage()
                        + problem.knight[5].getNumberImage() + problem.knight[4].getNumberImage()+"\n");
                out.close();
            }
            catch(FileNotFoundException e) {
                e.printStackTrace();
            }
            catch(java.io.IOException e1) {
                e1.printStackTrace();
            }
        }
        newProblem();
        for(int i=0; i<6; i++) {
            solution.knight[i].draw(0);
        }
        solution.repaint();
    }
}
