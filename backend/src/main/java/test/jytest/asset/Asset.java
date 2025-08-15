package test.jytest.asset;

import java.sql.Date;
import java.util.Objects;

public class Asset {
    private String assetId;
    private String assetType;
    private String assetCategory;
    private String brand;
    private String model;
    private String serialNumber;
    private Date purchaseDate;
    private String supplier;
    private String purchaseOrder;
    private Date warrantyStartDate;
    private Date warrantyEndDate;
    private String campus;
    private String locationRoom;
    private String department;
    private String custodianPerson;
    private String status;

    public Asset() {}

    public Asset(String assetId, String assetType, String assetCategory, String brand,
                 String model, String serialNumber, Date purchaseDate, String supplier, String purchaseOrder,
                 Date warrantyStartDate, Date warrantyEndDate, String campus, String locationRoom,
                 String department, String custodianPerson, String status)
    {
        this.assetId = assetId;
        this.assetType = assetType;
        this.assetCategory = assetCategory;
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.supplier = supplier;
        this.purchaseOrder = purchaseOrder;
        this.warrantyStartDate = warrantyStartDate;
        this.warrantyEndDate = warrantyEndDate;
        this.campus = campus;
        this.locationRoom = locationRoom;
        this.department = department;
        this.custodianPerson = custodianPerson;
        this.status = status;


    }

    public Asset(String assetType, String assetCategory, String brand,
                 String model, String serialNumber, Date purchaseDate, String supplier, String purchaseOrder,
                 Date warrantyStartDate, Date warrantyEndDate, String campus, String locationRoom,
                 String department, String custodianPerson, String status)
    {
        this.assetType = assetType;
        this.assetCategory = assetCategory;
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.purchaseDate = purchaseDate;
        this.supplier = supplier;
        this.purchaseOrder = purchaseOrder;
        this.warrantyStartDate = warrantyStartDate;
        this.warrantyEndDate = warrantyEndDate;
        this.campus = campus;
        this.locationRoom = locationRoom;
        this.department = department;
        this.custodianPerson = custodianPerson;
        this.status = status;


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

    public String getAssetCategory() {
        return assetCategory;
    }

    public void setAssetCategory(String assetCategory) {
        this.assetCategory = assetCategory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    @Override
    public String toString() {
        return "Asset{" +
                "assetId='" + assetId + '\'' +
                ", assetType='" + assetType + '\'' +
                ", assetCategory='" + assetCategory + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", supplier='" + supplier + '\'' +
                ", purchaseOrder='" + purchaseOrder + '\'' +
                ", warrantyStartDate=" + warrantyStartDate +
                ", warrantyEndDate=" + warrantyEndDate +
                ", campus='" + campus + '\'' +
                ", locationRoom='" + locationRoom + '\'' +
                ", department='" + department + '\'' +
                ", custodianPerson='" + custodianPerson + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return Objects.equals(assetId, asset.assetId) &&
                Objects.equals(assetType, asset.assetType) &&
                Objects.equals(assetCategory, asset.assetCategory) &&
                Objects.equals(brand, asset.brand) &&
                Objects.equals(model, asset.model) &&
                Objects.equals(serialNumber, asset.serialNumber) &&
                Objects.equals(purchaseDate, asset.purchaseDate) &&
                Objects.equals(supplier, asset.supplier) &&
                Objects.equals(purchaseOrder, asset.purchaseOrder) &&
                Objects.equals(warrantyStartDate, asset.warrantyStartDate) &&
                Objects.equals(warrantyEndDate, asset.warrantyEndDate) &&
                Objects.equals(campus, asset.campus) &&
                Objects.equals(locationRoom, asset.locationRoom) &&
                Objects.equals(department, asset.department) &&
                Objects.equals(custodianPerson, asset.custodianPerson) &&
                Objects.equals(status, asset.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetId, assetType, assetCategory, brand, model,
                serialNumber, purchaseDate, supplier, purchaseOrder, warrantyStartDate,
                warrantyEndDate, campus, locationRoom, department, custodianPerson, status);
    }
}