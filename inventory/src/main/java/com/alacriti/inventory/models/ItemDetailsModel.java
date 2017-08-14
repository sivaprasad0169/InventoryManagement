package com.alacriti.inventory.models;

public class ItemDetailsModel {

	
	
		public int  updateId,itemId,updatedQuantity,availableQuantity,operationId;
		public String updatedDate,updatedBy,operationType;
		
		
		public ItemDetailsModel()
		{
			
		}

		public ItemDetailsModel(int updateId, int itemId,
				int updatedQuantity, int availableQuantity,
				String updatedDate, String updatedBy, int operationId,
				String operationType) {
			super();
			this.updateId = updateId;
			this.itemId = itemId;
			this.updatedQuantity = updatedQuantity;
			this.availableQuantity = availableQuantity;
			this.updatedDate = updatedDate;
			this.updatedBy = updatedBy;
			this.operationId = operationId;
			this.operationType = operationType;
		}

		public int getUpdateId() {
			return updateId;
		}

		public void setUpdateId(int updateId) {
			this.updateId = updateId;
		}

		public int getItemId() {
			return itemId;
		}

		public void setItemId(int itemId) {
			this.itemId = itemId;
		}

		public int getUpdatedQuantity() {
			return updatedQuantity;
		}

		public void setUpdatedQuantity(int updatedQuantity) {
			this.updatedQuantity = updatedQuantity;
		}

		public int getAvailableQuantity() {
			return availableQuantity;
		}

		public void setAvailableQuantity(int availableQuantity) {
			this.availableQuantity = availableQuantity;
		}

		public int getOperationId() {
			return operationId;
		}

		public void setOperationId(int operationId) {
			this.operationId = operationId;
		}

		public String getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(String updatedDate) {
			this.updatedDate = updatedDate;
		}

		public String getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}

		public String getOperationType() {
			return operationType;
		}

		public void setOperationType(String operationType) {
			this.operationType = operationType;
		}

		
}
