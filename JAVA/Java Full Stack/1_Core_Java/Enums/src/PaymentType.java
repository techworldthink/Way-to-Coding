public enum PaymentType {
	DEBITCARD(5), CREDITCARD(0), CASH(10);
	
	int fee;
	
	PaymentType(int fee){
		this.fee = fee;
	}
	
	public int getFee(){
		return this.fee;
	}
}
