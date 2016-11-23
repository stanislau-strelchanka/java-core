package chap10.collections.items;

/**
 * Created by Stas on 11/01/2015.
 */
public class DiscountOrder extends Order {

    public DiscountOrder(int idOrder, float amount){
        super(idOrder,amount);
    }

    @Override
    public String toString(){

        return "DiscountOrder [orderId =" + getOrderId() + ", amount=" + getAmount() + "]";
    }
}
