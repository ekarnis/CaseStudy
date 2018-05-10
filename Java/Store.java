package CaseStudy;

import java.sql.Date;

public class Store {
	int storeId;
	int locationId;
	String storeName;
	int phoneNumber;
	int managerId;
	Date openTime;
	Date closeTime;
	
	public Store() {
		super();
	}
	
	public Store(int storeId, int locationId, String storeName, int phoneNumber, int managerId, Date openTime,
			Date closeTime) {
		super();
		this.storeId = storeId;
		this.locationId = locationId;
		this.storeName = storeName;
		this.phoneNumber = phoneNumber;
		this.managerId = managerId;
		this.openTime = openTime;
		this.closeTime = closeTime;
	}
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", locationId=" + locationId + ", storeName=" + storeName
				+ ", phoneNumber=" + phoneNumber + ", managerId=" + managerId + ", openTime=" + openTime
				+ ", closeTime=" + closeTime + "]";
	}

	
	
}
