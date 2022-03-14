import java.util.ArrayList;

public class Circuit {
    private Category category;
    private int distance;
    private ArrayList<Subscription> subscriptionList;

    public Circuit(Category category, int distance) {
        this.category = category;
        this.distance = distance;
        this.subscriptionList = new ArrayList<>();
    }

    public void addSubscription(Subscription subscription){
        if(subscription.getCategory().equals(this.category)) {
            if (!(subscription.getParticipant().getAge() < 18 && subscription.getCategory().equals(Category.ADVANCED))) {
                if (!subscriptionList.contains(subscription)) {
                    subscription.getParticipant().setCode(subscriptionList.size() + 1);
                    subscriptionList.add(subscription);
                    System.out.println(subscription.getParticipant().getName() + " Inscrito no Circuito " + this.category + " Valor Inscrição: " + subscription.getSubscriptionPrice());
                } else {
                    System.out.println("ATENÇÃO: " + subscription.getParticipant().getName() + " Já está inscrito no Circuito " + this.category);
                }
            } else {
                System.out.println("ATENÇÃO: " + subscription.getParticipant().getName() + " não pode se inscrever em circuito " + this.category+ ". Menos de 18 anos.");
            }
        }
    }

    public void removerSubscription(String nome){
        if(subscriptionList.removeIf(subscription -> subscription.getParticipant().getName().equals(nome))){
            System.out.println("Inscrição removida com sucesso!");
        }else{
            System.out.println("Maratonista não encontrado no circuito!");
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public ArrayList<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(ArrayList<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    @Override
    public String toString() {
        return "Circuito{" +
                "nome='" + category + '\'' +
                ", distance=" + distance +
                ", subscriptionList=" + subscriptionList +
                '}';
    }
}
