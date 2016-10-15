import com.sun.jmx.snmp.tasks.Task;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.io.*;
import java.net.*;
import java.lang.management.*;
import java.lang.Object.*;
import java.util.*;
public class Collection
{
    public void collect()
    {
        String hostname = "";
        String internalIP = "";
        String externalIP = "";
        String operatingSystem = "";
        String version = "";
        double cpu = 0;
        long ram = 0;
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        BufferedReader reader = null;
        String idCode = getID();
        //clock speed
        //operating system, version

        //unique user id cases dont matter
        //send to mysql database

        /**
         *IP: 68.38.21.90
         *PORT: 3306
         *USER: root
         *PASS: jman22355
         *DATABASE: njcs-tvr
         **/
        Sql2o sql2o = new Sql2o("68.38.21.90:3306", "root", "jman22355");
        String sql =
                "INSERT INTO sql2o ( UID, hostname, internal_ip, external_ip, os, os_ver, ram)\n" +
                        "VALUES\n" +
                        "( idCode, hostname, internalIP, externalIP, operatingSystem, version, ram);";

        try{Connection con = sql2o.open();
            List<Task> tasks = con.createQuery(sql)
                    .addParameter("category", "foo")
                    .executeAndFetch(Task.class);
        }catch(Exception e){}
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
            writer.write("ID: " + idCode);
            writer.newLine();
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

    public String getID()
    {
        //id will have 7 characters
        //3 ints, 3 chars, 1 num
        String id = "";
        Random generator = new Random();
        int num;
        for(int i = 0; i < 3; i++)
        {
            num = generator.nextInt(10);
            id+=num;
        }
        for(int i = 0; i < 3; i++)
        {
            num = generator.nextInt(26);
            if(num==0) id+='a';
            else if(num==1) id+='b';
            else if(num==2) id+='c';
            else if(num==3) id+='d';
            else if(num==4) id+='e';
            else if(num==5) id+='f';
            else if(num==6) id+='g';
            else if(num==7) id+='h';
            else if(num==8) id+='i';
            else if(num==9) id+='j';
            else if(num==10) id+='k';
            else if(num==11) id+='l';
            else if(num==12) id+='m';
            else if(num==13) id+='n';
            else if(num==14) id+='o';
            else if(num==15) id+='p';
            else if(num==16) id+='q';
            else if(num==17) id+='r';
            else if(num==18) id+='s';
            else if(num==19) id+='t';
            else if(num==20) id+='u';
            else if(num==21) id+='v';
            else if(num==22) id+='w';
            else if(num==23) id+='x';
            else if(num==24) id+='y';
            else if(num==25) id+='z';
        }
        num = generator.nextInt(10);
        id+=num;
        return id;
    }


}