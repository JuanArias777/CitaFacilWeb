package com.citafacil.modelo;

public class Cita {
    private int idCita;
    private int idUsuario;
    private int idServicio;
    private int idHorario;
    private String estado;

    public Cita() {}

    public Cita(int idUsuario, int idServicio, int idHorario, String estado) {
        this.idUsuario = idUsuario;
        this.idServicio = idServicio;
        this.idHorario = idHorario;
        this.estado = estado;
    }

    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdServicio() { return idServicio; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }

    public int getIdHorario() { return idHorario; }
    public void setIdHorario(int idHorario) { this.idHorario = idHorario; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Cita [ID=" + idCita + ", Usuario=" + idUsuario + ", Servicio=" + idServicio + 
               ", Horario=" + idHorario + ", Estado=" + estado + "]";
    }
}