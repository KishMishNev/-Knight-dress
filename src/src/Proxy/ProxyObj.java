package Proxy;

/**
 * Created by Julia on 15.12.2015.
 */
public class ProxyObj {
    private RealObj realObj;
    private int width;
    private int height;
    private int currentX;
    private int currentY;
    private String type;

    public ProxyObj(int w, int h, int cx, int cy, String str) {
        width=w;
        height=h;
        currentX=cx;
        currentY=cy;
        type=str;
    }
    public String getType() {
        return type;
    }
    public void draw(int ind) {

        if(realObj == null) {
            realObj=new RealObj(ind);
        }
        if (ind==0) realObj = null;
        if (ind!=0) realObj.draw(ind);

    }
    public int getNumberImage() {
        if(realObj == null) {
            return -1;
        }
        return realObj.getNumber();
    }
    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
