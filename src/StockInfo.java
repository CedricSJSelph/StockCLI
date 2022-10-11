import java.util.*;

public class StockInfo {
    float high;
    float low;
    float open;
    float current;
    double volume;

    String Name;

    public StockInfo(float high, float low, float open, float current, double volume, String Name) {
        this.high = high;
        this.low = low;
        this.open = open;
        this.current = current;
        this.volume = volume;
        this.Name =Name;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getCurrent() {
        return current;
    }

    public void setCurrent(float current) {
        this.current = current;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
