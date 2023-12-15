package dao;

import models.Developer;
import models.Game;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.GameService;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class DeveloperDao {

    public Developer findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Developer developer = session.get(Developer.class, id);
        session.close();
        return developer;
    }

    public void save(Object developer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(developer);
        tx1.commit();
        session.close();
    }

    public void update(Object developer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(developer);
        tx1.commit();
        session.close();
    }

    public void delete(Developer developer) {
        GameService gameService = new GameService();
        List<Game> games;
        Game game;
        games = gameService.findAllGamesById(developer.getId());
        for (int i = 0; i < games.size(); i++){
            game = games.get(i);
            gameService.deleteGame(game);
        }
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(developer);
        tx1.commit();
        session.close();
    }

    public Game findGameById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Game.class, id);
    }

    public List<Developer> findAll() {
        List<Developer> developers = (List<Developer>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Developer").list();
        return developers;
    }
}