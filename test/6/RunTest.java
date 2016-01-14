import domains.Pos;
import domains.ShoppingChart;
import domains.ShoppingListChart;
import org.junit.Test;
import run.Run;

import static org.junit.Assert.*;

/**
 * Created by gjz on 2016/1/10.
 */
public class RunTest {

    @Test
    public void testMain() throws Exception {

    }

    @Test
    public void testIndex() throws Exception {

    }

    @Test
    public void testReadFile() throws Exception {

    }
    @Test
    public  void testRun() throws Exception{
        ShoppingChart shoppingChart = new Run().Index();
        ShoppingListChart shoppingListChart = new ShoppingListChart(shoppingChart);
        Pos pos = new Pos();

        assertEquals(    "***商店购物清单***\n"
                +"----------------------\n"
                +"用户编号：USER0001\t会员：是\t积分：105\n"
                +"打印时间：2016年01月14日06时28分03秒\n"
                +"操作员：gjz-PC\n"
                +"----------------------\n"
                +"名称：可口可乐，数量：3瓶，单价：3.00(元)，小计：8.40(元)\n"
                +"----------------------\n"
                +"总价：8.4(元)\n"
                +"节省金额：5.4（元）\n"
                +"**********************\n",pos.getShoppingList(shoppingListChart));
    }
}