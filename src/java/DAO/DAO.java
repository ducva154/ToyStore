/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DBContext;
import Entity.Account;
import Entity.BillDetail;
import Entity.Product;
import Entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author ANHDUC
 */
public class DAO {

    private Connection con;
    public String status;

    public DAO() {
        initConnection();
    }

    private void initConnection() {
        try {
            con = new DBContext().getConnection();
            status = "Thanh cong";
        } catch (Exception e) {
            status = "That bai" + e.getMessage();
        }
    }

    public HashMap<Integer, Product> getProductFromDB() {
        String sql = "select * from HE140108_DUCVA_Product";
        HashMap<Integer, Product> hm = new HashMap<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                hm.put(id, new Product(id,
                        rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException e) {
            status = "getDB that bai" + e.getMessage();
        }
        return hm;
    }

    public HashMap<Integer, Product> getDiscountProductFromDB() {
        String sql = "select * from HE140108_DUCVA_Product where Discount<>0 order by Discount DESC";
        HashMap<Integer, Product> hm = new HashMap<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                hm.put(id, new Product(id,
                        rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException e) {
            status = "getDB that bai" + e.getMessage();
        }
        return hm;
    }

    public Product getProductByID(int productID) {
        String sql = "select * from HE140108_DUCVA_Product where Product_ID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                return new Product(id,
                        rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8));
            }
        } catch (SQLException e) {
            status = "getDB that bai" + e.getMessage();
        }
        return null;
    }

    public HashMap<Integer, Category> getCategoryFromDB() {
        String sql = "select * from HE140108_DUCVA_Category";
        HashMap<Integer, Category> hm = new HashMap<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                hm.put(id, new Category(id,
                        rs.getString(2)));
            }
        } catch (SQLException e) {
            status = "getDB that bai" + e.getMessage();
        }
        return hm;
    }

    public HashMap<Integer, Product> getProductbyCategoryFromDB(int categoryID) {
        String sql = "select * from HE140108_DUCVA_Product where Category = ?";
        HashMap<Integer, Product> hm = new HashMap<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoryID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                hm.put(id, new Product(id,
                        rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException e) {
            status = "getDB that bai" + e.getMessage();
        }
        return hm;
    }

    public HashMap<Integer, Product> getProductByNameFromDB(String st) {
        String sql = "select * from HE140108_DUCVA_Product where Product_Name like ?";
        HashMap<Integer, Product> hm = new HashMap<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + st + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                hm.put(id, new Product(id,
                        rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException e) {
            status = "getDB that bai" + e.getMessage();
        }
        return hm;
    }

    public Account login(String user, String pass) {
        String sql = "select * from HE140108_DUCVA_Account where Username = ? and Password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                return new Account(id, rs.getString(2), rs.getString(3), rs.getBoolean(4), 
                        rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getInt(9), rs.getBoolean(10), rs.getInt(11), rs.getString(12));
            }
        } catch (SQLException e) {
            status = "getDB that bai" + e.getMessage();
        }
        return null;
    }

    public Account getAccountbyUsername(String user) {
        String sql = "select * from HE140108_DUCVA_Account where Username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                return new Account(id, rs.getString(2), rs.getString(3), rs.getBoolean(4), 
                        rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), 
                        rs.getInt(9), rs.getBoolean(10), rs.getInt(11), rs.getString(12));
            }
        } catch (SQLException e) {
            status = "getDB that bai" + e.getMessage();
        }
        return null;
    }
    
    public HashMap<Integer, Account> getAccountFromDB() {
        String sql = "select * from HE140108_DUCVA_Account";
        HashMap<Integer, Account> hm = new HashMap<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                hm.put(id, new Account(id, rs.getString(2), rs.getString(3), rs.getBoolean(4), 
                        rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getInt(9), rs.getBoolean(10), rs.getInt(11), rs.getString(12)));
            }
        } catch (SQLException e) {
            status = "getDB that bai" + e.getMessage();
        }
        return hm;
    }
    
    public HashMap<Integer, String> getQuestionFromDB() {
        String sql = "select * from HE140108_DUCVA_Security_Question";
        HashMap<Integer, String> hm = new HashMap<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                hm.put(id, rs.getString(2));
            }
        } catch (SQLException e) {
            status = "getDB that bai" + e.getMessage();
        }
        return hm;
    }

    public void signUp(String user, String pass, boolean gender, String dob, String address, String email, String phone, int ques, String ans) {
        String sql = "insert into HE140108_DUCVA_Account values (?,?,?,?,?,?,?,0,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setBoolean(3, gender);
            ps.setString(4, dob);
            ps.setString(5, address);
            ps.setString(6, email);
            ps.setString(7, phone);
            ps.setBoolean(8, false);
            ps.setInt(9, ques);
            ps.setString(10, ans);
            ps.execute();
        } catch (SQLException e) {
            status = "getDB that bai" + e.getMessage();
        }
    }

    public void deleteProduct(int id) {
        String sql = "delete from HE140108_DUCVA_Product where Product_Id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            status = "delete that bai" + e.getMessage();
        }
    }

    public void insertProduct(String name, String img, float price, String infor, int categoryID, int discount, int quantity) {
        String sql = "INSERT INTO HE140108_DUCVA_Product VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, img);
            ps.setFloat(3, price);
            ps.setString(4, infor);
            ps.setInt(5, categoryID);
            ps.setInt(6, discount);
            ps.setInt(7, quantity);
            ps.execute();
        } catch (Exception e) {
            status = "insert that bai" + e.getMessage();
        }
    }

    public void updateProduct(String name, String img, float price, String infor, int categoryID, int discount, int quantity, int id) {
        String sql = "UPDATE HE140108_DUCVA_Product set Product_Name = ?, Product_Image = ?,"
                + " Product_Price = ?, Description = ?, Category =?, Discount = ?, Quantity = ?"
                + " where Product_Id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, img);
            ps.setFloat(3, price);
            ps.setString(4, infor);
            ps.setInt(5, categoryID);
            ps.setInt(6, discount);
            ps.setInt(7, quantity);
            ps.setInt(8, id);
            ps.execute();
        } catch (Exception e) {
            status = "getDB that bai" + e.getMessage();
        }
    }
    
    public void updateAccount(Boolean gender, String dob, String address, String email, String phone, String username) {
        String sql = "UPDATE HE140108_DUCVA_Account set Gender = ?, Dob = ?,"
                + "Address = ?, Email = ?, Phone = ?"
                + " where Username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, gender);
            ps.setString(2, dob);
            ps.setString(3, address);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, username);
            ps.execute();
        } catch (Exception e) {
            status = "getDB that bai" + e.getMessage();
        }
    }
    
    public void updateAccount(String user, String pass) {
        String sql = "UPDATE HE140108_DUCVA_Account set Password = ?"
                + " where Username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, user);
            ps.execute();
        } catch (Exception e) {
            status = "getDB that bai" + e.getMessage();
        }
    }
    
    public void updateAccount(String user, boolean isActive) {
        String sql = "UPDATE HE140108_DUCVA_Account set Active = ?"
                + " where Username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, isActive);
            ps.setString(2, user);
            ps.execute();
        } catch (Exception e) {
            status = "getDB that bai" + e.getMessage();
        }
    }
    
    public void insertAccount(String user, String pass, boolean gender, String dob, 
            String address, String email, String phone, int role, boolean active, 
            int quesId, String answer) {
        String sql = "INSERT INTO HE140108_DUCVA_Account VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setBoolean(3, gender);
            ps.setString(4, dob);
            ps.setString(5, address);
            ps.setString(6, email);
            ps.setString(7, phone);
            ps.setInt(8, role);
            ps.setBoolean(9, active);
            ps.setInt(10, quesId);
            ps.setString(11, answer);
            ps.execute();
        } catch (Exception e) {
            status = "insert that bai" + e.getMessage();
        }
    }
    
    public void deleteAccount(int id) {
        String sql = "delete from HE140108_DUCVA_Account where Account_ID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            status = "delete that bai" + e.getMessage();
        }
    }
    
    public void updateAccount(String user, String pass, boolean gender, String dob, 
            String address, String email, String phone, int role, boolean active, 
            int quesId, String answer) {
        String sql = "UPDATE HE140108_DUCVA_Account " +
                "SET [Password] = ?, " +
                "[Gender] = ?, [Dob] = ?, " +
                "[Address] = ?, [Email] = ?, " +
                "[Phone] = ?, [Role] = ?, " +
                "[Active] = ?, [QuestionID] = ?, " +
                "[Answer] = ? WHERE [Username] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setBoolean(2, gender);
            ps.setString(3, dob);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.setInt(7, role);
            ps.setBoolean(8, active);
            ps.setInt(9, quesId);
            ps.setString(10, answer);
            ps.setString(11, user);
            
            ps.execute();
        } catch (Exception e) {
            status = "getDB that bai" + e.getMessage();
        }
    }
    
    public Account getAccountbyID(int id) {
        String sql = "select * from HE140108_DUCVA_Account where Account_ID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(id, rs.getString(2), rs.getString(3), rs.getBoolean(4), 
                        rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), 
                        rs.getInt(9), rs.getBoolean(10), rs.getInt(11), rs.getString(12));
            }
        } catch (SQLException e) {
            status = "getDB that bai" + e.getMessage();
        }
        return null;
    }
    
    public void insertBillDetail(int accID, int productID, int quantity, float price) {
        String sql = "INSERT INTO HE140108_DUCVA_Bill_Detail VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accID);
            ps.setInt(2, productID);
            ps.setInt(3, quantity);
            ps.setFloat(4, price);
            ps.execute();
        } catch (Exception e) {
            status = "insert that bai" + e.getMessage();
        }
    }
    
    public List<BillDetail> getBillDetailbyAccID(int accID) {
        String sql = "select * from HE140108_DUCVA_Bill_Detail where Account_ID = ?";
        List<BillDetail> list = new Vector<BillDetail>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BillDetail(rs.getInt(1), accID, rs.getInt(3), rs.getInt(4), rs.getFloat(5)));
            }
        } catch (Exception e) {
            status = "insert that bai" + e.getMessage();
        }
        return list;
    }
    
    public void updateBillDetail(int quantity, int no) {
        String sql = "UPDATE HE140108_DUCVA_Bill_Detail "
                + "SET Quantity = ? WHERE [No.] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, no);
            ps.execute();
        } catch (Exception e) {
            status = "insert that bai" + e.getMessage();
        }
    }
    
    public BillDetail checkBillDetailExist(int accID, int productID, float price) {
        String sql = "SELECT * FROM HE140108_DUCVA_Bill_Detail"
                + "WHERE Account_ID = ? and Product_ID = ? and Price = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accID);
            ps.setInt(2, productID);
            ps.setFloat(3, price);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new BillDetail(rs.getInt(1), accID, productID, rs.getInt(4), price);
            }
        } catch (Exception e) {
            status = "insert that bai" + e.getMessage();
        }
        return null;
    }
    
    public void deleteBillDetail(int no) {
        String sql = "DELETE FROM HE140108_DUCVA_Bill_Detail WHERE [No.] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, no);
            ps.execute();
        } catch (Exception e) {
            status = "insert that bai" + e.getMessage();
        }
    }
}
