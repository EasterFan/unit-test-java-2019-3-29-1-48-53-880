package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.views.GameView;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    @Mock
    private AnswerGenerator mockGenerator;
    @Mock
    private GameView mockGameView;
    @Mock
    private Game game;
    @Mock
    private InputCommand mockCommand;
    private GameController gameController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(mockGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        gameController = new GameController(game, mockGameView);
    }
    @Test
    public void should_begin_guess_game_when_call_begin_method() throws Exception {
        gameController.beginGame();

        verify(mockGameView).showBegin();
    }

    @Test
    public void should_display_result_when_game_failed() throws IOException {
        when(mockCommand.input()).thenReturn(Answer.createAnswer("1 4 5 6"));
        when(game.checkStatus()).thenReturn("");
        when(game.checkCoutinue()).thenReturn(false);
        GameController gameController = new GameController(game, mockGameView);

        gameController.play(mockCommand);
        verify(mockGameView).showGameStatus(anyString());
    }

}