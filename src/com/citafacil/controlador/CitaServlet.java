package com.citafacil.controlador;

import com.citafacil.dao.CitaDAO;
import com.citafacil.modelo.Cita;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CitaServlet")
public class CitaServlet extends HttpServlet {
    
    private CitaDAO citaDao = new CitaDAO();

    // Método GET para consultar y listar las citas en el JSP
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cita> listaCitas = citaDao.listarCitas();
        request.setAttribute("citas", listaCitas);
        request.getRequestDispatcher("listaCitas.jsp").forward(request, response);
    }

    // Método POST para recibir el formulario HTML e insertar en la BD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        int idServicio = Integer.parseInt(request.getParameter("idServicio"));
        int idHorario = Integer.parseInt(request.getParameter("idHorario"));
        String estado = request.getParameter("estado");

        Cita nuevaCita = new Cita(idUsuario, idServicio, idHorario, estado);
        citaDao.insertarCita(nuevaCita);

        // Redirige al método doGet para mostrar la tabla actualizada
        response.sendRedirect("CitaServlet");
    }
}