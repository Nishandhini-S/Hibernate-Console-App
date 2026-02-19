package in.kce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSTOMER_TBL")
public class Customer {

    @Id
    @Column(name = "CUSTOMER_ID")
    private String customerID;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "ADDRESS_LINE", nullable = false)
    private String addressLine;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "PINCODE", nullable = false)
    private String pincode;

    @Column(name = "PRIMARY_PHONE", nullable = false)
    private String primaryPhone;

    @Column(name = "STATUS", nullable = false)
    private String status;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer [customerID=" + customerID + ", fullName=" + fullName + ", city=" + city +
        ", phone=" + primaryPhone + ", status=" + status + "]";
    }
}
