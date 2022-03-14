import java.util.ArrayList;

public class JungleRun {

    private ArrayList<Circuit> circuits;
    private int totalSubscriptions;
    private Double totalRaisedValue;

    public JungleRun(ArrayList<Circuit> circuits) {
        this.circuits = circuits;
        this.totalRaisedValue = calculateTotalRaisedValue();
        this.totalSubscriptions = calculateTotalSubscriptions();
    }

    private int calculateTotalSubscriptions() {
        int totalSubscriptions = 0;
        for(Circuit c: circuits){
            totalSubscriptions+=c.getSubscriptionList().size();
        }
        return totalSubscriptions;
    }

    private Double calculateTotalRaisedValue(){
        Double totalValue=0.0;
        for(Circuit c: circuits){
            for (Subscription s: c.getSubscriptionList()){
                totalValue+=s.getSubscriptionPrice();
            }
        }
        return totalValue;
    }

    @Override
    public String toString() {
        return "\n\nCorrida na selva {" +
                "total de inscricoes=" + totalSubscriptions +
                ", total arrecadado=" + totalRaisedValue +
                '}';
    }
}
