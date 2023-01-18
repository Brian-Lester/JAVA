import java.util.ArrayList;
public class Orders {
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Items> items;

    public Orders(String name, double total, boolean ready, ArrayList<Items> items){
        this.name=name;
        this.total=total;
        this.ready =ready;
        this.items= new ArrayList<Items>();
    }

    public double addItem(Items item){
        items.add(item);
        total += item.getPrice();
        return total;
    }
    public boolean isReady(boolean isready){
        ready = isready;
        return ready;
    }
}