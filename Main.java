import controller.GameController;
import controller.GameEvaluator;
import view.ViewCommandLineInterface;

public class Main {
    public static void main(String[] args) {

        GameController gameController = new GameController(new ViewCommandLineInterface(), new GameEvaluator());
        gameController.run();

    }
}
