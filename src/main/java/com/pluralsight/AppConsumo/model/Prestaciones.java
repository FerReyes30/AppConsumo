package com.pluralsight.AppConsumo.model;



public class Prestaciones {

    private Long id;
    private String fecha;
    private String titulo;
    private String observacion;
    private String costo;
    private String statusPrestacion;

    private VehiculoPrestacion vehiculo;

    public Prestaciones(){

    }

    public Prestaciones(String fecha,
                        String titulo,
                        String observacion,
                        String costo,
                        String statusPrestacion,
                        VehiculoPrestacion vehiculo){

        this.fecha = fecha;
        this.titulo = titulo;
        this.observacion = observacion;
        this.costo = costo;
        this.statusPrestacion = statusPrestacion;
        this.vehiculo = vehiculo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public String getCosto() {
        return costo;
    }
    public void setCosto(String costo) {
        this.costo = costo;
    }
    public String getStatusPrestacion() {
        return statusPrestacion;
    }
    public void setStatusPrestacion(String statusPrestacion) {
        this.statusPrestacion = statusPrestacion;
    }
    public VehiculoPrestacion getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(VehiculoPrestacion vehiculo) {
        this.vehiculo = vehiculo;
    }


    @Override
    public String toString() {
        return "Prestaciones{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", titulo=" + titulo +
                ", observacion='" + observacion + '\'' +
                ", costo='" + costo + '\'' +
                ", statusPrestacion='" + statusPrestacion + '\'' +
                ", vehiculo='" + vehiculo + '\'' +
                '}';
    }
}
