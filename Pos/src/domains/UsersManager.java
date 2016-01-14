package domains;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import run.Run;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 枫 on 2015/1/7.
 */
public class UsersManager {
    private boolean vip;
    private int integral;
    private JSONArray user;
    public UsersManager()
    {
        vip = false;
        String context = new Run().ReadFile("C:\\Users\\hp\\IdeaProjects\\Pos\\index.json");
        user = JSONArray.fromObject(context);
        setIntegral();
        setVip();
    }

    public void setIntegral()
    {
        String context = new Run().ReadFile("C:\\Users\\hp\\IdeaProjects\\Pos\\integral.json");
        JSONArray u = JSONArray.fromObject(context);
        JSONObject integral = (JSONObject) u.get(0);
        this.integral = integral.getInt("integral");
    }

    public void setVip()
    {
        String context = new Run().ReadFile("C:\\Users\\hp\\IdeaProjects\\Pos\\user.json");
        JSONArray u1 = JSONArray.fromObject(context);
        JSONObject vip = (JSONObject) user.get(0);
        for(int i=0;i<user.size();i++)
        {
            JSONObject user = (JSONObject) u1.get(i);
            if(vip.getString("user").equals(user.getString("user")))
                this.vip = user.getBoolean("isvip");
        }
    }
    public String getUserName() throws Exception
    {
        JSONObject user = (JSONObject) this.user.get(0);
        return user.getString("user");
    }

    public int getIntegral(String UserName) throws Exception { return integral; }

    public void increaseIntegral(String userName,int increaseIntegral) throws Exception
    {
        this.integral += increaseIntegral;
        save();
    }

    public boolean isVIP (String userName) throws Exception
    {
        return vip;
    }

    public String getVIP ()
    {
       if(vip==true)
           return "是";
        return "否";
    }

    public void save()throws IOException
    {
        String stringbuilder = new StringBuilder()
                .append("[\n{\n")
                .append("\"user\": 'USER0001',\n")
                .append("\"integral\":'")
                .append(this.integral + "'")
                .append("}\n]\n")
                .toString();

        WriteToFile(new File("C:\\Users\\hp\\IdeaProjects\\Pos\\integral.json"), stringbuilder);
    }
    private void WriteToFile(File file, String content) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.write(content);
        printWriter.close();
    }
}
