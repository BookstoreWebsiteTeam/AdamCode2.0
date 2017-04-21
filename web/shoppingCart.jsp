<%-- 
    Document   : index
    Created on : Apr 14, 2017, 1:54:47 PM
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
        <%  int index = 0;
            int bookType;
            String isbn;
            Book a;%>
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
                <%for(int i = 0; i < cart.getNumItemsInCart(); i++) {
                    a = cart.getBook(i);
                    isbn = a.getIsbn();
                    bookType = cart.getBookType(index);
                    out.println("<tr>");
                    out.println("<td><img src='image/images/" + isbn + ".jpg' width = '175' height = '275' </td>");
                    out.println("<td>" + cart.getBookQuantity(index) + "</td>");
                    switch(bookType) {
                        case 1:
                            out.println("<td><center> New </center><td>");
                            out.println("<td>$" + a.getNewPrice() + "</td>");
                            out.println("<td>$" + (a.getNewPrice() * cart.getBookQuantity(index)) + "</td>");
                        case 2:
                            out.println("<td><center> Used </center><td>");
                            out.println("<td>$" + a.getUsedPrice() + "</td>");
                            out.println("<td>$" + (a.getUsedPrice() * cart.getBookQuantity(index)) + "</td>");
                        case 3:
                            out.println("<td><center> Rental </center><td>");
                            out.println("<td>$" + a.getRentalPrice() + "</td>");
                            out.println("<td>$" + (a.getRentalPrice() * cart.getBookQuantity(index)) + "</td>");
                        case 4:
                            out.println("<td><center> Ebook </center><td>");
                            out.println("<td>$" + a.getEbookPrice() + "</td>");
                            out.println("<td>$" + (a.getEbookPrice() * cart.getBookQuantity(index)) + "</td>");
                    }
                    out.println("");
                }
                    %>
                <tr>
                    <td><% isbn = a.getIsbn(); out.println("<img src='image/images/" + isbn +".jpg' width = '175' height = '275'"); %></td>
                    <td><% out.println(a.getBookName());%></td>
                    <td><% out.println(cart.getBookQuantity(index));%></td>
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
