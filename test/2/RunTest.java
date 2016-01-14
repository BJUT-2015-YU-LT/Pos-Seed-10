package run;

import org.junit.Test;

import static org.junit.Assert.*;
import domains.Pos;
import domains.ShoppingChart;
import domains.ShoppingListChart;
import org.junit.Test;
import domains.Item;
import domains.ShoppingChart;
import domains.ShoppingListChart;
import domains.Pos;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


/**
 * Created by gjz on 2016/1/6.
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



    /**
     * Created by gjz on 2016/1/5.
     */

        public void test() throws Exception{

            ShoppingChart shoppingChart = new ShoppingChart();
            ShoppingListChart shoppingListChart = new ShoppingListChart(shoppingChart);
            Pos pos = new Pos();

            assertEquals(    "***商店购物清单***\n"
                    + "----------------------\n"
                    +" 打印时间：2016年01月05日10时05分29秒\n"
                    +      "  ----------------------\n"
                    + "名称：电池，数量：1个，单价：2.00(元)，小计：1.60(元)\n"
                    +        "总价：1.6(元)\n"
                    +         "节省金额：0.4（元）\n"
                    +        " **********************\n",pos.getShoppingList(shoppingListChart));
        }
    }
