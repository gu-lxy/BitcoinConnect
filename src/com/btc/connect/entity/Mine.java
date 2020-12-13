package com.btc.connect.entity;

public class Mine {
    private double trusted;
    private double untrusted;
    private double immature;

    public double getTrusted() {
        return trusted;
    }

    public void setTrusted(double trusted) {
        this.trusted = trusted;
    }

    public double getUntrusted() {
        return untrusted;
    }

    public void setUntrusted(double untrusted) {
        this.untrusted = untrusted;
    }

    public double getImmature() {
        return immature;
    }

    public void setImmature(double immature) {
        this.immature = immature;
    }
}
