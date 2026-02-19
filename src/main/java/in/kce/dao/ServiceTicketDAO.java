package in.kce.dao;

import in.kce.entity.ServiceTicket;
import in.kce.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.math.BigDecimal;
import java.util.List;

public class ServiceTicketDAO {
    public int generateTicketID() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Integer maxId = session.createQuery( "select coalesce(max(t.ticketID),0) from ServiceTicket t",Integer.class).uniqueResult();
            return maxId + 1;
        }
    }
    public void insertTicket(ServiceTicket ticket) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public void updateAssignmentAndSchedule(int ticketID,String technicianID,java.sql.Date visitDate,String visitSlot,
     String newStatus) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ServiceTicket ticket = session.get(ServiceTicket.class, ticketID);
            if (ticket != null) {
                ticket.setTechnicianID(technicianID);
                ticket.setScheduledVisitDate(visitDate);
                ticket.setScheduledVisitSlot(visitSlot);
                ticket.setStatus(newStatus);
                session.update(ticket);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public void updateVisitOutcomeAndCharge(int ticketID,  String visitOutcome,BigDecimal serviceCharge,String newStatus) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ServiceTicket ticket = session.get(ServiceTicket.class, ticketID);
            if (ticket != null) {
                ticket.setVisitOutcome(visitOutcome);
                ticket.setServiceCharge(serviceCharge);
                ticket.setStatus(newStatus);
                session.update(ticket);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public ServiceTicket findTicket(int ticketID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ServiceTicket.class, ticketID);
        }
    }
    public List<ServiceTicket> findTicketsByCustomer(String customerID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.createQuery("from ServiceTicket where customerID = :custId",
        ServiceTicket.class).setParameter("custId", customerID).list();
        }
    }
    public List<ServiceTicket> findTicketsByTechnician(String technicianID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ServiceTicket where technicianID = :techId",
            ServiceTicket.class).setParameter("techId", technicianID).list();
        }
    }
    public List<ServiceTicket> findActiveTicketsForCustomer(String customerID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ServiceTicket where customerID = :custId " +
            "and status in ('OPEN','ASSIGNED','SCHEDULED','IN_PROGRESS','WAITING_PART')",
             ServiceTicket.class).setParameter("custId", customerID).list();
        }
    }
    public List<ServiceTicket> findActiveTicketsForTechnician(String technicianID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ServiceTicket where technicianID = :techId " +
            "and status in ('OPEN','ASSIGNED','SCHEDULED','IN_PROGRESS','WAITING_PART')", ServiceTicket.class)
           .setParameter("techId", technicianID).list();
        }
    }
}
