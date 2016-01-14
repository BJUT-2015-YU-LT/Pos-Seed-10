package run;


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

/**
 * Created by 枫 on 2016/1/5 0005.
 */
public class Run {
    public static void main(String[] args) throws Exception {
        Run run = new Run();
        ShoppingChart shoppingChart = run.Index();
        ShoppingListChart shoppingListChart = new ShoppingListChart(shoppingChart);
        Pos pos = new Pos();
        String result = pos.getShoppingList(shoppingListChart);
        System.out.println(result);
    }
    /*
    功能：根据索引表导出购物清单，创建商品对象
    参数：无
    返回值：购物车清单ShoppingChart，若读取时出错，则跳过该清单并提示出错的编码barCode
    */
    public ShoppingChart Index() throws  Exception
    {
        String path = "C:\\Users\\hp\\IdeaProjects\\Pos\\pos1.json";
        String JsonContext = new Run().ReadFile(path);
        JSONArray jsonArray = JSONArray.fromObject(JsonContext);
        ShoppingChart shoppingChart=new ShoppingChart();
        int size = jsonArray.size();
        for(int i=0;i<size;i++)
        {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String barCode=jsonObject.getString("barcode");
            double price = Double.parseDouble(jsonObject.getString("price"));
            Item item = new Item(jsonObject.getString("barcode"),jsonObject.getString("name"),
                    jsonObject.getString("unit"),price);
            if(!item.iseffect())
            {
                System.out.println("Discount and promotion can't exist both, barCode: "+item.getBarCode());
            }
            if(!item.isNull()){
                shoppingChart.add(item);
            }else {
                System.out.println("Read error,item barcode: " + barCode);
            }
        }
        return  shoppingChart;
    }
    /*
    功能：通过文件路径打开文件并读取内容
    参数：文件路径path
    返回值：文件内容
     */
    public String ReadFile(String path){
        File file = new File(path);
        BufferedReader reader = null;
        String laststr = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr = laststr+tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return laststr;
    }

}
