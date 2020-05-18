package com.github.baschtie;

import java.io.IOException;
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
    }
}
