public class StockInfo {
    double high;
    double low;
    double open;
    double current;
    double volume;

    String Name;

    public StockInfo(double high, double low, double open, double current, double volume, String Name) {
        this.high = high;
        this.low = low;
        this.open = open;
        this.current = current;
        this.volume = volume;
        this.Name =Name;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public double getCurrent() {
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
