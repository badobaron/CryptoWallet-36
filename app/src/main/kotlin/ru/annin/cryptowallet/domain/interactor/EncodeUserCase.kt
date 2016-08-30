package ru.annin.cryptowallet.domain.interactor

import rx.Observable


/**
 * Created by Pavel on 29.08.2016.
 */
class EncodeUserCase {


    fun asObservable(text: CharSequence, key: CharSequence, isNumber: Boolean = false): Observable<Char> {

        return Observable.from(text.toList());
    }


}