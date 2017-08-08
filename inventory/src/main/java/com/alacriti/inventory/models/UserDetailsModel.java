package com.alacriti.inventory.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDetailsModel {

	
		String userFullName;
		boolean isValid;
		public UserDetailsModel() {
			
		}
		public UserDetailsModel(String userFullName, boolean isValid) {
			super();
			this.userFullName = userFullName;
			this.isValid = isValid;
		}
		public String getUserFullName() {
			return userFullName;
		}
		public void setUserFullName(String userFullName) {
			this.userFullName = userFullName;
		}
		public boolean getIsValid() {
			return isValid;
		}
		public void setIsValid(boolean isValid) {
			this.isValid = isValid;
		}
		
}
