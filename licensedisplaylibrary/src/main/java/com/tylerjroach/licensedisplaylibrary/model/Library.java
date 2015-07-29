package com.tylerjroach.licensedisplaylibrary.model;

/**
 * Created by tylerroach on 7/29/15.
 */
public class Library {

    private String name;
    private String link;
    private String licenseAssetFileName;

    public Library(String name, String link, String licenseAssetFileName) {
        this.name = name;
        this.link = link;
        this.licenseAssetFileName = licenseAssetFileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLicenseAssetFileName() {
        return licenseAssetFileName;
    }

    public void setLicenseAssetFileName(String licenseAssetFileName) {
        this.licenseAssetFileName = licenseAssetFileName;
    }
}
