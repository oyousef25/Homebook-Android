package com.example.homebook.pojo;

/**
 * House Class:
 * It allows us to make a new House instance
 *
 * @author Omar Yousef
 * @version 1.0
 * @since 11th DEC
 */
public class HouseItem {
    private int image;
    private String price;
    private String details;
    private String address;

    /**
     * House Constructor
     * @param image
     * @param details
     * @param price
     * @param address
     */
    public HouseItem(int image, String details, String price, String address) {
        this.image = image;
        this.details = details;
        this.price = price;
        this.address = address;
    }

    /**
     *
     * @return image
     */
    public int getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     *
     * @return details
     */
    public String getDetails() {
        return details;
    }

    /**
     *
     * @param details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     *
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
