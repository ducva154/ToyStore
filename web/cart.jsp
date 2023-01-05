<%@page import="Entity.Product"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="Entity.BillDetail"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            table, th, td{
                border-collapse: collapse;
            }
            table{
                width: 100%;
            }
        </style>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="https://kit.fontawesome.com/d9b045063b.js" crossorigin="anonymous"></script>
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
            <form action="" method="POST">
                <table>
                    <tr>
                        <th>SN</th>
                        <th>Product name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                        <th>Delete</th>
                    </tr>
                    <%
                        float total = 0;
                        List<BillDetail> listBillDetail = (List<BillDetail>) request.getAttribute("listBillDetail");
                        HashMap<Integer, Product> hmProduct = (HashMap<Integer, Product>) request.getAttribute("hmProduct");
                        for (BillDetail o : listBillDetail) {
                            total = total + o.getPrice() * o.getQuantity();
                            Product p = hmProduct.get(o.getProductID());
                            String productName = p.getProductName();%>
                    <tr>
                        <td style="text-align: center"><%=o.getNo()%></td>
                        <td><%=productName%></td>
                        <td style="text-align: center">                
                            <input type="number" name="quantity" value="<%=o.getQuantity()%>" min="1" max="<%=p.getQuantity()%>" style="width: 50px;"/>
                        </td>
                        <td style="text-align: right"><%=o.getPrice()%></td>
                        <td style="text-align: right"><%=o.getPrice() * o.getQuantity()%></td>
                        <td style="text-align: center"><a href="DeleteBillDetail?id=<%=o.getNo()%>"><i class="fas fa-trash-alt"></i></a></td>
                    </tr>     
                    <%}
                    %>
                    <tr>
                        <td> </td>
                        <td>Total</td>
                        <td> </td>
                        <td> </td>
                        <td style="text-align: right"><%=total%></td>
                        <td> </td>
                    </tr>
                </table>
                <hr>
                <div><label>Phone: </label><br/>
                    <input type="text" value="" name="phone" required/></div>
                <div><label>Address: </label><br/>
                    <input type="text" value="" name="address" required/></div>
                <div><label>Note: </label><br/>
                    <textarea name="note" cols="50" rows="7" /></textarea></div>
                <input type="submit" name="order" value="Order" />
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
    </div>
</body>
</html>
