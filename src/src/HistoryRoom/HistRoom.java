package HistoryRoom;

import ImagePanel.ImageKnights;
import HistoryRoom.Knight;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julia on 18.12.2015.
 */
public class HistRoom {
    private JList knightsJList;
    private JPanel mailPanel;
    private ImageKnights imageKnights1;
    private DefaultListModel model;
    private List<Knight> knightList;

    void setListToFile(Knight kn) {
        try {
            OutputStream outputStream;
            outputStream = new FileOutputStream("History.txt");
            OutputStreamWriter out = new OutputStreamWriter(outputStream);
            PrintWriter writer = new PrintWriter(out);
            writer.print(""+kn.getHelm()+kn.getUpp()+kn.getLow()+kn.getBoot()+kn.getHorse()+kn.getWeap());
            writer.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    void getListFromFile() {
        try {

            InputStream inputStream;
            inputStream = new FileInputStream("History.txt");
            InputStreamReader in = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(in);
            String str;
            // helm|upp|low|boot|horse|weap
            int cnt=0;
            while((str=reader.readLine()) != null) {
                int helm=Integer.parseInt(str.charAt(0)+"");
                int upp=Integer.parseInt(str.charAt(1)+"");
                int low=Integer.parseInt(str.charAt(2)+"");
                int boot=Integer.parseInt(str.charAt(3)+"");
                int horse=Integer.parseInt(str.charAt(4)+"");
                int weap=Integer.parseInt(str.charAt(5)+"");


                Knight kn = new Knight(helm,upp,low,boot,horse,weap);
                knightList.add(kn);
                model.addElement(cnt);
                cnt++;
            }
            in.close();
        }
        catch(FileNotFoundException fne) {
            fne.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public HistRoom() {
       // mailPanel=new JPanel();
        imageKnights1=new ImageKnights("Вы сделали ЭТО");
        model=new DefaultListModel();
        knightList=new ArrayList<Knight>();
        knightsJList=new JList();
        final JFrame jf=new JFrame();
        jf.setLayout(new GridLayout(0,2));
        //jf.add(mailPanel);
        jf.add(knightsJList);
        jf.add(imageKnights1);

        //mailPanel.add(knightsJList);
        getListFromFile();
        knightsJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {
                    int index = knightsJList.getSelectedIndex();
                    Knight kn=knightList.get(index);
                    imageKnights1.knight[0].draw(kn.getHelm());
                    imageKnights1.knight[1].draw(kn.getUpp());
                    imageKnights1.knight[2].draw(kn.getLow());
                    imageKnights1.knight[5].draw(kn.getHorse());
                    imageKnights1.knight[4].draw(kn.getWeap());
                    imageKnights1.knight[3].draw(kn.getBoot());
                    imageKnights1.repaint();
                }

            }
        });
        knightsJList.setModel(model);

        //jf.add(mailPanel);
        jf.setVisible(true);
        //jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(700,700);
    }

}
