package com.mycompany.bancoabc;

class Persona {

    private String nombre;
    private String cedula;
    private String cuenta;

    public Persona(String nombre, String cedula, String cuenta) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public void info() //método sin parámetros
    {
        System.out.println("\n\t\t===RESUMEN DE LA CUENTA==="); 
        System.out.println("\tUsuario:           " + getNombre());
        System.out.println("\tIdentificación:    " + getCedula());
    }

}
