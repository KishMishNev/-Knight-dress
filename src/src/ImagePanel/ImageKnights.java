package ImagePanel;

import Proxy.ProxyObj;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Julia on 15.12.2015.
 */
public class ImageKnights extends JPanel {
    public ProxyObj[] knight = new ProxyObj[6];
    ProxyObj objs1[];
    String name;

    public void dr(Graphics g,Graphics2D g2, ProxyObj prox) {
        //System.out.println("images/"+prox.getType()+"/" + prox.getNumberImage() + ".png");
        if(prox.getNumberImage() != -1) {
            try {
                BufferedImage imageObj = ImageIO.read(new File("images/"+prox.getType()+"/" + prox.getNumberImage() + ".png"));
                g.drawImage(imageObj, prox.getCurrentX(), prox.getCurrentY(), prox.getWidth() + 1, prox.getHeight() + 1, null);
            } catch (IOException e) {

            }
        }
        else {
            g2.setColor(Color.YELLOW);
            Rectangle fhelm = new Rectangle(prox.getCurrentX(), prox.getCurrentY(), prox.getWidth(), prox.getHeight());
            g2.draw(fhelm);
            g2.fill(fhelm);
        }
    }

    public ImageKnights(String newName) {
        super();
        this.name=newName;
        System.out.println("Created ImageKnights");
        // W H curX curY
        knight[0]=new ProxyObj(70,70,150,120,"helm");
        knight[1]=new ProxyObj(80,100,145,195,"upp");
        knight[2]=new ProxyObj(80,90,145,300,"low");
        knight[3]=new ProxyObj(80,80,145,395,"boot");
        knight[5]=new ProxyObj(100,80,230,250,"horse");
        knight[4]=new ProxyObj(60,160,80,160,"weap");
    }
    @Override
    public void repaint() {
        //System.out.println("REPAINT INVOKED!");
        super.repaint();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        Font font = new Font("Times New Roman", 2, 20);
        g2.setColor(Color.darkGray);
        g2.setFont(font);
        g2.drawString(name, 50, 50);
        for(int i=0; i<6; i++) {
            dr(g,g2,knight[i]);
        }
    }

}
