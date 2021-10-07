import java.time.LocalDate;
import java.time.LocalTime;

abstract public class Trade {
    public String id;
    public String symbol;
    public int quantity;
    public double price;
    public LocalDate date;
    public LocalTime time;

    public Trade(String id, String symbol, int quantity) {
        this.id = id;
        this.symbol = symbol;
        this.quantity = quantity;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public Trade(String id, String symbol, int quantity, double price) {
        this(id, symbol, quantity);
        this.price = price;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
    }

    public double getPrice() {
        return price;
    }

    abstract public void calcDividend();

    @Override
    public String toString() {
        return "Trade{\n" +
                "\tid='" + id + "\',\n" +
                "\tsymbol='" + symbol + "\',\n" +
                "\tquantity=" + quantity + ",\n" +
                "\tprice=" + price + ",\n" +
                '}';
    }
}
