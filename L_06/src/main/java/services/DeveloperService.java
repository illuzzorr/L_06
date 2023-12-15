package services;

import models.Game;
import models.Developer;
import dao.DeveloperDao;
import java.util.List;

public class DeveloperService {

    private DeveloperDao developerDao = new DeveloperDao();

    public DeveloperService() {
    }

    public Developer findDeveloper(int id) {
        return developerDao.findById(id);
    }

    public void saveDeveloper(Developer developer) {
        developerDao.save(developer);
    }

    public void deleteDeveloper(Developer developer) {
        developerDao.delete(developer);
    }

    public void updateDeveloper(Developer developer) {
        developerDao.update(developer);
    }

    public List<Developer> findAllDevelopers() {
        return developerDao.findAll();
    }

    public Game findGameById(int id) {
        return developerDao.findGameById(id);
    }
}

