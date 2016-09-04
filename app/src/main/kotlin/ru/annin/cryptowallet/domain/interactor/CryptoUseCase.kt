package ru.annin.cryptowallet.domain.interactor

import ru.annin.cryptowalet.data.repository.CryptoRepositoryImpl
import ru.annin.cryptowalet.domain.repository.CryptoRepository
import ru.annin.cryptowallet.domain.value.CryptoDictionary
import rx.Observable


/**
 * Криптографический интерактор.
 *
 * @author Pavel Annin, 2016
 */
class CryptoUseCase {

    private val repository: CryptoRepository

    init {
        repository = CryptoRepositoryImpl();
    }

    /**
     * Кодирование строки.
     *
     * @param text Исходный текст.
     * @param key Ключ шифрования.
     * @param isNumber (Опционально) Числовой/текстовый словарь.
     *
     * @return Зашифрованная строка.
     */
    fun encode(text: String, key: String, isNumber: Boolean = false): Observable<String> {
        val dictionary: Map<Char, Int> =
                if (isNumber) CryptoDictionary.NUMBER else CryptoDictionary.NUMENGLISH

        return encode(text, key, dictionary)
    }

    /**
     * Кодирование строки.
     *
     * @param text Исходный текст.
     * @param key Ключ шифрования.
     * @param dictionary Криптографический словарь.
     *
     * @return Зашифрованная строка.
     */
    fun encode(text: String, key: String, dictionary: Map<Char, Int>): Observable<String> {
        return Observable.create { t ->
            t!!.run {
                try {
                    val encode: String = repository.encode(text, key, dictionary)
                    if (encode.isNotEmpty()) {
                        onNext(encode)
                    }
                    onCompleted()
                } catch (t: Throwable) {
                    onError(t)
                }
            }
        }
    }

    /**
     * Декодирование строки.
     *
     * @param text Зашифрованный текст.
     * @param key Ключ шифрования.
     * @param isNumber (Опционально) Числовой/текстовый словарь.
     *
     * @return Расшифрованная строка.
     */
    fun decode(text: String, key: String, isNumber: Boolean = false): Observable<String> {
        val dictionary: Map<Char, Int> =
                if (isNumber == true) CryptoDictionary.NUMBER else CryptoDictionary.NUMENGLISH

        return decode(text, key, dictionary)
    }

    /**
     * Декодирование строки.
     *
     * @param text Зашифрованный текст.
     * @param key Ключ шифрования.
     * @param dictionary Криптографический словарь.
     *
     * @return Расшифрованная строка.
     */
    fun decode(text: String, key: String, dictionary: Map<Char, Int>): Observable<String> {
        return Observable.create { t ->
            t!!.run {
                try {
                    val decode: String = repository.decode(text, key, dictionary)
                    if (decode.isNotEmpty()) {
                        onNext(decode)
                    }
                    onCompleted()
                } catch (t: Throwable) {
                    onError(t)
                }
            }
        }
    }
}

