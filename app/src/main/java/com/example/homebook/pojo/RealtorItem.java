package com.example.homebook.pojo;

/**
 * RealtorItem Class:
 * We will use this class to make a new instance of the Realtor object
 *
 * @author Omar Yousef
 * @version 1.0
 * @since 4th December
 */
public class RealtorItem {
    private String name;
    private String address;
    private String contact;

    public RealtorItem(String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
