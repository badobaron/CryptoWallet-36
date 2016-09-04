package ru.annin.cryptowallet.data.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import ru.annin.cryptowalet.data.repository.CryptoRepositoryImpl;
import ru.annin.cryptowalet.domain.repository.CryptoRepository;

/**
 * <p>Тест криптографического кодирования.</p>
 *
 * @author Pavel Annin
 */
public class CryptoRepositoryTest {

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

    private CryptoRepository repository;

    @Before
    public void onBefore() {
        repository = new CryptoRepositoryImpl();
    }

    @After
    public void onAfter() {
        repository = null;
    }

    @Test
    public void testEncode() throws Throwable {
        final String encode = repository.encode(TEST_TEXT_DECODE, TEST_KEY, DICTIONARY);
        Assert.assertEquals(TEST_TEXT_ENCODE, encode);
    }

    @Test
    public void testDecode() throws Throwable {
        final String decode = repository.decode(TEST_TEXT_ENCODE, TEST_KEY, DICTIONARY);
        Assert.assertEquals(TEST_TEXT_DECODE, decode);
    }
}
