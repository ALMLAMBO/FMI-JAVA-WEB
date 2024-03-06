package bg.uni.fmi.lab01.streams.entity;

public class OrderLine {
    private Item item;
    private int quantity;
    private boolean specialOffer;

    public OrderLine() {
        this.item = new Item();
        this.quantity = 0;
        this.specialOffer = false;
    }

    public OrderLine(Item item, int quantity, boolean specialOffer) {
        this.item = item;
        this.quantity = quantity;
        this.specialOffer = specialOffer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(boolean specialOffer) {
        this.specialOffer = specialOffer;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "item=" + item +
                ", quantity=" + quantity +
                ", specialOffer=" + specialOffer +
                '}';
    }
}
