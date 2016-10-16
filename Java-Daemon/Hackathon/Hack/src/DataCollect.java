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

    public static void main(String[]args)
    {

        DataCollect d = new DataCollect();
        d.collect();
    }

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

    public void setAttributeNames(){
        try {
            String id = makeID();
            String urlParameters = "universal-id=" + id + "&network-hostname=" + hostname + "&network-ext-ip=" + externalIP + "&network-int-ip=" + internalIP + "&system-os=" + operatingSystem + "&system-os-ver=" + version + "&system-ram=" + ram;
            String url = "http://10.186.4.198/daemon-connect.php";
            //URL obj = new URL(url);
            URL obj = new URL(null, url, new sun.net.www.protocol.https.Handler());
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            System.out.println(responseCode);
        }catch(Exception e){System.out.println(e);};
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
            FileWriter fWriter;
            BufferedWriter writer;
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

            //setAttributeNames();
           // String urlParameters = "universal-id=" + id + "&network-hostname=" + hostname + "&network-ext-ip=" + externalIP + "&network-int-ip=" + internalIP + "&system-os=" + operatingSystem + "&system-os-ver=" + version + "&system-ram=" + ram;

            fWriter = new FileWriter("text.txt");
            writer = new BufferedWriter(fWriter);
            writer.write("universal-id=" + hostname);
            writer.write(",network-ext-ip=" + internalIP);
            writer.write(",network-int-ip=" + externalIP);
            writer.write(",system-os=" + operatingSystem);
            writer.write(",system-os-ver=" + version);
            writer.write(",system-ram=" + ram);
            writer.close();
        }catch(Exception e){}
    }
}
