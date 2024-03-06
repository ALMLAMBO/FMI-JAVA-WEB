package bg.uni.fmi.lab01.streams.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Order> orders;

    public User() {
        this.orders = new ArrayList<>();
    }

    public User(List<Order> orders) {
        this.orders = new ArrayList<>(orders);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "orders=" + orders +
                '}';
    }
}
