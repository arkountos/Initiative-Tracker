package com.example.inittrack2

import android.R
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AddCharActivity : AppCompatActivity() {
    private val TAG = "AddCharActivity"
//    public val EXTRA_NAME = "com.example.inittrack2.EXTRA_NAME"
//    public val EXTRA_INITIATIVE = "com.example.inittrack.EXTRA_INITIATIVE"

    lateinit var option : Spinner


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(com.example.inittrack2.R.layout.activity_add_char)

        title = "Add new Character"

        var editTextName = findViewById<EditText>(com.example.inittrack2.R.id.editTextName)
        var editTextInitiative = findViewById<EditText>(com.example.inittrack2.R.id.editTextInitiative)
        option = findViewById(com.example.inittrack2.R.id.spinner)

        val classes = arrayOf("Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard")
        var result : String = "Default"

        option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, classes)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                result = "Default"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                result = classes[position]
            }
        }

        println("##############")
        println(result)
        println(editTextName)

        val btn_done = findViewById<FloatingActionButton>(com.example.inittrack2.R.id.doneButton)
        btn_done.setOnClickListener {

            var editTextNameValue = editTextName.text.toString()
            var editTextInitiativeValue = Integer.valueOf(editTextInitiative.text.toString())
            var spinnerValue = result

            println("HELLO!!!!!!")
            println("Name is")
            println(editTextNameValue)
            println("And inititative is:")
            println(editTextInitiativeValue)
            println("And result is:")
            println(result)

            val resultIntent = Intent()
            resultIntent.putExtra("EXTRA_NAME", editTextNameValue)
            resultIntent.putExtra("EXTRA_INITIATIVE", editTextInitiativeValue)

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

}


