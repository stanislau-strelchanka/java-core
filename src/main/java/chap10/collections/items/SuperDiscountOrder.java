package chap10.collections.items;

/**
 * Created by Stas on 11/01/2015.
 */
public class SuperDiscountOrder extends DiscountOrder {

    public SuperDiscountOrder(int idOrder, float amount){
        super(idOrder,amount);
    }

    @Override
    public String toString(){

        return "SuperDiscountOrder [orderId =" + getOrderId() + ", amount=" + getAmount() + "]";
    }
}
