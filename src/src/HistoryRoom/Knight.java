package HistoryRoom;

/**
 * Created by KishMish on 15.12.2015.
 */
public class Knight {
    int helm;
    int upp;
    int low;
    int boot;
    int horse;
    int weap;

    public Knight(int helm, int upp, int low, int boot, int horse, int weap) {
        this.helm=helm;
        this.upp=upp;
        this.low=low;
        this.boot=boot;
        this.horse=horse;
        this.weap=weap;
    }

    public int getHelm() {
        return helm;
    }

    public void setHelm(int helm) {
        this.helm = helm;
    }

    public int getUpp() {
        return upp;
    }

    public void setUpp(int upp) {
        this.upp = upp;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getBoot() {
        return boot;
    }

    public void setBoot(int boot) {
        this.boot = boot;
    }

    public int getHorse() {
        return horse;
    }

    public void setHorse(int horse) {
        this.horse = horse;
    }

    public int getWeap() {
        return weap;
    }

    public void setWeap(int weap) {
        this.weap = weap;
    }
}
