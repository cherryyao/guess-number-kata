package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.exception.AnswerFormatIncorrectException;
import tw.core.model.Record;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by jxzhong on 2017/9/23.
 */
public class AnswerTest {
    private Answer actualAnswer;

    @BeforeEach
    public void setUp() {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void shoule_validate_incorrect_when_numList_greater_than_numList(){
        Answer answer = new Answer();
        answer = Answer.createAnswer("1 2 3 4 4");
        try {
            answer.validate();
        }catch (AnswerFormatIncorrectException a){
            System.out.print("Answer format is incorrect");
        }
    }
    @Test
    public void shoule_validate_correct_when_numList_greater_than_numList(){
        Answer answer = new Answer();
        answer = Answer.createAnswer("1 2 3 5");
        try {
            answer.validate();
        }catch (AnswerFormatIncorrectException a){
            System.out.print("Answer format is incorrect");
        }
    }

    @Test
    public void should_fail_when_the_format_have_incorrect_10() throws Exception {

        //given
        try {
            Answer answer = Answer.createAnswer("1 2 3 10");
            answer.validate();
        }catch (AnswerFormatIncorrectException e){
            System.out.print(("Answer format is incorrect"));
        }
    }

    @Test
    public void shoule_return_String_when_use_toString(){
        Answer answer = Answer.createAnswer("1 2 3 4");
        assertThat(answer.toString(),is("1 2 3 4"));
    }


}