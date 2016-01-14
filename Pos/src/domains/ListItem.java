package domains;

/**
 * Created by 枫 on 2016/1/5 0005.
 */
public class ListItem extends Item{
    private int amount;
    private double subTotal;
    private double saveMoney;
    private boolean canPromotion;

    public ListItem(Item item) {
        this.barCode = item.barCode;
        this.name = item.name;
        this.unit = item.unit;
        this.price = item.price;
        this.amount = 1;
        this.subTotal = item.price;//小计
    }

    public void add()
    {
        this.amount+=1;
        this.subTotal+=this.price;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(double saveMoney) {
        this.saveMoney = saveMoney;
    }

    public boolean canBePromotion()
    {
        return canPromotion;
    }
}

