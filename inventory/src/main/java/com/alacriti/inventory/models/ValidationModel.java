package com.alacriti.inventory.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ValidationModel {

	
		public String userFullName;
		public boolean isValid;
		public ValidationModel() {
			
		}
		public ValidationModel(String userFullName, boolean isValid) {
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
