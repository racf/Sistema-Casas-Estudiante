package edu.uagro.controlador.casas;

import edu.uagro.bo.Cat_ArchivosBO;
import edu.uagro.bo.Tbl_ArchivosBO;
import edu.uagro.bo.Tbl_ExpedienteCasaBO;
import edu.uagro.dto.Cat_ArchivosDTO;
import edu.uagro.dto.Tbl_ArchivosDTO;
import edu.uagro.dto.Tbl_ExpedienteCasaDTO;
import edu.uagro.dto.Tbl_ExpedienteCasaMoradorDTO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author magic
 */
@ManagedBean(name = "casas_verDetalleContrato")
@ViewScoped
public class VerDetalleContrato {

    private Tbl_ExpedienteCasaDTO expediente;
    private ArrayList<Tbl_ExpedienteCasaMoradorDTO> moradores;
    private Tbl_ExpedienteCasaMoradorDTO morador;
    private ArrayList<Cat_ArchivosDTO> cat_archivos;
    private ArrayList<Tbl_ArchivosDTO> archivos;
    private Tbl_ArchivosDTO archivo;
    private File directorio;
    private Part part;

    public VerDetalleContrato() {
        Object expedienteID = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("expedienteID");
        if (expedienteID != null) {
            String aux = String.valueOf(expedienteID);
            expediente = new Tbl_ExpedienteCasaDTO();
            expediente.setId(Integer.parseInt(aux));
            expediente = new Tbl_ExpedienteCasaBO().obtenerExpediente(expediente);
            // get moradores if any
            cat_archivos = new Cat_ArchivosBO().obtenerCatArchivos();
            archivo = new Tbl_ArchivosDTO();
            archivo.setTbl_expedientecasaIdDTO(expediente.getId());
            archivos = new ArrayList(new Tbl_ArchivosBO().obtenerArchivos(expediente.getId()));
            String string = this.getClass().getClassLoader().getResource("").getPath();

            // ./SBecasCasas/build/web/WEB-INF/classes
            Path path = Paths.get(string);

            // ./SBecasCasas/build/web
            path = path.getParent().getParent();

            // ./SBecasCasas/build/web/app/Casas_Estudiantes
            path = Paths.get(path.toString(), "/app", "/Casas_Estudiantes");
            directorio = new File(path.toString() + "/fotos/" + expediente.getTbl_casaestudianteDTO().getNombre().replace(" ", "_") + "/Expediente_" + expediente.getId());
            if (!directorio.exists()) {
                directorio.mkdirs();
            }
        }
    }

    //<editor-fold defaultstate="collapsed" desc="setters and getters">
    public Tbl_ExpedienteCasaDTO getExpediente() {
        return expediente;
    }

    public void setExpediente(Tbl_ExpedienteCasaDTO expediente) {
        this.expediente = expediente;
    }

    public ArrayList<Tbl_ExpedienteCasaMoradorDTO> getMoradores() {
        return moradores;
    }

    public void setMoradores(ArrayList<Tbl_ExpedienteCasaMoradorDTO> moradores) {
        this.moradores = moradores;
    }

    public Tbl_ExpedienteCasaMoradorDTO getMorador() {
        return morador;
    }

    public void setMorador(Tbl_ExpedienteCasaMoradorDTO morador) {
        this.morador = morador;
    }

    public ArrayList<Cat_ArchivosDTO> getCat_archivos() {
        return cat_archivos;
    }

    public void setCat_archivos(ArrayList<Cat_ArchivosDTO> cat_archivos) {
        this.cat_archivos = cat_archivos;
    }

    public ArrayList<Tbl_ArchivosDTO> getArchivos() {
        return archivos;
    }

    public void setArchivos(ArrayList<Tbl_ArchivosDTO> archivos) {
        this.archivos = archivos;
    }

    public Tbl_ArchivosDTO getArchivo() {
        return archivo;
    }

    public void setArchivo(Tbl_ArchivosDTO archivo) {
        this.archivo = archivo;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
    //</editor-fold>

    public String subirFoto() {
        if (part == null) {
            return "./Ver_Detalle_Contrato.xhtml?faces-redirect=true";
        }
        String mimeType = "";
        mimeType = FacesContext.getCurrentInstance().getExternalContext().getMimeType(part.getSubmittedFileName());
        System.out.println("mimeType = " + mimeType);
        if (mimeType.startsWith("image/")) {
            System.out.println("its an image");
            // It's an image.
            try {
                InputStream is = part.getInputStream();
                String submittedFileName = part.getSubmittedFileName();
                File file = new File(directorio + File.separator + submittedFileName);
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                OutputStream os = new FileOutputStream(file);
                IOUtils.copy(is, os);
                os.close();
                is.close();
                String[] aux = submittedFileName.split(Pattern.quote("."));
                String ext = aux[aux.length - 1];
                archivo.setExtencion(ext);
                archivo.setNombre(submittedFileName);
                archivo.setUrl(directorio + File.separator + submittedFileName);
                int id = new Tbl_ArchivosBO().insertar(archivo);
                archivo.setId(id);
            } catch (IOException ex) {
                Logger.getLogger(VerDetalleContrato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "./Ver_Detalle_Contrato.xhtml?faces-redirect=true";
    }

    public void descargarMapa() {
//        try {
//            OutputStream output;
//            InputStream input = new FileInputStream(new File(partPath));
//            FacesContext fc = FacesContext.getCurrentInstance();
//            ExternalContext ec = fc.getExternalContext();
//            ec.responseReset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
//            ec.setResponseContentType("ExternalContext#getMimeType()"); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ExternalContext#getMimeType() for auto-detection based on filename.
//            ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + partArchivo + "\""); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.
//            output = ec.getResponseOutputStream();
//            IOUtils.copy(input, output);
//            input.close();
//            output.close();
//            fc.responseComplete(); // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
//        } catch (IOException ex) {
//            Logger.getLogger(AgregarFCIIEMS.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
