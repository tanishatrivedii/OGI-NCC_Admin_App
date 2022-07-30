package com.example.oginccadmin;

public class uploadPDF {
    public String nme;
    public String url;

    public uploadPDF() {
    }

    public uploadPDF(String nme, String url) {
        this.nme = nme;
        this.url = url;
    }

    public String getNme() {
        return nme;
    }

    public String getUrl() {
        return url;
    }
}
