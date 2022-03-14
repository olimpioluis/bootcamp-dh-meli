public class Subscription {
    private Participant participant;
    private Category category;
    private double subscriptionPrice;

    public Subscription(Participant participant, Category category) {
        this.participant = participant;
        this.category = category;
        this.subscriptionPrice = calculatePrice();
    }

    private Double calculatePrice(){
        switch (this.category){
            case SMALL:
                if(participant.getAge()<18){
                    return 1300.0;
                }else{
                    return 1500.0;
                }
            case MEDIUM:
                if(participant.getAge()<18){
                    return 2000.0;
                }else{
                    return 2300.0;
                }
            case ADVANCED:
                return 2800.0;

        }
        return null;
    }

    public Participant getParticipant() {
        return participant;
    }

    public Category getCategory() {
        return category;
    }

    public double getSubscriptionPrice() {
        return subscriptionPrice;
    }

    @Override
    public String toString() {        return "\nInscricao{" +
                "participante=" + participant +
                ", categoria=" + category +
                ", valor da inscricao=" + subscriptionPrice +
                '}';
    }
}
