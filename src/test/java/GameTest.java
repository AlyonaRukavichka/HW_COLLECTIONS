import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test

    public void ifFirstPlayerWin() {
        Player vova = new Player(12, "Вова", 22);
        Player dima = new Player(4, "Дима", 19);
        Game game = new Game();

        game.register(vova);
        game.register(dima);


        int expected = 1;
        int actual = game.round("Вова", "Дима");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void ifSecondPlayerWin() {
        Player vova = new Player(1, "Вова", 22);
        Player dima = new Player(2, "Дима", 25);
        Game game = new Game();

        game.register(vova);
        game.register(dima);


        int expected = 2;
        int actual = game.round("Вова", "Дима");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void ifDeadHeat() {
        Player vova = new Player(1, "Вова", 22);
        Player dima = new Player(2, "Дима", 22);
        Game game = new Game();

        game.register(vova);
        game.register(dima);


        int expected = 0;
        int actual = game.round("Вова", "Дима");

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void ifFirstDoNotFound() {
        Player vova = new Player(1, "Вова", 22);
        Player dima = new Player(2, "Дима", 22);
        Game game = new Game();

        game.register(vova);
        game.register(dima);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Витя", "Дима");
        });
    }

    @Test

    public void ifSecondDoNotFound() {
        Player vova = new Player(1, "Вова", 22);
        Player dima = new Player(2, "Дима", 22);
        Game game = new Game();

        game.register(vova);
        game.register(dima);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вова", "Митя");
        });
    }

    @Test

    public void ifAllDoNotFound() {
        Player vova = new Player(1, "Вова", 22);
        Player dima = new Player(2, "Дима", 22);
        Game game = new Game();

        game.register(vova);
        game.register(dima);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Витя", "Митя");
        });
    }

    @Test
    public void shouldSet() {
        Player play = new Player(1,"Вова", 22);


        Assertions.assertEquals(1, play.getId());
        Assertions.assertEquals("Вова", play.getName());
        Assertions.assertEquals(22, play.getStrength());
    }
}
