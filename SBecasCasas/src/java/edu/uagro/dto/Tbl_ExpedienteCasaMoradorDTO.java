package edu.uagro.dto;

public class Tbl_ExpedienteCasaMoradorDTO {
    private int id;
    private int tbl_expedientecasaIdDTO;
    private String matricula;
    private String nombre;//
    private String apellidoPat;
    private String apellidoMat;
    private String sexo;
    private String uAcademica;
    private int grado;
    private String turno;
    private double promedio;
    private int edad;
    private String municipio;
    private String region;
    private String planEstudio;
    private int hablaLenguaIndigena;
    private int cat_lenguaIndigena;//
    private String foto;
    private int status;
    private String observacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHablaLenguaIndigena() {
        return hablaLenguaIndigena;
    }

    public void setHablaLenguaIndigena(int hablaLenguaIndigena) {
        this.hablaLenguaIndigena = hablaLenguaIndigena;
    }

    public int getCat_lenguaIndigena() {
        return cat_lenguaIndigena;
    }

    public void setCat_lenguaIndigena(int cat_lenguaIndigena) {
        this.cat_lenguaIndigena = cat_lenguaIndigena;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTbl_expedientecasaIdDTO() {
        return tbl_expedientecasaIdDTO;
    }

    public void setTbl_expedientecasaIdDTO(int tbl_expedientecasaIdDTO) {
        this.tbl_expedientecasaIdDTO = tbl_expedientecasaIdDTO;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getuAcademica() {
        return uAcademica;
    }

    public void setuAcademica(String uAcademica) {
        this.uAcademica = uAcademica;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPlanEstudio() {
        return planEstudio;
    }

    public void setPlanEstudio(String planEstudio) {
        this.planEstudio = planEstudio;
    }



    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
}
