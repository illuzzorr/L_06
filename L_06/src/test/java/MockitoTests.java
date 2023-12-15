
import models.Game;
import dao.GameDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MockitoTests {
    Game game;
    GameDao dao;
    @BeforeAll
    void beforeAll(){
        this.dao=Mockito.mock(GameDao.class);
        this.game= Mockito.mock(Game.class);
    }

    @Test
    void SaveTest()
    {
        Mockito.doReturn(game).when(dao).findById(15);
        Game game2 =dao.findById(15);
        Assertions.assertEquals(game, game2);
    }
    @Test
    void UpdateTest()
    {
        Mockito.doReturn(game).when(dao).findById(12);
        //Game game2 = dao.findById(12);
        Game gameEdit = Mockito.mock(Game.class);
        gameEdit.setName(game.getName());
        gameEdit.setPrice(game.getPrice());
        dao.update(gameEdit);
        //Mockito.doReturn(game).when(dao).findById(15);
        Assertions.assertNotEquals(game, gameEdit);
    }
    @Test
    void DeleteTest()
    {
        dao.delete(game);
        Mockito.doReturn(null).when(dao).findById(15);
        Game game2 = dao.findById(game.getId());
        Assertions.assertNotEquals(game, game2);
    }
    @Test
    void DeleteNullUserTest()
    {
        game = null;
        RuntimeException expectedException = new RuntimeException("Error of deleting");
        Mockito.doThrow(expectedException).when(dao).delete(game);
        Assertions.assertThrows(RuntimeException.class,() ->dao.delete(game));
    }

}
