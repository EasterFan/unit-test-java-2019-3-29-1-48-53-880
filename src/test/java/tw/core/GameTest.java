package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.generator.AnswerGenerator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */

public class GameTest {

    private Answer actualAnswer = Answer.createAnswer("1 2 3 4");
    private Game game;

    @Before
    public void setUp() throws Exception {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(answerGenerator);
    }

    @Test
    public void should_get_success_status_when_input_str_correct() throws Exception {

        game.guess(Answer.createAnswer("1 2 4 3"));
        game.guess(Answer.createAnswer("1 2 3 4"));

        String statusOfGame = game.checkStatus();
        assertThat(statusOfGame, is("success"));

    }

    @Test
    public void should_get_continue_status_when_input_str_correct() throws Exception {

        game.guess(Answer.createAnswer("1 2 4 3"));

        String statusOfGame = game.checkStatus();
        assertThat(statusOfGame, is("continue"));

    }
    @Test
    public void should_get_fail_status_when_input_str_correct() throws Exception {
        game.guess(Answer.createAnswer("1 2 4 3"));
        game.guess(Answer.createAnswer("1 2 5 4"));
        game.guess(Answer.createAnswer("1 2 6 5"));
        game.guess(Answer.createAnswer("1 2 6 7"));
        game.guess(Answer.createAnswer("4 3 2 8"));
        game.guess(Answer.createAnswer("1 2 6 4"));

        String statusOfGame = game.checkStatus();
        assertThat(statusOfGame, is("fail"));

    }
}
