package domains;

/**
 * Created by 枫 on 2016/1/5 0005.
 */
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Pos {
    public Pos() {}

    public String getShoppingList(ShoppingListChart shoppingListChart) throws Exception{
        ArrayList<ListItem> listItems = shoppingListChart.getListItems();
        double totalMoney = 0;
        double totalSaveMoney = 0;

        for (int i = 0; i < listItems.size(); i++) {
            totalMoney += listItems.get(i).getSubTotal();
            totalSaveMoney += listItems.get(i).getSaveMoney();
        }

        InetAddress address = InetAddress.getLocalHost();
        String name = address.getHostName();

        StringBuilder stringBuilder = new StringBuilder();
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
        String currentTime=simpleDateFormat.format(calendar.getTime());
        UsersManager usersManager = new UsersManager();
        stringBuilder
                .append("***商店购物清单***\n")
                .append("----------------------\n")
                .append("用户：" + usersManager.getUserName() + "\t会员：" + usersManager.getVIP() + "\n")
                .append("打印时间：" + currentTime + "\n")
                .append("操作员：" + name + "\n")
                .append("----------------------\n");

        for (int i = 0; i < listItems.size(); i++) {
            listItems.get(i).getResult();
            stringBuilder
                    .append("名称：").append(listItems.get(i).getName()).append("，");
            stringBuilder
                    .append("数量：").append(listItems.get(i).getAmount()).append(listItems.get(i).getUnit()).append("，");
            stringBuilder
                    .append("单价：").append(String.format("%.2f", listItems.get(i).getPrice()));
            stringBuilder
                    .append("(元)").append("，")
                    .append("小计：").append(String.format("%.2f", listItems.get(i).getSubTotal()))
                    .append("(元)").append("\n");
        }
        stringBuilder.append("----------------------\n");
        totalMoney = 0;
        totalSaveMoney = 0;
        for (int i = 0; i < listItems.size(); i++) {
            totalMoney+=listItems.get(i).getSubTotal();
            totalSaveMoney+=listItems.get(i).getSaveMoney();
        }
        if (shoppingListChart.isPromotion()&&shoppingListChart.getvip()==1.0) {
            stringBuilder
                    .append("----------------------\n挥泪赠送商品:\n");
            for (int i = 0; i < listItems.size(); i++) {

                if (listItems.get(i).canBePromotion()) {
                    stringBuilder
                            .append("名称：").append(listItems.get(i).getName()).append("，")
                            .append("数量：").append(listItems.get(i).getNum()).append(listItems.get(i).getUnit()).append("\n");
                }
            }
            stringBuilder.append("----------------------\n");
        }
        stringBuilder.append("总价：").append(totalMoney).append("(元)").append("\n");
        if(totalMoney!=0)
            stringBuilder.append("节省金额：").append(totalSaveMoney).append("（元）").append("\n");
        stringBuilder.append("**********************\n");
        return stringBuilder.toString();
    }
}
