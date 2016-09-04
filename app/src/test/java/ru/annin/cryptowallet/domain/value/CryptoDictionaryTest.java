package ru.annin.cryptowallet.domain.value;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * <p>Тест криптографического словаря.</p>
 *
 * @author Pavel Annin
 */
public class CryptoDictionaryTest {

    private CryptoDictionary dictionary;
    private Map<Character, Integer> fullDictionary;

    @Before
    public void onBefore() {
        dictionary = CryptoDictionary.INSTANCE;
        fullDictionary = dictionary.getNUMBER();
        fullDictionary.putAll(dictionary.getENGLISH());
    }

    @After
    public void onAfter() {
        dictionary = null;
    }

    @Test
    public void testCountDictionary() throws Throwable {
        final Collection<Integer> values = fullDictionary.values();
        Assert.assertEquals("Not complete dictionary", (Integer) (fullDictionary.size() - 1),
                Collections.<Integer>max(values));
    }

    @Test
    public void testDuplicateKeyDictionary() throws Throwable {
        final Collection<Character> keys = fullDictionary.keySet();
        for (final Character key : keys) {
            Assert.assertEquals("Duplicate key", 1, Collections.frequency(keys, key));
        }
    }

    @Test
    public void testDuplicateValueDictionary() throws Throwable {
        final Collection<Integer> values = fullDictionary.values();
        for (final Integer value : values) {
            Assert.assertEquals("Duplicate value", 1, Collections.frequency(values, value));
        }
    }
}
