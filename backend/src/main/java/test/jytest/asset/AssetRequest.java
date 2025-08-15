package test.jytest.asset;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.sql.Timestamp;

public class AssetRequest {

    private String assetId;
    private String assetType;
    private String assetCategory;
    private String brand;
    private String model;
    private String serialNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date purchaseDate;
    private String supplier;
    private String purchaseOrder;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date warrantyStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date warrantyEndDate;
    private String campus;
    private String locationRoom;
    private String department;
    private String custodianPerson;
    private String status;

    public AssetRequest() {
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAssetCategory() {
        return assetCategory;
    }

    public void setAssetCategory(String assetCategory) {
        this.assetCategory = assetCategory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(String purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Date getWarrantyStartDate() {
        return warrantyStartDate;
    }

    public void setWarrantyStartDate(Date warrantyStartDate) {
        this.warrantyStartDate = warrantyStartDate;
    }

    public Date getWarrantyEndDate() {
        return warrantyEndDate;
    }

    public void setWarrantyEndDate(Date warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getLocationRoom() {
        return locationRoom;
    }

    public void setLocationRoom(String locationRoom) {
        this.locationRoom = locationRoom;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCustodianPerson() {
        return custodianPerson;
    }

    public void setCustodianPerson(String custodianPerson) {
        this.custodianPerson = custodianPerson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
