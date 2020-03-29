package com.evanisnor.greeting

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_prompt.*
import java.util.*


class GreetingActivity : AppCompatActivity() {

    private val random = Random(System.currentTimeMillis())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_prompt)

        input_name.hint = generateName()
        input_name.addTextChangedListener {
            button_proceed.visibility =
                if (input_name.text.length > 2 && !input_name.text.isBlank()) {
                    View.VISIBLE
                } else {
                    input_name.hint = generateName()
                    View.GONE
                }
        }

        input_name.setOnFocusChangeListener { v, hasFocus -> if (!hasFocus) hideSoftKeyboard(v) }

        button_proceed.setOnClickListener {
            val greeting = resources.getString(R.string.greeting, input_name.text.trim())
            AlertDialog.Builder(this)
                .setMessage(greeting)
                .create().show()
        }

    }

    private fun generateName(): String {
        val names = resources.getStringArray(R.array.generated_names)
        return names[random.nextInt(names.size)]
    }
}
