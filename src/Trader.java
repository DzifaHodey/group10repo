public class Trader {
    private String name;
    public Account account;

    public Trader(String name) {
        this.name = name;
        this.account = new Account();;
    }

    public void addTrade(Trade trade) {
        double newTotal = account.getTotalTradeValue() + (trade.getPrice() * trade.quantity);
        account.setTotalTradeValue(newTotal);
    }


}
