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
public class BillDetail {
    int no;
    int accountID;
    int productID;
    int quantity;
    float price;

    public BillDetail() {
    }

    public BillDetail(int no, int accountID, int productID, int quantity, float price) {
        this.no = no;
        this.accountID = accountID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public String outTable(String productName) {
        return "<td style=\"text-align: center\">" + no + "</td>"
                +"<td>" + productName + "</td>"
                +"<td style=\"text-align: center\">" + quantity + "</td>"
                +"<td style=\"text-align: right\">" + price + "</td>"
                +"<td style=\"text-align: right\">" + price*quantity + "</td>";
    }

    @Override
    public String toString() {
        return "BillDetail{" + "no=" + no + ", accountID=" + accountID + ", productID=" + productID + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
}
