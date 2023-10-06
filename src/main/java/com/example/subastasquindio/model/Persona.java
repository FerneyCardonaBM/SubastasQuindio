package com.example.subastasquindio.model;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private String telefono;
    //private Usuario usuario;
    //Eso es una prueba

    public Persona() {
    }

    // Getters y Setters para los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   // public Usuario getUsuario() {
    //    return usuario;
  //  }

  //  public void setUsuario(Usuario usuario) {
      //  this.usuario = usuario;
 //   }


}

