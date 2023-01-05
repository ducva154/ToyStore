<%-- 
    Document   : modify
    Created on : Mar 4, 2021, 9:23:00 AM
    Author     : ANHDUC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Map"%>
<%@page import="Entity.Category"%>
<%@page import="java.util.HashMap"%>
<%@page import="Entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Toy World</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="js/script.js"></script>
        <script src="https://kit.fontawesome.com/d9b045063b.js" crossorigin="anonymous"></script>
        <style>
            table, td{
                border: none;
            }
            table{
                padding-left: 10%;
            }
        </style>
    </head>
    <body>
        <div class="header">
            <div class="header-top">
                <ul class="header-phone">
                    <li><i class="fas fa-phone-alt"></i> Hotline: 0123 456 789 </li>
                </ul>
                <ul class="header-menu">
                    <c:if test="${sessionScope.account == null}">
                        <li><a href="SignupControl"><i class="fas fa-user-plus"></i> Sign up</a></li>
                        <li><a href="LoginControl"><i class="fas fa-user"></i> Log in</a></li>
                        </c:if>
                        <c:if test="${sessionScope.account != null}">
                        <li><a href="CartControl"><i class="fas fa-shopping-cart"></i> Shopping cart</a></li>
                        <li><a href="LogOut"><i class="fas fa-sign-out-alt"></i> Sign out</a></li>
                        <li>Hello <a class="name" href="ProfileControl">${sessionScope.account.username}</a></li>
                        </c:if>
                </ul>
            </div>
            <div class="header-bottom">
                <div class="logo">
                    <a href="HomeControl"><img src="img/logo.png"></a>
                </div>
                <div class="search-form">
                    <form action="SearchControl" method="post">
                        <input type="text" placeholder="Search..." name="search">
                        <input type="submit" value=" " >
                    </form>
                    <a href="#"><i class="fab fa-facebook"></i></a>
                    <a href="#"><i class="fab fa-twitch"></i></a>
                    <a href="#"><i class="fab fa-google-plus-square"></i></a>
                    <a href="#"><i class="fab fa-youtube-square"></i></a>
                </div>
            </div>
        </div>
        <div class="clear"></div>

        <div class="menu">
            <ul class="list-menu">
                <li><a href="HomeControl">Home</a></li>
                <li>
                    <a href="ShowProductControl">Show products</a>
                    <ul class="sub-menu">
                        <c:forEach items="${hmCategory}" var="o">
                            <li><a href="ShowProductByType?id=${o.key}">${o.value.categoryName}</a></li>
                            </c:forEach>
                    </ul>
                </li>
                <c:if test="${sessionScope.account.role == 1}">
                    <li><a href="ManagerControl">Manager Products</a></li>
                    <li><a href="ManagerAccount">Manager Accounts</a></li>
                    </c:if>  
            </ul>  
        </div>
        <div class="banner">
            <img alt="..." src="img/banner.jpg" height="500" width="100%">
        </div>
        <div class="clear"></div>
        <div class="main">
            <h2>${title}</h2>
            <%
                Product p = (Product) request.getAttribute("product");
                HashMap<Integer, Category> hmType = (HashMap<Integer, Category>) request.getAttribute("hmCategory");
                int id = p.getProductID();
                String name = p.getProductName();
                String img = p.getProductImage();
                float price = p.getProductPrice();
                String infor = p.getDescription();
                String typeid = String.valueOf(p.getCategoryID());
                int discount = p.getDiscount();
                int quantity = p.getQuantity();
            %>
            <form action='UpdateProduct' method='post'>
                <table>
                    <tr>
                        <td><label>ID</label></td>
                        <td><input type="text" name="id" value="<%=id%>" readonly required></td>
                    </tr>
                    <tr>
                        <td><label>Name</label></td>
                        <td><input type="text" name="name" value="<%=name%>" required></td>
                    </tr>
                    <tr>
                        <td><label>Image</label></td>
                        <td><input type="text" name="img" value="<%=img%>" required></td>
                    </tr>
                    <tr>
                        <td><label>Price</label></td>
                        <td><input type="text" name="price" value="<%=price%>" required></td>
                    </tr>
                    <tr>
                        <td><label>Description</label></td>
                        <td><textarea name="infor" rows="5" cols="30" style="width: 160px;" required><%=infor%></textarea></td>
                    </tr>
                    <tr>
                        <td><label>Product type</label></td>
                        <td>
                            <select name ="category" style="width: 165px;">
                                <%
                                    for (Map.Entry<Integer, Category> en : hmType.entrySet()) {
                                        String key = String.valueOf(en.getKey());
                                        Category val = en.getValue();%>
                                <option value="<%=key%>" <%=(key.equals(typeid) ? "selected" : "")%>><%=val.getCategoryName()%></option>
                                <%

                                    }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Discount</label></td>
                        <td><input type="text" name="discount" value="<%=discount%>" required></td>
                    </tr>
                    <tr>
                        <td><label>Quantity</label></td>
                        <td><input type="text" name="quantity" value="<%=quantity%>" required></td>
                    </tr>
                    <tr>
                        <td><input type='submit' value='Submit'></td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="clear"></div>
        <div class="footer">
            <div class="about-us">
                <h3>About Us</h3>
                <p>Nam libero tempore, cum soluta nobis est eligendi 
                    optio cumque nihil impedit quo minus id quod maxime 
                    placeat facere possimus.
                </p>
            </div>
            <div class="services">
                <h3>Customer Services</h3>
                <ul>
                    <li><a href="#">Shipping</a></li>
                    <li><a href="#">Terms & Conditions</a></li>
                    <li><a href="#">Faqs</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="#">Online Shopping</a></li>						 
                </ul>
            </div>
            <div class="address">
                <h3>Connect with us</h3>
                <p><i class="fas fa-address-card"> </i> 12K Street , 45 Building Road Viet Nam.</p>
                <p><i class="fas fa-phone-alt"> </i> +1234 758 839 , +1273 748 730</p>	
                <p><i class="fas fa-envelope"></i> <a href="mailto:info@example.com">info@example1.com</a></p>
            </div>
        </div>
    </body>
</html>
