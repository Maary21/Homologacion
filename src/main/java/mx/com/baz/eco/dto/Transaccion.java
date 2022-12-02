package mx.com.baz.eco.dto;;

public class Transaccion {
	
	String FIPAISID;
	String FICANALID;
	String FINOTIENDA;
	String FITRANNO;
	String FITRANTIPO;
	String FICONSECTIPO;
	String FDTRANSFECHR;
	String FCTRANWS;
	String FCTRANUSR;
	String FITRANNOREG;
	
	public Transaccion(String FIPAISID, String FICANALID, String FINOTIENDA, String FITRANNO, String FITRANTIPO,
			String FICONSECTIPO, String FDTRANSFECHR, String FCTRANWS, String FCTRANUSR, String FITRANNOREG) {
		this.FIPAISID = FIPAISID;
		this.FICANALID = FICANALID;
		this.FINOTIENDA = FINOTIENDA;
		this.FITRANNO = FITRANNO;
		this.FITRANTIPO = FITRANTIPO;
		this.FICONSECTIPO = FICONSECTIPO; 
		this.FDTRANSFECHR = FDTRANSFECHR;
		this.FCTRANWS = FCTRANWS;
		this.FCTRANUSR = FCTRANUSR;
		this.FITRANNOREG = FITRANNOREG;	
	}

	public String getFIPAISID() {
		return FIPAISID;
	}

	public void setFIPAISID(String fIPAISID) {
		FIPAISID = fIPAISID;
	}

	public String getFICANALID() {
		return FICANALID;
	}

	public void setFICANALID(String fICANALID) {
		FICANALID = fICANALID;
	}

	public String getFINOTIENDA() {
		return FINOTIENDA;
	}

	public void setFINOTIENDA(String fINOTIENDA) {
		FINOTIENDA = fINOTIENDA;
	}

	public String getFITRANNO() {
		return FITRANNO;
	}

	public void setFITRANNO(String fITRANNO) {
		FITRANNO = fITRANNO;
	}

	public String getFITRANTIPO() {
		return FITRANTIPO;
	}

	public void setFITRANTIPO(String fITRANTIPO) {
		FITRANTIPO = fITRANTIPO;
	}

	public String getFICONSECTIPO() {
		return FICONSECTIPO;
	}

	public void setFICONSECTIPO(String fICONSECTIPO) {
		FICONSECTIPO = fICONSECTIPO;
	}

	public String getFDTRANSFECHR() {
		return FDTRANSFECHR;
	}

	public void setFDTRANSFECHR(String fDTRANSFECHR) {
		FDTRANSFECHR = fDTRANSFECHR;
	}

	public String getFCTRANWS() {
		return FCTRANWS;
	}

	public void setFCTRANWS(String fCTRANWS) {
		FCTRANWS = fCTRANWS;
	}

	public String getFCTRANUSR() {
		return FCTRANUSR;
	}

	public void setFCTRANUSR(String fCTRANUSR) {
		FCTRANUSR = fCTRANUSR;
	}

	public String getFITRANNOREG() {
		return FITRANNOREG;
	}

	public void setFITRANNOREG(String fITRANNOREG) {
		FITRANNOREG = fITRANNOREG;
	}	

}
