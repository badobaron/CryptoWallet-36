package ru.annin.cryptowalet.domain.repository;

import android.support.annotation.NonNull;

import java.util.Map;

/**
 * <p>Репозиторий криптографического кодирования.</p>
 *
 * @author Pavel Annin
 */
public interface CryptoRepository {

    /**
     * Закодировать строку.
     *
     * @param text Исходная строка.
     * @param key Ключ шифрования.
     * @param dictionary Словарь шифрования.
     *
     * @return Зашифрованная строка.
     */
    @NonNull
    String encode(@NonNull String text, @NonNull String key, @NonNull Map<Character, Integer> dictionary);

    /**
     * Декодировать строку.
     *
     * @param text Закодированная строка.
     * @param key Ключ шифрования.
     * @param dictionary Словарь шифрования.
     *
     * @return Расшифрованная строка.
     */
    @NonNull
    String decode(@NonNull String text, @NonNull String key, @NonNull Map<Character, Integer> dictionary);
}
