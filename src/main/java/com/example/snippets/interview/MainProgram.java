package com.example.snippets.interview;

import java.util.*;

import static com.example.snippets.interview.Category.*;

public class MainProgram {

    static Map<Category, Long> discounts = Map.of(CLEANING, 50L,
            FOOD, 10L,
            FASHION, 25L,
            ELECTRONIC, 5L,
            HEALTH_CARE, 30L,
            FURNITURE, 50L);



    public static void main(String[] args) {

        List<ItemEpam> itemEpams = List.of(
                new ItemEpam("Rice", "Integral rice", 20L, FOOD),
                new ItemEpam("Celphone", "Huawei", 100L, ELECTRONIC),
                new ItemEpam("Jeans", "Pants", 100L, FASHION),
                new ItemEpam("Jeringa", "Inyection", 10L, HEALTH_CARE));

        Long totalPrice = itemEpams.stream().map(ItemEpam::getPrice)
                .reduce(0L, Long::sum);

        Long totalDiscount = itemEpams.stream()
                .map(i -> calculateDiscount(i))
                .reduce(0L, Long::sum);

        long totalToPay = totalPrice - totalDiscount;

        System.out.println("Total Price: " + totalPrice);
        System.out.println("Total Discount: " + totalDiscount);
        System.out.println("Total Pay: " + totalToPay);


    }

    private static long calculateDiscount(ItemEpam itemEpam) {
        return itemEpam.getPrice() * discounts.get(itemEpam.getCategory()) / 100L;
    }

}


enum Category {

    FOOD,
    ELECTRONIC,
    FURNITURE,
    FASHION,
    CLEANING,
    HEALTH_CARE;

}

class ItemEpam {

    private String name;
    private String description;
    private long price;
    private Category category;

    public ItemEpam(String name, String description, long price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
