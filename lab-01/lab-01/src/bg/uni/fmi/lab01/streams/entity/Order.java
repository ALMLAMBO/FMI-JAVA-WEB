package bg.uni.fmi.lab01.streams.entity;

import bg.uni.fmi.lab01.streams.vo.OrderStatus;
import bg.uni.fmi.lab01.streams.vo.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;
    private List<OrderLine> orderLines;
    private LocalDate orderDate;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;

    public Order() {
        this.id = -1;
        this.orderLines = new ArrayList<>();
        this.orderDate = LocalDate.now();
        this.orderStatus = OrderStatus.ACTIVE;
        this.paymentMethod = PaymentMethod.CASH_ON_DELIVERY;
    }

    public Order(long id, List<OrderLine> orderLines, LocalDate orderDate, OrderStatus orderStatus, PaymentMethod paymentMethod) {
        this.id = id;
        this.orderLines = new ArrayList<>(orderLines);
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderLines=" + orderLines +
                ", orderDate=" + orderDate +
                ", orderStatus=" + orderStatus +
                ", paymentMethod=" + paymentMethod +
                '}';
    }

    public BigDecimal getItemPrice() {
        return getOrderLines()
                .stream()
                .map(orderLine -> orderLine.getItem().getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
