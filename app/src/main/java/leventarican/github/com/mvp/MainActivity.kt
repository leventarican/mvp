package leventarican.github.com.mvp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity(), TheView {

    private lateinit var programmingLanguage: EditText
    private lateinit var add: Button
    private lateinit var show: Button
    private lateinit var log: TextView

    private lateinit var thePresenter: ThePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        programmingLanguage = findViewById(R.id.programmingLanguage)
        log = findViewById(R.id.log)

        thePresenter = ThePresenter(this, TheInteractor())

        show = findViewById(R.id.show)
        show.setOnClickListener { _ ->
            thePresenter.requestShow()
        }

        add = findViewById(R.id.add)
        add.setOnClickListener { _ ->
            thePresenter.requestAdd(programmingLanguage)
        }
    }

    override fun uiShow(txt: String) {
        log.text = "show: $txt"
    }

    override fun uiAdd(txt: String) {
        Toast.makeText(this, "add: $txt", Toast.LENGTH_LONG).show()
    }
}
