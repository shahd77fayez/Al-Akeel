<%@ page import="com.example.RestaurantDAO" %>
<%
String restaurantId = request.getParameter("id");
RestaurantDAO dao = new RestaurantDAO();
Restaurant restaurant = dao.getRestaurantById(restaurantId);
%>
<table>
    <tr>
        <th>Name</th>
        <td><%= restaurant.getName() %></td>
    </tr>
    <tr>
        <th>Address</th>
        <td><%= restaurant.getAddress() %></td>
    </tr>
    <tr>
        <th>Phone</th>
        <td><%= restaurant.getPhone() %></td>
    </tr>
    <tr>
        <th>Rating</th>
        <td><%= restaurant.getRating() %></td>
    </tr>
</table>