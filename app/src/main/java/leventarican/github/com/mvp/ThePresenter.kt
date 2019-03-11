package leventarican.github.com.mvp

import android.widget.EditText

class ThePresenter constructor(val theView: TheView, val theInteractor: TheInteractor): TheInteractor.TheInterface {

    fun requestShow() {
        theInteractor.requestProgrammingLanguages(this)
    }

    fun requestAdd(text: EditText) {
        theInteractor.addProgrammingLanguage(this, text.text.toString())
    }

    override fun callback(id: Int, event: String) {
        when (id) {
            0 -> { theView.uiShow(event) }
            1 -> { theView.uiAdd(event) }
        }
    }

}