package test;

import java.io.BufferedWriter;

public class WriteThread {
    protected BufferedWriter writer;
    protected Client client;

    public WriteThread(Client client, BufferedWriter writer) {
        this.writer = writer;
        this.client = client;
    }

    public void run() {
        while(true) {

        }
    }
}