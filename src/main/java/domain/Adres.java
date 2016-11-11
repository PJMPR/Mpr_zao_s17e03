package domain;

public class Adres {
	
	
	private String ulica;
	private String miasto;
	private String kraj;
	private int nrdomu;
	private String nrmieszk;
	private int kodpoczt;
	
	
	public int getKodpoczt() {
		return kodpoczt;
	}
	public void setKodpoczt(int kodpoczt) {
		this.kodpoczt = kodpoczt;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getMiasto() {
		return miasto;
	}
	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}
	public String getKraj() {
		return kraj;
	}
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	public int getNrdomu() {
		return nrdomu;
	}
	public void setNrdomu(int nrdomu) {
		this.nrdomu = nrdomu;
	}
	public String getNrmieszk() {
		return nrmieszk;
	}
	public void setNrmieszk(String nrmieszk) {
		this.nrmieszk = nrmieszk;
	}
	
}
