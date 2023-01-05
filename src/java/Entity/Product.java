/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ANHDUC
 */
public class Product {

    private int productID;
    private String productName;
    private String productImage;
    private float productPrice;
    private String description;
    private int categoryID;
    private int discount;
    private int quantity;

    public Product() {
    }

    public Product(int productID, String productName, String productImage, float productPrice, String description, int categoryID, int discount, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.description = description;
        this.categoryID = categoryID;
        this.discount = discount;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    public String outTable(String cName) {
        return "<td>" + productID + "</td>"
                + "<td>" + productName + "</td>"
                +"<td><img alt='...' src='" + productImage + "'</td>"
                +"<td>" + productPrice + "</td>"
                +"<td>" + description + "</td>"
                +"<td>" + cName + "</td>"
                +"<td>" + discount + "</td>"
                +"<td>" + quantity + "</td>";
    }
}
