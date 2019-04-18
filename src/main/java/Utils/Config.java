package Utils;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

public class Config {

    private static void setPreference(String Key, String Value) {
        try {

            Properties configFile = loadConfig();
            configFile.setProperty(Key, Value);
            OutputStream f = new FileOutputStream("configuration.xml");
            configFile.storeToXML(f, "Configuration file for the Profit System");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPreference(String Key) {

        Properties configFile = loadConfig();
        return (configFile.getProperty(Key));
    }


    public static Properties loadConfig() {

        Properties configFile = new Properties();
        try {
            InputStream f = new FileInputStream("configuration.xml");
            configFile.loadFromXML(f);
            f.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return configFile;
    }

    public static String filePath(int file) {

        if (file == 0) {
            return (System.getProperty("user.dir") + "\\" + "DataSet.csv");
        } else
            return (System.getProperty("user.dir") + "\\" + "ReducedDataSet.csv");
    }
}


