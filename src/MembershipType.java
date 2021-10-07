import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public enum MembershipType {
    BRONZE(5) {
        public boolean canTrade(ArrayList<Trade> tradeList) {
            if (LocalTime.now().isBefore(LocalTime.of(10, 0))) {
                return false;
            }
            return super.canTrade(tradeList);
        }
    },
    SILVER(10) {
        public boolean canTrade(ArrayList<Trade> tradeList) {
            int dailyTrades = 0;
            double totalTradeValues = 0;
            for (Trade trade : tradeList) {
                if (trade.date.equals(LocalDate.now())) {
                    ++dailyTrades;
                    totalTradeValues += trade.price * trade.quantity;
                }
            }
            return (dailyTrades < dailyTradeLimit) || (totalTradeValues < 10_000);
        }
    },
    GOLD(20);

    protected int dailyTradeLimit;

    private MembershipType(int dailyTradeLimit) {
        this.dailyTradeLimit = dailyTradeLimit;
    }

    public String getMembershipType() {
        return this.name();
    }

    public int getDailyTradeLimit() {
        return this.dailyTradeLimit;
    }

    public boolean canTrade(@NotNull ArrayList<Trade> tradeList) {

        int dailyTrades = 0;
        for (Trade trade : tradeList) {
            if (trade.date.equals(LocalDate.now())) {
                ++dailyTrades;
            }
        }
        return (dailyTrades < dailyTradeLimit);
    }
}

//    private int dailyTradeLimit;
//
//    abstract public String getMembershipType();
//
//    public MembershipType(int dailyTradeLimit) {
//        this.dailyTradeLimit = dailyTradeLimit;
//    }
//
//    public int getDailyTradeLimit() {
//        return this.dailyTradeLimit;
//    }