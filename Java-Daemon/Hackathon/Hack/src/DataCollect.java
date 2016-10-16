/**
 * Created by heidianderson on 10/16/16.
 */
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.URL;
import java.util.*;
public class DataCollect {

    private final String USER_AGENT = "Mozilla/5.0";
    String hostname = "";
    String internalIP = "";
    String externalIP = "";
    long ramNum;
    String ram = "";
    String operatingSystem = "";
    String version = "";

    public String makeID()
    {
        String id = "";
        for(int i = 0; i < 8; i++)
        {
            Random generator = new Random();
            id+=generator.nextInt(10);
        }
        return id;
    }

    public void setAttributeNames() throws Exception {
        String id = makeID();
        String url = "http://68.38.21.90/daemon-connect.php";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        String urlParameters = "universal-id=" + id +"&network-hostname="+hostname+"&network-ext-ip="+externalIP+"&network-int-ip="+internalIP+"&system-os="+operatingSystem+"&system-os-ver="+version+"&system-ram="+ram;
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
    }
    /**
     *IP: 68.38.21.90
     *PORT: 3306
     * USER: root
     * PASS: jman22355
     *DATABASE: njcs-tvr
     **/


    /**
    network-hostname
    network-ext-ip
    network-int-ip
    system-os
    system-os-ver
    system-ram
    universal-id
    **/
    public void collect()
    {
        try{
        BufferedReader reader;
        hostname = InetAddress.getLocalHost().getHostName();
        internalIP = InetAddress.getLocalHost().getHostAddress();
        URL ip = new URL("http://checkip.amazonaws.com");
        reader = new BufferedReader(new InputStreamReader(ip.openStream()));
        externalIP = reader.readLine();
        ramNum = (((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize());
        if(ramNum/Math.pow(10,9)>0)
        {
            ramNum=ramNum/(long)Math.pow(10,9);
            ram = ramNum+"GB";
        }
        else
        {
            ramNum = ramNum / (long) Math.pow(10, 6);
            ram = ramNum+"MB";
        }
        operatingSystem = System.getProperty("os.name");
        version = System.getProperty("os.version");

            setAttributeNames();
    }catch(Exception e){}
}
}
