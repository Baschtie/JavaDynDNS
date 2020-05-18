package com.github.baschtie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

//TODO make class static
public class IPChecker {
    private final String URL = "http://checkip.amazonaws.com";
    private URL ipchecker = new URL(URL);
    private BufferedReader input = new BufferedReader(new InputStreamReader(ipchecker.openStream()));

    private String ip = input.readLine();

    public IPChecker() throws IOException {
    }

    public String getIp() {
        return this.ip;
    }
}
