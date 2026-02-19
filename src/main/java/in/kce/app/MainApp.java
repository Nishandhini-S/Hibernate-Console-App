package in.kce.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.kce.entity.Customer;
import in.kce.entity.Technician;
import in.kce.entity.ServiceTicket;
import in.kce.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("--- Home Appliance Repair Ticket Console ---");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Customer c = new Customer();
            c.setCustomerID("CUS5001");
            c.setFullName("Meera Krishnan");
            c.setAddressLine("Flat 8C, Riverfront Residency");
            c.setCity("Chennai");
            c.setPincode("600100");
            c.setPrimaryPhone("9876599999");
            c.setStatus("ACTIVE");
            session.save(c);
            tx.commit();
            System.out.println("CUSTOMER REGISTERED");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("CUSTOMER REGISTRATION FAILED");
        }

        try {
            tx = session.beginTransaction();

            Technician t = new Technician();
            t.setTechnicianID("TEC5002");
            t.setFullName("Ravi Shankar");
            t.setSkillCategory("Refrigerator");
            t.setServiceRegion("Chennai-South");
            t.setPhone("9000090000");
            t.setStatus("ACTIVE");
            session.save(t);
            tx.commit();
            System.out.println("TECHNICIAN REGISTERED");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("TECHNICIAN REGISTRATION FAILED");
        }
        try {
            tx = session.beginTransaction();
            ServiceTicket ticket = new ServiceTicket();
            ticket.setCustomerID("CUS5001");
            ticket.setApplianceType("Refrigerator");
            ticket.setProblemDescription("Not cooling");
            ticket.setTicketDate(new java.sql.Date(System.currentTimeMillis()));
            ticket.setStatus("OPEN");
            session.save(ticket);
            tx.commit();
            System.out.println("TICKET CREATED");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("TICKET CREATION FAILED");
        }
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
