
package tiendita.com.tienda.pojo;

public class Coupons {
	private java.lang.String code;
	private String amount;
	private String discountType;
	public java.lang.String getCode() {
		return code;
	}
	private java.lang.Object[] email_restrictions;
	public java.lang.Object[] getEmail_restrictions() {
		return email_restrictions;
	}
	private java.lang.Integer id;
 	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.Integer getId() {
		return id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDiscountType() {
		this.discountType = "percent";
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmount() {
		return amount;
	}
}