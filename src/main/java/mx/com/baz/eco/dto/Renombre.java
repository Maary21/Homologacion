package mx.com.baz.eco.dto;


import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Renombre implements Serializable{
	
	private static final long serialVersionUID = 1;

	@SerializedName("T071_DAT_OPERATION")
	@JsonProperty("T071_DAT_OPERATION")

	private String FIFECHAOPERACION;	
	
	@SerializedName("T071_CEN_UPDATE")
	@JsonProperty("T071_CEN_UPDATE")
	private String FCINSTITUCION;
	
	@SerializedName("T071_USERUPD")
	@JsonProperty("T071_USERUPD")
	private String FCRASTREO;
	
	@SerializedName("T071_FLG_CREDEB")
	@JsonProperty("T071_FLG_CREDEB")
	private String FCSTATUS;
	
	@SerializedName("T071_ENT_ACCT")
	@JsonProperty("T071_ENT_ACCT")
	private String FITIPOPAGO;
	
	@SerializedName("T071_AMOUNT")
	@JsonProperty("T071_AMOUNT")
	private String FCNOM_ORD;
	
	@SerializedName("T071_OBSERVATIONS")
	@JsonProperty("T071_OBSERVATIONS")
	private String FCCUENTA_ORD;
	
	@SerializedName("T071_INTREF")
	@JsonProperty("T071_INTREF")
	private String FIFOLIO;
	
	@SerializedName("T071_CEN_ACCT")
	@JsonProperty("T071_CEN_ACCT")
	private String FCNOM_BEN;
	
	@SerializedName("T071_CODE")
	@JsonProperty("T071_CODE")
	private String FCCUENTA_BEN;
	
	@SerializedName("T071_COD_PRODUCT")
	@JsonProperty("T071_COD_PRODUCT")
	private String FIMONTO;
	
	@SerializedName("T071_FLG_ANN")
	@JsonProperty("T071_FLG_ANN")
	private String FCCONCEPTOPAGO;

	@Override
	public String toString() {
		return "Renombre [FIFECHAOPERACION=" + FIFECHAOPERACION + ", FCINSTITUCION=" + FCINSTITUCION + ", FCRASTREO="
				+ FCRASTREO + ", FCSTATUS=" + FCSTATUS + ", FITIPOPAGO=" + FITIPOPAGO + ", FCNOM_ORD=" + FCNOM_ORD
				+ ", FCCUENTA_ORD=" + FCCUENTA_ORD + ", FIFOLIO=" + FIFOLIO + ", FCNOM_BEN=" + FCNOM_BEN
				+ ", FCCUENTA_BEN=" + FCCUENTA_BEN + ", FIMONTO=" + FIMONTO + ", FCCONCEPTOPAGO=" + FCCONCEPTOPAGO
				+ "]";
	}
	
	
	

	
	

}
