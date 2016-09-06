package ru.annin.cryptowallet.presentation.ui.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import ru.annin.cryptowallet.R
import ru.annin.cryptowallet.domain.interactor.CryptoUseCase
import ru.annin.cryptowallet.domain.value.CryptoDictionary
import rx.Observable
import rx.Subscription
import rx.subscriptions.CompositeSubscription

class MainActivity : AppCompatActivity() {

    // Use Case
    private val crypto: CryptoUseCase

    //Rx
    private lateinit var subscription: CompositeSubscription

    init {
        crypto = CryptoUseCase()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscription = CompositeSubscription()
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        edt_text.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) { crypto() }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { /** Empty */ }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { /** Empty */  }
        })

        edt_key.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) { crypto() }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { /** Empty */ }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { /** Empty */  }
        })

        sw_encode_or_decode.setOnCheckedChangeListener { p0, p1 -> crypto() }
        sw_dictionary_number.setOnCheckedChangeListener { p0, p1 -> crypto() }
        sw_dictionary_english.setOnCheckedChangeListener { p0, p1 -> crypto() }
        sw_dictionary_russian.setOnCheckedChangeListener { p0, p1 -> crypto() }
        sw_dictionary_special.setOnCheckedChangeListener { p0, p1 -> crypto() }
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.unsubscribe()
    }

    private fun crypto() {
        if (!validate()) {
            return
        }
        val cryptoObservable: Observable<String> = if (sw_encode_or_decode.isChecked)
            crypto.encode(edt_text.text.toString(), edt_key.text.toString(),
                    CryptoDictionary.Dictionary(
                            isNumber = sw_dictionary_number.isChecked,
                            isEnglish = sw_dictionary_english.isChecked,
                            isRussian = sw_dictionary_russian.isChecked,
                            isSpecial = sw_dictionary_special.isChecked))
        else
            crypto.decode(edt_text.text.toString(), edt_key.text.toString(),
                    CryptoDictionary.Dictionary(
                            isNumber = sw_dictionary_number.isChecked,
                            isEnglish = sw_dictionary_english.isChecked,
                            isRussian = sw_dictionary_russian.isChecked,
                            isSpecial = sw_dictionary_special.isChecked))

        val cryptoSubscription: Subscription = cryptoObservable.subscribe(
                { e -> edt_result.setText(e) },
                { t ->Snackbar.make(cnt_root, t.message!!, Snackbar.LENGTH_LONG).show() })

        subscription.add(cryptoSubscription)
    }

    private fun validate(): Boolean {
        var validate: Boolean = true

        til_text.error = null
        til_key.error = null

        if (TextUtils.isEmpty(edt_text.text)) {
            validate = false
            til_text.error = getString(R.string.error_empty)
        }

        if (TextUtils.isEmpty(edt_key.text)) {
            validate = false
            til_key.error = getString(R.string.error_empty)
        }

        return validate
    }


}
