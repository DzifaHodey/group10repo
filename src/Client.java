import java.time.LocalDate;
import java.util.ArrayList;

public class Client {
    String firstName;
    String lastName;
    double points = 0;
    ArrayList<Trade> clientTrades;
    MembershipType mtStatus = null;

    public Client(String firstName, String lastName) {
        this.clientTrades = new ArrayList<Trade>();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addTrade(Trade newTrade) {
        if (this.canTrade()) {
            clientTrades.add(newTrade);
            points += 1;
            setMembershipStatus();
        }
    }

    public boolean canTrade() {
        if(mtStatus == null) return false;
        return mtStatus.canTrade(this.clientTrades);
    }

    private void setMembershipStatus() {
        if (points > 0 && points <= 9) this.mtStatus = MembershipType.BRONZE;
        if (points > 9 && points <= 19) this.mtStatus = MembershipType.SILVER;
        if (points >= 20) this.mtStatus = MembershipType.GOLD;
    }

    public String getClientMembership() {
        return mtStatus.getMembershipType();
    }
}
