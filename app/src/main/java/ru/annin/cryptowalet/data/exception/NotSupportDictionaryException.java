package ru.annin.cryptowalet.data.exception;

import android.support.annotation.NonNull;

/**
 * <p>Исключение, вызывающие если словарь не поддерживает кодируемые/декодируемы символы.</p>
 *
 * @author Pavel Annin
 */
public class NotSupportDictionaryException extends RuntimeException {

    public NotSupportDictionaryException(@NonNull final String message) {
        super(message);
    }
}
