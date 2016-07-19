package edu.uagro.dto;

import java.util.Date;

public class Tbl_RepresentanteDTO {
    private String matricula;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String sexo;
    private String estadoCivil;
    private String fechaRegistro;
    private Date fechaNacimiento;
    private String curp;
    private String estadoNacimiento;
    private String municipioNacimiento;
    private String UAcademica;
    private int semestre;
    private int grado;
    private String turno;
    private double promedio; 
    private String telefono;
    private String email;
    private String clave;
    private int estado;
    private int tiporepresentanteId;
    Cat_TipoRepresentanteDTO tipoRepresentanteDTO = new Cat_TipoRepresentanteDTO();

    public Cat_TipoRepresentanteDTO getTipoRepresentanteDTO() {
        return tipoRepresentanteDTO;
    }

    public void setTipoRepresentanteDTO(Cat_TipoRepresentanteDTO tipoRepresentanteDTO) {
        this.tipoRepresentanteDTO = tipoRepresentanteDTO;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }        
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }      

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaNacimiento() {
        System.out.println("setting fechaNacimiento = " + fechaNacimiento);
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        System.out.println("setting fechaNacimiento = " + fechaNacimiento);
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getEstadoNacimiento() {
        return estadoNacimiento;
    }

    public void setEstadoNacimiento(String estadoNacimiento) {
        this.estadoNacimiento = estadoNacimiento;
    }

    public String getMunicipioNacimiento() {
        return municipioNacimiento;
    }

    public void setMunicipioNacimiento(String municipioNacimiento) {
        this.municipioNacimiento = municipioNacimiento;
    }
    
    public String getUAcademica() {
        return UAcademica;
    }

    public void setUAcademica(String UAcademica) {
        this.UAcademica = UAcademica;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getCat_tiporepresentanteIdDTO() {
        return tiporepresentanteId;
    }

    public void setCat_tiporepresentanteIdDTO(int cat_tiporepresentanteIdDTO) {
        this.tiporepresentanteId = cat_tiporepresentanteIdDTO;
    }
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tbl_RepresentanteDTO{" + "matricula=" + matricula + ", nombre=" + nombre + ", apellidoPat=" + apellidoPat + ", apellidoMat=" + apellidoMat + ", sexo=" + sexo + ", estadoCivil=" + estadoCivil + ", fechaRegistro=" + fechaRegistro + ", fechaNacimiento=" + fechaNacimiento + ", curp=" + curp + ", estadoNacimiento=" + estadoNacimiento + ", municipioNacimiento=" + municipioNacimiento + ", UAcademica=" + UAcademica + ", semestre=" + semestre + ", grado=" + grado + ", turno=" + turno + ", promedio=" + promedio + ", telefono=" + telefono + ", email=" + email + ", clave=" + clave + ", estado=" + estado + ", tiporepresentanteId=" + tiporepresentanteId + ", tipoRepresentanteDTO=" + tipoRepresentanteDTO + '}';
    }
     
}
