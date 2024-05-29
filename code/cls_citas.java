package code;

public class cls_citas {
    private String idStr;
    private String fechaStr;
    private String horaStr;
    private String detInformacion;
    public cls_citas(String idStr, String fechaStr, String horaStr, String detInformacion) {
        this.idStr = idStr;
        this.fechaStr = fechaStr;
        this.horaStr = horaStr;
        this.detInformacion = detInformacion;
    }
    public String getIdStr() {
        return idStr;
    }
    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }
    public String getFechaStr() {
        return fechaStr;
    }
    public void setFechaStr(String fechaStr) {
        this.fechaStr = fechaStr;
    }
    public String getHoraStr() {
        return horaStr;
    }
    public void setHoraStr(String horaStr) {
        this.horaStr = horaStr;
    }
    public String getDetInformacion() {
        return detInformacion;
    }
    public void setDetInformacion(String detInformacion) {
        this.detInformacion = detInformacion;
    }

    
}
