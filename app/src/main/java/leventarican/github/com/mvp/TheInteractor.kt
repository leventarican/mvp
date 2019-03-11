package leventarican.github.com.mvp

import android.os.Handler

/*
Interactor: VIPER (View Interactor Presenter Entity Router)
 */
class TheInteractor {

    private val model = mutableListOf("kotlin, java", "cpp")

    interface TheInterface {
        fun callback(id: Int, event: String)
    }

    fun requestProgrammingLanguages(listener: TheInterface) {
        Handler().postDelayed(Runnable {
            listener.callback(0, model.shuffled().toString())
        }, 2000)
    }

    fun addProgrammingLanguage(listener: TheInterface, programmingLanguage: String) {
        Handler().postDelayed(Runnable {
            model.add(programmingLanguage)
            listener.callback(1, "successful")
        }, 2000)
    }
}