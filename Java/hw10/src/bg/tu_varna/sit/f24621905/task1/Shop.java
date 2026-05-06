package bg.tu_varna.sit.f24621905.task1;
import java.util.ArrayList;

public class Shop {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }
    public int countItemsForDelivery(){
        int sum = 0;
        for(Item i : items){
            if (i.needsDelivery()) sum += i.getAvailableQuantity();
        }
        return sum;
    }

    public double calculateItemsPrice(){
        double sum = 0;
        for(Item i: items){
            sum += i.getItemPrice();
        }
        return sum;
    }

    public Item getItemWithMostAvailableQuantity(){
        Item maxQuantity = items.get(0);
        for(Item i: items){
            if (i.getAvailableQuantity() > maxQuantity.getAvailableQuantity()){
                maxQuantity = i;
            }
        }
        return maxQuantity;
    }

    public Item getItemWithLeastAvailableQuantity(){
        Item leastQuantity = items.get(0);
        for(Item i: items){
            if (i.getAvailableQuantity() < leastQuantity.getAvailableQuantity()){
                leastQuantity = i;
            }
        }
        return leastQuantity;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "items=" + items +
                '}';
    }
}
