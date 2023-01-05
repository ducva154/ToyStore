/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author ANHDUC
 */
public class Bill {
    int billID;
    int accountID;
    List<BillDetail> listDetail;
    String phone;
    String address;
    String note;
    float total;

    public Bill() {
    }

    public Bill(int billID, int accountID, String phone, String address, String note, float total) {
        this.billID = billID;
        this.accountID = accountID;
        listDetail = new Vector<>();
        this.phone = phone;
        this.address = address;
        this.note = note;
        this.total = total;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<BillDetail> getListDetail() {
        return listDetail;
    }

    public void setListDetail(List<BillDetail> listDetail) {
        this.listDetail = listDetail;
    }
}
