package com.codegym.service;

import com.codegym.model.Song;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class HibernateSongServiceImpl implements ISongService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Song> findAll() {
        String queryString = "SELECT s from Song AS s";
        TypedQuery<Song> query = entityManager.createQuery(queryString, Song.class);
        return query.getResultList();
    }

    @Override
    public void save(Song song) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(song);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public Song findById(int id) {
        String queryString = "SELECT s FROM Song AS s WHERE s.id = :id";
        TypedQuery<Song> query = entityManager.createQuery(queryString, Song.class);
        query.setParameter("id", id);
        return null;
    }

    @Override
    public Song update(Song song) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Song song1 = findById(song.getId());
            song1.setName(song.getName());
            song1.setType(song.getType());
            song1.setSongPath(song.getSongPath());
            song1.setArtist(song.getArtist());
            session.saveOrUpdate(song1);
            transaction.commit();
            return song1;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Song song = findById(id);
            if (song != null) {
                session.delete(id);
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

}
