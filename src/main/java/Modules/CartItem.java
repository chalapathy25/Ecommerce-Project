package Modules;

public class CartItem {
	    private int itemId;
	   
	    private String pName;
	    private int quantity;
	    private float price;
	    private float subTotal;
	    public CartItem() {
			// TODO Auto-generated constructor stub
		}
		public CartItem( int itemId, String pName, int quantity, float price, float subTotal) {
			super();
			this.itemId = itemId;
			//this.pId = pId;
			this.pName = pName;
			this.quantity = quantity;
			this.price = price;
			this.subTotal = subTotal;
		}
		public int getItemId() {
			return itemId;
		}
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
		
		public String getpName() {
			return pName;
		}
		public void setpName(String pName) {
			this.pName = pName;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public float getSubTotal() {
			return subTotal;
		}
		public void setSubTotal(float subTotal) {
			this.subTotal = subTotal;
		}
		@Override
		public String toString() {
			return "CartItem [itemId=" + itemId + ", pName=" + pName + ", quantity=" + quantity + ", price=" + price
					+ ", subTotal=" + subTotal + "]";
		}
	    

}
