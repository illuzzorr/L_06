import models.Developer;
import models.Game;
import services.DeveloperService;
import services.GameService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DeveloperService developerService = new DeveloperService();
        GameService gameService = new GameService();
        Developer developer = new Developer();
        Game game = new Game();
        List<Game> games;
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("MENU:\n\n" +
                    "11. Create game\n" +
                    "12. Update game\n" +
                    "13. Delete game\n" +
                    "14. Retrieve game by ID\n" +
                    "15. Retrieve all games\n\n" +
                    "21. Create developer\n" +
                    "22. Update developer\n" +
                    "23. Delete developer\n" +
                    "24. Retrieve developer by ID\n" +
                    "25. Retrieve all developers\n" +
                    "26. Retrieve developer's games\n\n" +
                    "0. EXIT");
            choice = scanner.nextInt();
            switch(choice){
                case 11:{
                    System.out.println("Enter name");
                    game.setName(scanner.next());
                    System.out.println("Enter price");
                    game.setPrice(scanner.nextInt());
                    System.out.println("Enter developer id (who exists)");
                    developer = developerService.findDeveloper(scanner.nextInt());
                    game.setDeveloper(developer);
                    gameService.saveGame(game);
                    break;
                }
                case 12:{
                    System.out.println("Enter game id");
                    game = gameService.findGame(scanner.nextInt());
                    System.out.println("Enter new name");
                    game.setName(scanner.next());
                    System.out.println("Enter new price");
                    game.setPrice(scanner.nextInt());
                    System.out.println("Enter new developer id (who exists)");
                    developer = developerService.findDeveloper(scanner.nextInt());
                    game.setDeveloper(developer);
                    gameService.updateGame(game);
                    break;
                }
                case 13:{
                    System.out.println("Enter game id");
                    game = gameService.findGame(scanner.nextInt());
                    gameService.deleteGame(game);
                    break;
                }
                case 14:{
                    System.out.println("Enter game id");
                    System.out.println(gameService.findGame(scanner.nextInt()));
                    break;
                }
                case 15:{
                    System.out.println(gameService.findAllGames());
                    break;
                }
                case 21:{
                    System.out.println("Enter name");
                    developer.setName(scanner.next());
                    System.out.println("Enter employees number");
                    developer.setEmployeesNumber(scanner.nextInt());
                    developerService.saveDeveloper(developer);
                    break;
                }
                case 22:{
                    System.out.println("Enter developer id");
                    developer = developerService.findDeveloper(scanner.nextInt());
                    System.out.println("Enter name");
                    developer.setName(scanner.next());
                    System.out.println("Enter employees number");
                    developer.setEmployeesNumber(scanner.nextInt());
                    developerService.updateDeveloper(developer);
                    break;
                }
                case 23:{
                    System.out.println("Enter developer id");
                    developer = developerService.findDeveloper(scanner.nextInt());
                    developerService.deleteDeveloper(developer);
                    //deleting all games of that dev
                    /*
                    System.out.println("Enter developer id");
                    developer = developerService.findDeveloper(scanner.nextInt());
                    games = gameService.findAllGamesById(developer.getId());
                    System.out.println(games);
                    for (int i = 0; i < games.size(); i++){
                        game = games.get(i);
                        gameService.deleteGame(game);
                    }
                    //only then delete dev
                    developerService.deleteDeveloper(developer);
                     */
                    break;
                }
                case 24:{
                    System.out.println("Enter developer id");
                    System.out.println(developerService.findDeveloper(scanner.nextInt()));
                    break;
                }
                case 25:{
                    System.out.println(developerService.findAllDevelopers());
                    break;
                }
                case 26:{
                    System.out.println("Enter developer id");
                    System.out.println(gameService.findAllGamesById(scanner.nextInt()));
                    break;
                }
                case 0:{
                    return;
                }
                default: break;
            }
        }
        while(choice != 0);
    }
}
