package com.github.baschtie;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Error: No Config File selected!");
            return;
        }
        Configuration config = new Configuration(FileSystems.getDefault().getPath(args[0]));
        IPChecker ipChecker = new IPChecker();

        System.out.println("Domain: " + config.getDomain());
        System.out.println("Record: " + config.getRecord());
        System.out.println("Token: " + config.getToken());
        System.out.println("Current IP: " + ipChecker.getIp());
        config.properties.setProperty("lastIP", ipChecker.getIp());
        config.saveNewIP(ipChecker.getIp());

        //Update IP if a new IP is detected
        if(ipChecker.getIp() != config.getLastIP()) {
            StringBuffer urlBuffer = new StringBuffer("https://api.digitalocean.com/");
            urlBuffer.append(config.getApiVersion());
            urlBuffer.append("/domains/");
            urlBuffer.append(config.getDomain());
            urlBuffer.append("/records/");
            urlBuffer.append(config.getRecord());
            urlBuffer.append("?data=");
            urlBuffer.append(ipChecker.getIp());

            URL url = new URL(urlBuffer.toString());
        }
    }
}
