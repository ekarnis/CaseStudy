package CaseStudy;

import java.sql.Date;

public class Store {
	String storeId;
	String locationId;
	String storeName;
	String phoneNumber;
	String managerId;
	Date openTime;
	Date closeTime;
	
	public Store() {
		super();
	}
	
	public Store(String storeId, String locationId, String storeName, String phoneNumber, String managerId, Date openTime,
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
	
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
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
