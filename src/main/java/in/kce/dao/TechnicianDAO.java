package in.kce.dao;

import in.kce.entity.Technician;
import in.kce.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class TechnicianDAO {
    public Technician findTechnician(String technicianID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Technician.class, technicianID);
        }
    }
    public List<Technician> viewAllTechnicians() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Technician", Technician.class).list();
        }
    }
    public void insertTechnician(Technician technician) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(technician);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public void updateTechnicianStatus(String technicianID, String status) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Technician technician = session.get(Technician.class, technicianID);
            if (technician != null) {
                technician.setStatus(status);
                session.update(technician);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public void deleteTechnician(String technicianID) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Technician technician = session.get(Technician.class, technicianID);
            if (technician != null) {
                session.delete(technician);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
