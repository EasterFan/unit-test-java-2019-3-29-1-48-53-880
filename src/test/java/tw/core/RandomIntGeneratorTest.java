package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setUp() throws Exception {
        this.randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void should_get_4_correct_format_number_str() throws Exception {
        String numStr = randomIntGenerator.generateNums(9, 4);

        assertThat(numStr.length(), is(7));

    }

}