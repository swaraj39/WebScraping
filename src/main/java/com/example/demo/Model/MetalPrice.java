package com.example.demo.Model;

public class MetalPrice {
    private String metal;
    private String current;
    private String previous;
    private String expiry;

    public MetalPrice(String metal, String current, String previous, String expiry) {
        this.metal = metal;
        this.current = current;
        this.previous = previous;
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "MetalPrice{" +
                "metal='" + metal + '\'' +
                ", current='" + current + '\'' +
                ", previous='" + previous + '\'' +
                ", expiry='" + expiry + '\'' +
                '}';
    }

    public String getMetal() { return metal; }
    public String getCurrent() { return current; }
    public String getPrevious() { return previous; }
    public String getExpiry() { return expiry; }
}