<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.library.Book" %>
<html>
<head>
    <title>Books</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; }
        th { background-color: #f4f4f4; }
        .btn { padding: 6px 10px; border: 1px solid #333; text-decoration: none; }
    </style>
</head>
<body>
<h2>Book List</h2>

<a href="<%= request.getContextPath() %>/books/new" class="btn">Add New Book</a>
<br/><br/>

<%
    List<Book> books = (List<Book>) request.getAttribute("books");
%>

<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>ISBN</th>
        <th>Author</th>
        <th>Price</th>
        <th>Year</th>
    </tr>
    <% if (books != null) {
           for (Book b : books) { %>
        <tr>
            <td><%= b.getId() %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getIsbn() %></td>
            <td><%= b.getAuthor() != null ? b.getAuthor().getName() : "" %></td>
            <td><%= b.getPrice() %></td>
            <td><%= b.getPublishedYear() %></td>
        </tr>
    <%   }
       } %>
</table>
</body>
</html>

