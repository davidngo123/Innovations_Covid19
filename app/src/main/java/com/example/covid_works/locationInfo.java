package com.example.covid_works;


/*Class to create an object to store the data of a vaccination site */

public class locationInfo {
    public String provider;
    public String address;
    public String url;

    public locationInfo() {

    }

    public locationInfo(String provider, String address, String url) {
        this.provider = provider;
        this.address = address;
        this.url = url;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getURL() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
