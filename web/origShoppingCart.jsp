<%-- 
    Document   : origShoppingCart
    Created on : Apr 21, 2017, 4:45:31 PM
    Author     : Bookstore
--%>

<%@page import="shoppingcart.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@page import = "java.io.*, java.util.*, shoppingcart.ShoppingCart" %>
    <%ShoppingCart cart = (ShoppingCart)session.getAttribute("cart"); %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <a href ="http://localhost:8080/BookstoreWebsite/index.jsp"><img src="image/images/ksu (1).png" width = "300" height = "100" alt = "Kennesaw Logo"></a>
        <h1> Shopping Cart</h1>
        <%  String isbn;
            int index = 0;
            Book a = cart.getBook(index);  %>
        <table border="1">
            <thead>
                <tr>
                    <th>Book Cover</th>
                    <th>Book Title</th>
                    <th>Qty</th>
                    <th>Book Type</th>
                    <th>Price Per Book</th>
                    <th>Total Price</th>
                    <th>Update Qty</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><% isbn = a.getIsbn(); out.println("<img src='image/images/" + isbn +".jpg' width = '175' height = '275'"); %></td>
                    <td><% out.println(a.getBookName());%></td>
                    <td><center><% out.println(cart.getBookQuantity(index));%></center></td>
                    <td><% out.println(cart.getBookType(index));%></td>
                    <td><% out.println("$" + a.getNewPrice()); %></td>
                    <td><% out.println("$" + (a.getNewPrice() * cart.getBookQuantity(index))); %></td>
                    <td><form method="POST"><input type="text" name="newQty" value="" /><input style="display:none;" type="text" name="isbn" value="10" size="1" /></form><input type="submit" value="newQty" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
