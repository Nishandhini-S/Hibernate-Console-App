package in.kce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TECHNICIAN_TBL")
public class Technician {

    @Id
    @Column(name = "TECHNICIAN_ID")
    private String technicianID;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "SKILL_CATEGORY", nullable = false)
    private String skillCategory;

    @Column(name = "SERVICE_REGION", nullable = false)
    private String serviceRegion;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "STATUS", nullable = false)
    private String status;

    public String getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(String technicianID) {
        this.technicianID = technicianID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSkillCategory() {
        return skillCategory;
    }

    public void setSkillCategory(String skillCategory) {
        this.skillCategory = skillCategory;
    }

    public String getServiceRegion() {
        return serviceRegion;
    }

    public void setServiceRegion(String serviceRegion) {
        this.serviceRegion = serviceRegion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Technician [technicianID=" + technicianID + ", fullName=" + fullName + ", skillCategory=" + skillCategory +
        ", serviceRegion=" + serviceRegion +", status=" + status + "]";
    }
}
