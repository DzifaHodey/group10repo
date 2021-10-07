import java.util.ArrayList;
import java.util.Objects;

public class Account {
    private double totalTradeValue;
    private ArrayList<Trade> tradesList;

    //    using an initialization block only because I can
    {
        this.tradesList = new ArrayList<Trade>();
    }

    public void printTrades() {
        for (Trade t : tradesList) System.out.println(t);
    }

//    print out all trades under a specific range
    public void printTrades(double maxValue) {
        for (Trade t : tradesList) {
            if (t.price < maxValue) System.out.println(t);
        }
    }

    public double getTotalTradeValue() {
        return totalTradeValue;
    }

    public void setTotalTradeValue(double totalTradeValue) {
        this.totalTradeValue = totalTradeValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.totalTradeValue, totalTradeValue) == 0 && Objects.equals(tradesList, account.tradesList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(totalTradeValue, tradesList);
    }
}
