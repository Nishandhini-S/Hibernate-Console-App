package in.kce.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "SERVICE_TICKET_TBL")
public class ServiceTicket {
	@Id
	@GeneratedValue(
	        strategy = GenerationType.SEQUENCE,
	        generator = "ticket_generator")
	@SequenceGenerator(
	        name = "ticket_generator",
	        sequenceName = "SERVICE_TICKET_SEQ",
	        allocationSize = 1)
	@Column(name = "TICKET_ID")
	private int ticketID;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private String customerID;

    @Column(name = "TECHNICIAN_ID")
    private String technicianID;

    @Column(name = "APPLIANCE_TYPE", nullable = false)
    private String applianceType;

    @Column(name = "PROBLEM_DESCRIPTION", nullable = false)
    private String problemDescription;

    @Column(name = "TICKET_DATE", nullable = false)
    private Date ticketDate;

    @Column(name = "SCHEDULED_VISIT_DATE")
    private Date scheduledVisitDate;

    @Column(name = "SCHEDULED_VISIT_SLOT")
    private String scheduledVisitSlot;

    @Column(name = "VISIT_OUTCOME")
    private String visitOutcome;

    @Column(name = "SERVICE_CHARGE")
    private BigDecimal serviceCharge;

    @Column(name = "STATUS", nullable = false)
    private String status;

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(String technicianID) {
        this.technicianID = technicianID;
    }

    public String getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(String applianceType) {
        this.applianceType = applianceType;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public Date getScheduledVisitDate() {
        return scheduledVisitDate;
    }

    public void setScheduledVisitDate(Date scheduledVisitDate) {
        this.scheduledVisitDate = scheduledVisitDate;
    }

    public String getScheduledVisitSlot() {
        return scheduledVisitSlot;
    }

    public void setScheduledVisitSlot(String scheduledVisitSlot) {
        this.scheduledVisitSlot = scheduledVisitSlot;
    }

    public String getVisitOutcome() {
        return visitOutcome;
    }

    public void setVisitOutcome(String visitOutcome) {
        this.visitOutcome = visitOutcome;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServiceTicket [ticketID=" + ticketID + ", customerID=" + customerID + ", technicianID=" + technicianID +
        ", status=" + status + "]";
    }
}
