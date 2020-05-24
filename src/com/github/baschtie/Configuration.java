package com.github.baschtie;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

//TODO reformat classes to suitable logic
class Configuration {

    public Properties properties = new Properties();

    private Path configFile;

    private void readFile() {
        try {
            properties.load(Files.newInputStream(configFile));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveNewIP(String ip) {
        this.properties.setProperty("lastIP", ip);
        try {
            this.properties.store(Files.newOutputStream(configFile), "Auto-Generated");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String getApiVersion() {
        return properties.getProperty("apiVersion");
    }

    public String getDomain() {
        return properties.getProperty("domain");
    }

    public String getRecord() {
        return properties.getProperty("record");
    }

    protected String getToken() {
        return properties.getProperty("token");
    }

    public String getLastIP() {
        return properties.getProperty("lastIP");
    }

    public Configuration(Path configFile) {
        this.configFile = configFile;
        this.readFile();
    }
}
