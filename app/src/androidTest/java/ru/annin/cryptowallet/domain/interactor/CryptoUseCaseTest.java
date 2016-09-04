package ru.annin.cryptowallet.domain.interactor;

import android.app.Instrumentation;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import rx.observers.TestSubscriber;

/**
 * <p>Тест интерактора кодирования.</p>
 *
 * @author Pavel Annin
 */
@RunWith(AndroidJUnit4.class)
public class CryptoUseCaseTest extends Instrumentation {

    private static final String TEST_TEXT_DECODE = "9876543210";
    private static final String TEST_TEXT_ENCODE = "0000666622";
    private static final String TEST_KEY= "0123";
    private static final Map<Character, Integer> DICTIONARY = new HashMap<>();

    static {
        DICTIONARY.put('0', 9);
        DICTIONARY.put('1', 8);
        DICTIONARY.put('2', 7);
        DICTIONARY.put('3', 6);
        DICTIONARY.put('4', 5);
        DICTIONARY.put('5', 4);
        DICTIONARY.put('6', 3);
        DICTIONARY.put('7', 2);
        DICTIONARY.put('8', 1);
        DICTIONARY.put('9', 0);
    }

    private CryptoUseCase userCase;

    @Before
    public void onBefore() throws Exception {
        userCase = new CryptoUseCase();
    }

    @After
    public void onAfter() throws Exception {
        userCase = null;
    }

    @Test
    public void testEncode() throws Throwable {
        final TestSubscriber<String> subscriber = new TestSubscriber<>();
        userCase.encode(TEST_TEXT_DECODE, TEST_KEY, DICTIONARY)
                .subscribe(subscriber);

        subscriber.assertNoErrors();
        subscriber.assertValueCount(1);
        subscriber.assertCompleted();

        Assert.assertEquals(TEST_TEXT_ENCODE, subscriber.getOnNextEvents().get(0));
    }

    @Test
    public void testDecode() throws Throwable {
        final TestSubscriber<String> subscriber = new TestSubscriber<>();
        userCase.decode(TEST_TEXT_ENCODE, TEST_KEY, DICTIONARY)
                .subscribe(subscriber);

        subscriber.assertNoErrors();
        subscriber.assertValueCount(1);
        subscriber.assertCompleted();

        Assert.assertEquals(TEST_TEXT_DECODE, subscriber.getOnNextEvents().get(0));
    }
}
