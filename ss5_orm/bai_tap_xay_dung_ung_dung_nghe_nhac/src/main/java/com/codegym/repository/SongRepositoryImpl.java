package com.codegym.repository;

import com.codegym.model.Song;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class SongRepositoryImpl implements  ISongRepository{
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = (SessionFactory) new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Song> findAll() {
        String queryString = "SELECT s from Song AS s";
        TypedQuery<Song> query = entityManager.createQuery(queryString,Song.class);
        return query.getResultList();
    }

    @Override
    public void save(Song song) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(music);
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

    @Override
    public Song findById(int id) {
        String queryString = "SELECT m FROM  AS m WHERE m.id = :id";
        TypedQuery<Song> query = entityManager.createQuery(queryString, Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Song update(Song song) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Song originSong = findById(song.getId());
            originSong.setName(song.getName());
            originSong.setArtist(song.getArtist());
            originSong.setType(song.getType());
            originSong.setSongPath(song.getSongPath());
            session.saveOrUpdate(originSong);
            transaction.commit();
            return originSong;
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
                session.delete(song);
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
