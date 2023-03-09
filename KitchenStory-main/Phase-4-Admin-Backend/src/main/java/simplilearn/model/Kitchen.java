package simplilearn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kitchen")
public class Kitchen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String item;
	private int price;
	private int quantity;
	private String url;
	private String formID;
	private String cartID;
		
	public Kitchen() {

	}

	public Kitchen(String item, int price, int quantity, String url, String formID, String cartID) {
		super();
		this.item = item;
		this.price = price;
		this.quantity = quantity;
		this.url = url;
		this.formID = formID;
		this.cartID = cartID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFormID() {
		return formID;
	}

	public void setFormID(String formID) {
		this.formID = formID;
	}

	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	@Override
	public String toString() {
		return "Kitchen [id=" + id + ", item=" + item + ", price=" + price + ", quantity=" + quantity + ", url=" + url
				+ ", formID=" + formID + ", cartID=" + cartID + "]";
	}
	
	
}
