import models.Developer;
import models.Game;
import org.junit.Test;
import services.DeveloperService;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class Tests {
    @Test
    public void test1() {
        DeveloperService devServiceTester = new DeveloperService();
        Game game = new Game();
        game.setDeveloper(devServiceTester.findDeveloper(44));
        assertNotNull("error", game);
    }
    @Test
    public void test2() {
        DeveloperService devServiceTester = new DeveloperService();
        Game game = new Game();
        game.setDeveloper(devServiceTester.findDeveloper(1));
        assertNotNull("error", game);
    }
    @Test
    public void test3() {
        DeveloperService devServiceTester = new DeveloperService();
        Game game1 = new Game();
        Game game2 = new Game();
        game1.setDeveloper(devServiceTester.findDeveloper(1));
        game2.setDeveloper(devServiceTester.findDeveloper(2));
        assertNotEquals(game1, game2);
    }
    @Test
    public void test4() {
        DeveloperService developerService = new DeveloperService();
        Developer developer = new Developer("Valve2", 400);
        developerService.saveDeveloper(developer);
    }
    @Test
    public void test5() {
        DeveloperService developerService = new DeveloperService();
        Developer developer;
        developerService.deleteDeveloper(developerService.findDeveloper(9));
    }
}
