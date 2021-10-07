public class BondTrade extends Trade {

    private final double dividendConstant;
    private double dividend;

    public BondTrade(String id, String symbol, int quantity, double price, double dividendConstant) {
        super(id, symbol, quantity, price);
        this.dividendConstant = dividendConstant;
        calcDividend();
    }

    @Override
    public void calcDividend() {
        this.dividend = this.quantity * this.dividendConstant;
    }
}
