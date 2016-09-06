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

    @Before
    public void onBefore() {
        dictionary = CryptoDictionary.INSTANCE;
    }

    @After
    public void onAfter() {
        dictionary = null;
    }

    @Test
    public void testNumberDictionary() throws Throwable {
        final Map<Character, Integer> currentDictionary = dictionary.getNUMBER();

        final Collection<Integer> values = currentDictionary.values();
        Assert.assertEquals("Not complete dictionary", (Integer) (currentDictionary.size() - 1),
                Collections.<Integer>max(values));

        final Collection<Character> keys = currentDictionary.keySet();
        for (final Character key : keys) {
            Assert.assertEquals("Duplicate key", 1, Collections.frequency(keys, key));
        }

        for (final Integer value : values) {
            Assert.assertEquals("Duplicate value", 1, Collections.frequency(values, value));
        }
    }

    @Test
    public void testEnglishDictionary() throws Throwable {
        final Map<Character, Integer> currentDictionary = dictionary.getENGLISH();

        final Collection<Integer> values = currentDictionary.values();
        Assert.assertEquals("Not complete dictionary", (Integer) (currentDictionary.size() - 1),
                Collections.<Integer>max(values));

        final Collection<Character> keys = currentDictionary.keySet();
        for (final Character key : keys) {
            Assert.assertEquals("Duplicate key", 1, Collections.frequency(keys, key));
        }

        for (final Integer value : values) {
            Assert.assertEquals("Duplicate value", 1, Collections.frequency(values, value));
        }
    }

    @Test
    public void testRussianDictionary() throws Throwable {
        final Map<Character, Integer> currentDictionary = dictionary.getRUSSIAN();

        final Collection<Integer> values = currentDictionary.values();
        Assert.assertEquals("Not complete dictionary", (Integer) (currentDictionary.size() - 1),
                Collections.<Integer>max(values));

        final Collection<Character> keys = currentDictionary.keySet();
        for (final Character key : keys) {
            Assert.assertEquals("Duplicate key", 1, Collections.frequency(keys, key));
        }

        for (final Integer value : values) {
            Assert.assertEquals("Duplicate value", 1, Collections.frequency(values, value));
        }
    }

    @Test
    public void testSpecialDictionary() throws Throwable {
        final Map<Character, Integer> currentDictionary = dictionary.getSPECIAL();

        final Collection<Integer> values = currentDictionary.values();
        Assert.assertEquals("Not complete dictionary", (Integer) (currentDictionary.size() - 1),
                Collections.<Integer>max(values));

        final Collection<Character> keys = currentDictionary.keySet();
        for (final Character key : keys) {
            Assert.assertEquals("Duplicate key", 1, Collections.frequency(keys, key));
        }

        for (final Integer value : values) {
            Assert.assertEquals("Duplicate value", 1, Collections.frequency(values, value));
        }
    }
}
