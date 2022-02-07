package Model;

public class Patient {
	private String Telephone;
	private String mutuelle;
	private String SecuriteSocial;




	public String getMutuelle() {
		return this.mutuelle;
		}
	public void setMutuelle(String mutuelle) {
		this.mutuelle = mutuelle;
		}

	public void setString(String SecuriteSocial) {
		this.SecuriteSocial = SecuriteSocial;
		}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getSecuriteSocial() {
		return SecuriteSocial;
	}
	public void setSecuriteSocial(String securiteSocial) {
		SecuriteSocial = securiteSocial;
	}
	

}
