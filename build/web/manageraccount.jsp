

<%@page import="Entity.Account"%>
<%@page import="Entity.Category"%>
<%@page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Map"%>
<%@page import="Entity.Product"%>
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
            .button-add{
                text-decoration: none;
                border: 1px solid black;
                border-radius: 5px;
                background-color: greenyellow;
                padding: 10px;
                margin: 5%;
            }
            .manage-product{
                padding: 0;
                margin: 2% 5% 5% 5%;
                width: 80%;
            }
            .manage-product img{
                height: 100px;
                width: 100px;
            }
            table, th, td{
                border-collapse: collapse;
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
            <h2>Manage Product</h2>
            <div class="tab-contents tab-contents-1">
                <a class="button-add" href="InsertAccount">Add new account</a>
                <table class="manage-product">
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Gender</th>
                        <th>Date of birth</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Role</th>
                        <th>Active</th>
                        <th>Security question</th>
                        <th>Answer</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                    <%
                        HashMap<Integer, Account> hmAccount = (HashMap<Integer, Account>) request.getAttribute("hmAccount");
                        HashMap<Integer, String> hmQuestion = (HashMap<Integer, String>) request.getAttribute("hmQuestion");
                        HashMap<Integer, Category> hmCategory = (HashMap<Integer, Category>) request.getAttribute("hmCategory");
                        for (Map.Entry<Integer, Account> en : hmAccount.entrySet()) {
                            Integer key = en.getKey();
                            Account val = en.getValue();
                            int quesID = val.getQuestion();
                            String question = hmQuestion.get(quesID);
                            out.println("<tr>");
                            String gender = val.isGender()?"Male":"Female";
                            String role = val.getRole()==1?"Admin":"User";
                            out.println(val.outTable(gender, role, question));%>
                            <td><a href="UpdateAccount?id=<%=key%>"><i class="fas fa-edit"></i></a></td>    
                            <td><a href="DeleteAccount?id=<%=key%>"><i class="fas fa-trash-alt"></i></a></td>
                            <%out.println("</tr>");
                        }
                    %>
                </table>
            </div>
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
