package services;

import dao.GameDao;
import models.Game;
import models.Developer;
import java.util.List;

public class GameService {

    private GameDao gameDao = new GameDao();

    public GameService() {
    }

    public Game findGame(int id) {
        return gameDao.findById(id);
    }

    public void saveGame(Game game) {
        gameDao.save(game);
    }

    public void deleteGame(Game game) {
        gameDao.delete(game);
    }

    public void updateGame(Game game) {
        gameDao.update(game);
    }

    public List<Game> findAllGames() {
        return gameDao.findAll();
    }

    public List<Game> findAllGamesById(int id) {
        return gameDao.findGameByDevId(id);
    }

    public Developer findDeveloperById(int id) {
        return gameDao.findDeveloperById(id);
    }


}

