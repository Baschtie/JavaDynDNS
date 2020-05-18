package com.github.baschtie;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

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

    public Configuration(Path configFile) {
        this.configFile = configFile;
        this.readFile();
    }
}
