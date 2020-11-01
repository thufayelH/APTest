package com.ap.datamodel;

public class ProductData {

	private String productName;
	private String quantity;
	private String size;
	private String color;
	
	public String getProductName() {
		return productName;

	}
	public void setProductName(String productName) {//Getting from excel
		this.productName=productName;
	}
	public String getQuantity() {//setting it on the website
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public int hashCode() {
	final int prime = 31;//setting maximum limit qty to 31
	int result = 1;//minimum qty needs to be 1
	//Using conditional Operator
	result = prime * result + ((color ==null)? 0 : color.hashCode());
	result = prime * result + ((productName == null)? 0 : productName.hashCode());
	result = prime * result + ((quantity == null)? 0 : quantity.hashCode());
	result = prime * result + ((size == null)? 0 : size.hashCode());
	return result;
	
	}
	@Override
	 public boolean equals(Object obj){
	  if(this == obj)
	   return true;
	  if(obj == null)
	   return false;
	  if(getClass() != obj.getClass())
	   return false;
	  ProductData other = (ProductData) obj;
	  if(color == null){
	   if(other.color !=null)
	    return false;
	  }else if(!color.equals(other.color))
	   return false;
	  if (productName == null){
	   if(other.productName != null)
	    return false;
	  }else if (!productName.equals(other.productName))
	    return false;
	   if (quantity == null){
	    if(other.quantity != null)
	     return false;
	    
	   }else if (!quantity.equals(other.quantity))
	    return false;
	   if (size == null){
	    if(other.size != null)
	     return false;  
	  }else if (!size.equals(other.size))
	   return false;
	   return true; 
	 }
	 @Override
	 //Converting all input to String returning it back to the console
	 public String toString(){
	  return "ProductData [productName=" + productName + ", quantity=" + quantity + ", size=" + size + ", color=" + color + "]";
	 }
	}
