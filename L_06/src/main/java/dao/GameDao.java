package dao;

import models.Developer;
import models.Game;
import services.DeveloperService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class GameDao {

    public Game findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Game game = session.get(Game.class, id);
        session.close();
        return game;
    }

    public void save(Object game) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(game);
        tx1.commit();
        session.close();
    }

    public void update(Object game) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(game);
        tx1.commit();
        session.close();
    }

    public void delete(Object game) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(game);
        tx1.commit();
        session.close();
    }

    public Developer findDeveloperById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Developer.class, id);
    }
    public List<Game> findGameByDevId(int developer_id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Game> games = (List<Game>) session.createQuery("From Game WHERE developer_id = " + developer_id).list();
        tx1.commit();
        session.close();
        return games;
    }
    public List<Game> findAll() {
        List<Game> games = (List<Game>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Game").list();
        return games;
    }
}