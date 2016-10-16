import java.sql.*;

import java.io.*;
import java.net.*;
import java.lang.management.*;
public class Collection
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    String dbName = "njcs-tvr?autoReconnect=true&useSSL=false";
    static final String USER = "root";
    static final String PASS = "jman22355";
    Connection conn = null;
    String sql = "";
    String hostname = "";
    String internalIP = "";
    String externalIP = "";
    String operatingSystem = "";
    String version = "";
    double cpu = 0;
    long ram = 0;

    public static void main(String[]args)
    {
        Collection c = new Collection();

        c.collect();
        c.send();
    }

    Statement stmt = null;
    public void send()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL+dbName, USER, PASS);
            sql = "INSERT INTO  hello_world (hostname, internal_ip, external_ip, os, os_ver, ram) VALUES ('"+hostname+"','"+internalIP+"','"+externalIP+"','"+operatingSystem+"','"+version+"','"+ram+"');";
            //sql = "";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }catch(Exception se){se.printStackTrace();}
        try
        {
            if (conn != null)
                conn.close();
        }catch(Exception e){}
    }

    public void collect()
    {
        FileWriter fWriter;
        BufferedWriter writer;
        BufferedReader reader;
        /**
         *IP: 68.38.21.90
         *PORT: 3306
         *USER: root
         *PASS: jman22355
         *DATABASE: njcs-tvr
         **/
        try{
            hostname = InetAddress.getLocalHost().getHostName();
            internalIP = InetAddress.getLocalHost().getHostAddress();
            URL ip = new URL("http://checkip.amazonaws.com");
            reader = new BufferedReader(new InputStreamReader(ip.openStream()));
            externalIP = reader.readLine();
            ram = (((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize());
            if(ram/Math.pow(10,9)>0) ram=ram/(long)Math.pow(10,9);
            else ram=ram/(long)Math.pow(10,6);;

            //OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            //cpu = osBean.getSystemLoadAverage();

            operatingSystem = System.getProperty("os.name");
            version = System.getProperty("os.version");

            fWriter = new FileWriter("text.txt");
            writer = new BufferedWriter(fWriter);
            writer.write("Hostname: " + hostname);
            writer.newLine();
            writer.write("Internal IP: " + internalIP);
            writer.newLine();
            writer.write("External IP: " + externalIP);
            writer.newLine();
            writer.write("Ram Size: " + ram);
            writer.newLine();
            //writer.write("CPU: " + cpu);
            //writer.newLine();
            writer.write("Operating System: " + operatingSystem);
            writer.newLine();
            writer.write("Version: " + version);
            writer.newLine();
            writer.close();
        }catch(Exception e){}
    }
}