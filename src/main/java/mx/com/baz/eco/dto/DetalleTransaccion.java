package mx.com.baz.eco.dto;

public class DetalleTransaccion {
	
	String FICONSDETA;
	String FITIPOREG;
	String FCDATODETA;
	
	public DetalleTransaccion(String FICONSDETA, String FITIPOREG, String FCDATODETA) {
		
		this.FICONSDETA = FICONSDETA;
		this.FITIPOREG = FITIPOREG;
		this.FCDATODETA = FCDATODETA;
	}

	public String getFICONSDETA() {
		return FICONSDETA;
	}

	public void setFICONSDETA(String fICONSDETA) {
		FICONSDETA = fICONSDETA;
	}

	public String getFITIPOREG() {
		return FITIPOREG;
	}

	public void setFITIPOREG(String fITIPOREG) {
		FITIPOREG = fITIPOREG;
	}

	public String getFCDATODETA() {
		return FCDATODETA;
	}

	public void setFCDATODETA(String fCDATODETA) {
		FCDATODETA = fCDATODETA;
	}
	
}
