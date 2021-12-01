package GroceriesApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TempOrder {

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();

    private String name;
    private String category;
    private float price;
    private Date productionsDate ;
    private Date expirationsDate ;
    private float calories;
    private int orderId;


    public TempOrder(String name, String category, float price, Date productionsDate, Date expirationsDate, float calories, int orderId) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.productionsDate = productionsDate;
        this.expirationsDate = expirationsDate;
        this.calories = calories;
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", productionsDate=" + productionsDate +
                ", expirationsDate=" + expirationsDate +
                ", calories=" + calories +
                ", orderId=" + orderId +
                '}';
    }
}
