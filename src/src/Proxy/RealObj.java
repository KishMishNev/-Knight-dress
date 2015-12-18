package Proxy;

/**
 * Created by Julia on 15.12.2015.
 */
public class RealObj {
    int number;
    RealObj(int i) {
        number=i;
    }
    int getNumber() {
        return number;
    }
    void draw(int ind) {
        number=ind;
    }
}
