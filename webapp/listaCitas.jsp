<%@page import="java.util.List"%>
<%@page import="com.citafacil.modelo.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>CitaFácil - Listado de Citas</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f6f9; }
        table { width: 100%; border-collapse: collapse; background: white; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: center; }
        th { background-color: #0056b3; color: white; }
        .btn-volver { display: inline-block; margin-top: 15px; padding: 10px 15px; background: #28a745; color: white; text-decoration: none; border-radius: 4px; }
    </style>
</head>
<body>
    <h2>Citas Registradas en el Sistema (Web)</h2>

    <table>
        <thead>
            <tr>
                <th>ID Cita</th>
                <th>ID Usuario</th>
                <th>ID Servicio</th>
                <th>ID Horario</th>
                <th>Estado</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Cita> citas = (List<Cita>) request.getAttribute("citas");
                if (citas != null && !citas.isEmpty()) {
                    for (Cita c : citas) {
            %>
            <tr>
                <td><%= c.getIdCita() %></td>
                <td><%= c.getIdUsuario() %></td>
                <td><%= c.getIdServicio() %></td>
                <td><%= c.getIdHorario() %></td>
                <td><%= c.getEstado() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">No hay citas registradas en la base de datos.</td>
            </tr>
            <% } %>
        </tbody>
    </table>

    <a class="btn-volver" href="index.html">Registrar otra cita</a>
</body>
</html>