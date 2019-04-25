package tw.core;
import org.junit.Before;
import org.junit.Test;
import tw.core.model.Record;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer actualAnswer;

    @Before
    public void setUp() throws Exception {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void should_return_0A0B_when_no_correct() {
        String inputAnswerStr = "6 7 8 9";
        String expectValue = "0A0B";
        Answer inputAnswer = Answer.createAnswer(inputAnswerStr);

        Record result = actualAnswer.check(inputAnswer);
        String value = result.getValue();
        assertThat(value, is(expectValue));
    }

    @Test
    public void should_return_4A0B_when_1_number_correct() {
        String inputAnswerStr = "1 2 3 4";
        String expectValue = "4A0B";
        Answer inputAnswer = Answer.createAnswer(inputAnswerStr);

        Record result = actualAnswer.check(inputAnswer);
        String value = result.getValue();
        assertThat(value, is(expectValue));
    }

    @Test
    public void should_return_0A4B_when_has_two_number() {
        String inputAnswerStr = "4 3 2 1";
        String expectValue = "0A4B";
        Answer inputAnswer = Answer.createAnswer(inputAnswerStr);

        Record result = actualAnswer.check(inputAnswer);
        String value = result.getValue();
        assertThat(value, is(expectValue));
    }


    @Test
    public void should_return_2A2B_when_two_number_correct_and_has_two_number() {
        String inputAnswerStr = "1 5 8 2";
        String expectValue = "1A1B";
        Answer inputAnswer = Answer.createAnswer(inputAnswerStr);

        Record result = actualAnswer.check(inputAnswer);
        String value = result.getValue();
        assertThat(value, is(expectValue));
    }
}