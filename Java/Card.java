package CaseStudy;

import java.sql.Date;

public class Card {
	
	int cardId;
	int userId;
	int cardNumber;
	Date expiryDate;
	int securityCode;
	
	public Card() {
		super();
	} 
	
	public Card(int cardId, int userId, int cardNumber, Date expiryDate, int securityCode) {
		super();
		this.cardId = cardId;
		this.userId = userId;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.securityCode = securityCode;
	}
	
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", userId=" + userId + ", cardNumber=" + cardNumber + ", expiryDate="
				+ expiryDate + ", securityCode=" + securityCode + "]";
	}
	
	
	

}
