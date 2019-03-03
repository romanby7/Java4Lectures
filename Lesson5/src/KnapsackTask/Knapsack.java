package KnapsackTask;

import java.util.ArrayList;

public class Knapsack {
    ArrayList<Item> itemsSet;
    int totalWeight;
    int maxItemsValue;


    public Knapsack(int totalWeight) {

        this.totalWeight = totalWeight;
        this.maxItemsValue = 0;
    }

    public ArrayList<Item> getItemsSet() {
        return itemsSet;
    }

    private int getItemsWeight(ArrayList<Item> list) {
        int weight = 0;
        for (Item item : list) {
            weight += item.getWeight();
        }

        return weight;
    }

    private int getItemsValue(ArrayList<Item> list) {
        int itemsValue = 0;
        for (Item item : list) {
            itemsValue += item.getValue();
        }

        return itemsValue;
    }

    private void findItemsWeightValue(ArrayList<Item> list) {

        if (itemsSet == null && getItemsWeight(list) <= totalWeight) {
            itemsSet = list;
            maxItemsValue = getItemsValue(list);
        }
        else if (getItemsWeight(list) <= totalWeight && getItemsValue(list) > maxItemsValue){
            maxItemsValue = getItemsValue(list);
            itemsSet = list;
        }

    }

    public void checkSets(ArrayList<Item> list) {
        if (!list.isEmpty()) {
            findItemsWeightValue(list);
        }
        for (int i = 0; i < list.size() ; i++) {
            ArrayList<Item> items = new ArrayList<>(list);
            items.remove(i);
            checkSets(items);
        }
    }






}
