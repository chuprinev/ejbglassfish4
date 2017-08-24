<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
</head>
<body>

<form action="add" method="post">
    <label for="name">Введите имя:
        <input type="text" id="name" value="${user.name}" name="name" />
    </label>  <br />
    <label for="last-name">Введите фамилию:
        <input type="text" id="last-name" value="${user.value}" name="lastName" />
    </label>  <br />
    <input type="hidden" name="id" value="${user.id}" />
    <input type="submit" value="Сохранить" />
</form>

</body>
</html>