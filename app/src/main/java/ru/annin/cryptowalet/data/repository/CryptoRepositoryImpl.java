package ru.annin.cryptowalet.data.repository;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.annin.cryptowalet.data.exception.NotSupportDictionaryException;
import ru.annin.cryptowalet.domain.repository.CryptoRepository;

/**
 * <p>Реализация репозиторий криптографического кодирования.</p>
 *
 * @author Pavel Annin
 */
public final class CryptoRepositoryImpl implements CryptoRepository {

    @NonNull
    @Override
    public final String encode(@NonNull String text, @NonNull String key,
                               @NonNull Map<Character, Integer> overallDictionary,
                               @NonNull Map<Character, Integer> encodeDictionary) {
        final List<Integer> textEncode = encodeStr2Dictionary(text, overallDictionary);
        final List<Integer> keyEncode = encodeStr2Dictionary(key, overallDictionary);

        final List<Integer> encode = new ArrayList<>();

        for (int i = 0; i < textEncode.size(); ++i) {
            final Integer numText = textEncode.get(i);
            final Integer numKey = getWithoutOffset(i, keyEncode);

            final Integer numResult = numText + numKey;
            final Integer numResultOptimized = numResult - ((numResult / encodeDictionary.size()) * encodeDictionary.size());
            encode.add(numResultOptimized);
        }
        return decodeDictionary2Str(encode, encodeDictionary);
    }

    @NonNull
    @Override
    public final String decode(@NonNull String text, @NonNull String key,
                               @NonNull Map<Character, Integer> overallDictionary,
                               @NonNull Map<Character, Integer> decodeDictionary) {
        final List<Integer> textEncode = encodeStr2Dictionary(text, decodeDictionary);
        final List<Integer> keyEncode = encodeStr2Dictionary(key, decodeDictionary);

        final List<Integer> decode = new ArrayList<>();
        for (int i = 0; i < textEncode.size(); ++i) {
            final Integer numText = textEncode.get(i);
            final Integer numKey = getWithoutOffset(i, keyEncode);

            Integer numResult = numText;
            while ((numResult - numKey) < 0) {
                numResult += overallDictionary.size();
            }
            final Integer numResultOptimize = numResult - numKey;

            decode.add(numResultOptimize);
        }
        return decodeDictionary2Str(decode, overallDictionary);
    }

    @NonNull
    private List<Integer> encodeStr2Dictionary(@NonNull String text, @NonNull Map<Character, Integer> dictionary) {
        final List<Integer> textDictionary = new ArrayList<>();
        for (final Character c : text.toCharArray()) {
            if (!dictionary.containsKey(c)) {
                throw new NotSupportDictionaryException("Dictionary do not support character " + c);
            }
            textDictionary.add(dictionary.get(c));
        }
        return textDictionary;
    }

    @NonNull
    private String decodeDictionary2Str(@NonNull List<Integer> text, @NonNull Map<Character, Integer> dictionary) {
        final StringBuilder textDictionary = new StringBuilder();
        for (final Integer number : text) {
            if (!dictionary.containsValue(number)) {
                throw new NotSupportDictionaryException("Dictionary do not support code " + number);
            }

            final List<Character> keyDictionary = new ArrayList<>();
            for (final Character c : dictionary.keySet()) {
                if (dictionary.get(c).equals(number)) {
                    keyDictionary.add(c);
                }
            }

            if (keyDictionary.isEmpty()) {
                throw new NotSupportDictionaryException("Dictionary do not support code " + number);
            } else if (keyDictionary.size() > 1) {
                throw new NotSupportDictionaryException("Dictionary duplicate code " + number);
            } else {
                textDictionary.append(String.valueOf(keyDictionary.get(0)));
            }
        }
        return textDictionary.toString();
    }

    @NonNull
    private <T> T getWithoutOffset(int index, @NonNull List<? extends T> collection) {
        if (index < 0) {
            throw new IllegalArgumentException("Index < 0, (Index = " + index + ")");
        } else if (collection.isEmpty()) {
            throw new IllegalArgumentException("Collection empty");
        }
        final int position = index - ((index / collection.size()) * collection.size());
        return collection.get(position);
    }
}
