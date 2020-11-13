import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityIdentifier {
    //Mapping dos componentes da resposta
    @SerializedName("idRegiao")
    @Expose
    private int idRegiao;

    @SerializedName("idAreaAviso")
    @Expose
    private String idAreaAviso;

    @SerializedName("idConcelho")
    @Expose
    private String idConcelho;

    @SerializedName("globalIdLocal")
    @Expose
    private String globalIdLocal;

    @SerializedName("latitude")
    @Expose
    private String latitude;

    @SerializedName("idDistrito")
    @Expose
    private String idDistrito;

    @SerializedName("local")
    @Expose
    private String local;

    @SerializedName("longitude")
    @Expose
    private String longitude;

    public int getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(int idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getIdAreaAviso() {
        return idAreaAviso;
    }

    public void setIdAreaAviso(String idAreaAviso) {
        this.idAreaAviso = idAreaAviso;
    }

    public String getIdConcelho() {
        return idConcelho;
    }

    public void setIdConcelho(String idConcelho) {
        this.idConcelho = idConcelho;
    }

    public String getGlobalIdLocal() {
        return globalIdLocal;
    }

    public void setGlobalIdLocal(String globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(String idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
