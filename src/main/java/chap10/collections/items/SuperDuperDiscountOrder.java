package chap10.collections.items;

/**
 * Created by Stas on 11/01/2015.
 */
public class SuperDuperDiscountOrder extends  SuperDiscountOrder {

    public SuperDuperDiscountOrder(int idOrder, float amount){
        super(idOrder,amount);
    }

    @Override
    public String toString(){

        return "SuperDuperDiscountOrder [orderId =" + getOrderId() + ", amount=" + getAmount() + "]";
    }
}
