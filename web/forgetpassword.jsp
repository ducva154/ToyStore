<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            .login table{
                padding: 10px;
                margin: auto;
                border: 1px solid;
                margin-bottom: 10px;
            }
            .login tr, td{
                font-size: 20px;
            }
            .login td{
                border: none;
                text-align: left;
            }
            .login input[type="submit"] {
                border-radius: 5px;
                color: white;
                background-color: red;
            }
            .mess{
                color: red;
                text-align: center;
            }
            #form-button{
                text-align: center;
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
            </ul>  
        </div>
        <div class="banner">
            <img alt="..." src="img/banner.jpg" height="500" width="100%">
        </div>
        <div class="clear"></div>
        <h2>${title}</h2>
        <div class="login">            
            <form  action="ForgetPassword" method="post">
                <table>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" value="" required></td>
                    </tr>
                    <tr>
                        <td>Security question:</td>
                        <td>
                            <select name ="question" style="width: 165px;">
                                <%
                                    HashMap<Integer, String> hmQuestion = (HashMap<Integer, String>)request.getAttribute("hmQuestion");
                                    for (Map.Entry<Integer, String> en : hmQuestion.entrySet()) {
                                        String key = String.valueOf(en.getKey());
                                        String val = en.getValue();%>
                                <option value="<%=key%>"><%=val%></option>
                                <%
                                    }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Answer:</td><td><input type="text" name="answer" value="" required></td>
                    </tr>
                    <tr>
                        <td>New password:</td>
                        <td><input type="password" name="password" value="" required></td>
                    </tr>
                    <tr>
                        <td>Confirm new password:</td>
                        <td><input type="password" name="confirmpass" value="" required></td>
                    </tr>
                    <tr>
                        <td id="form-button" colspan="2"><input type="submit" value="submit"> </td>
                    </tr>
                </table>   
            </form>
            <p class="mess">${message}</p>
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
