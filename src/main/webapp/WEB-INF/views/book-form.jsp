<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.library.Author" %>
<html>
<head>
    <title>New Book</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        label { display: block; margin-top: 10px; }
        input, select { width: 300px; padding: 5px; }
        .error { color: red; margin-top: 10px; }
        .btn { padding: 6px 10px; border: 1px solid #333; text-decoration: none; }
    </style>
</head>
<body>
<h2>Add New Book</h2>

<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
    <div class="error"><%= errorMessage %></div>
<%
    }
    List<Author> authors = (List<Author>) request.getAttribute("authors");
%>

<form action="<%= request.getContextPath() %>/books/save" method="post">
    <label>Title:</label>
    <input type="text" name="title" required />

    <label>ISBN:</label>
    <input type="text" name="isbn" required />

    <label>Price:</label>
    <input type="number" step="0.01" name="price" />

    <label>Published Year:</label>
    <input type="number" name="publishedYear" />

    <label>Author:</label>
    <select name="author.id" required>
        <option value="">-- Select Author --</option>
        <% if (authors != null) {
               for (Author a : authors) { %>
            <option value="<%= a.getId() %>"><%= a.getName() %></option>
        <%     }
           } %>
    </select>

    <br/><br/>
    <button type="submit">Save</button>
    <a href="<%= request.getContextPath() %>/books/list" class="btn">Cancel</a>
</form>

</body>
</html>

