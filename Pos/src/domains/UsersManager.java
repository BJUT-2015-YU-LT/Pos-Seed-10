package domains;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import run.Run;

/**
 * Created by HuYijia on 2015/1/7.
 */
public class UsersManager {
    private boolean vip;
    public UsersManager(){vip = false;}

    public String getUserName() throws Exception
    {
        String context = new Run().ReadFile("C:\\Users\\hp\\IdeaProjects\\Pos\\index.json");
        JSONArray u = JSONArray.fromObject(context);
        JSONObject user = (JSONObject) u.get(0);
        return user.getString("user");
    }

    /*public int getIntegral(String userName) throws Exception
    {
        SAXReader saxReader = new SAXReader();
        Document document;
        document = saxReader.read("users.xml");
        Element root = document.getRootElement();
        Iterator<Element> iterator = root.elementIterator();

        while (iterator.hasNext()) {
            Element element = iterator.next();

            if (element.attributeValue("type").equals(userName)) {
                return Integer.parseInt(element.elementText("integral"));
            }
        }
        return 0;
    }*/

    /*public void increaseIntegral(String userName,int increaseIntegral) throws Exception
    {
        SAXReader saxReader = new SAXReader();
        Document document;
        document = saxReader.read("users.xml");
        Element root = document.getRootElement();
        Iterator<Element> iterator = root.elementIterator();

        while (iterator.hasNext()) {
            Element element = iterator.next();

            if (element.attributeValue("type").equals(userName)) {
                int integral=Integer.parseInt(element.elementText("integral"));
                integral+=increaseIntegral;
                Element integralElement=element.element("integral");
                integralElement.setText(Integer.toString(integral));

                File inputXML=new File("users.xml");
                Writer writer=new FileWriter(inputXML);
                OutputFormat outputFormat=OutputFormat.createPrettyPrint();
                XMLWriter xmlWriter=new XMLWriter(writer,outputFormat);
                xmlWriter.write(document);
                xmlWriter.close();
            }
        }
    }*/

    public boolean isVIP (String userName) throws Exception
    {
        String context = new Run().ReadFile("C:\\Users\\hp\\IdeaProjects\\Pos\\user.json");
        JSONArray u = JSONArray.fromObject(context);
        for(int i=0;i<u.size();i++)
        {
            JSONObject user = (JSONObject) u.get(i);
            if(getUserName().equals(user.getString("user")))
                vip = true;
        }
        return true;
    }
    public String getVIP ()
    {
       if(vip==true)
           return "是";
        return "否";
    }
}
