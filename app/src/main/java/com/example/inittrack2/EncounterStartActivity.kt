package com.example.inittrack2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Spinner
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_encounter_start.*

class EncounterStartActivity : AppCompatActivity() {

    private lateinit var height_option : Spinner
    private lateinit var width_option : Spinner
    private lateinit var trees_probability_option : Spinner
    private lateinit var rocks_probability_option : Spinner
    private lateinit var enemies_quantity_option: Spinner


    val quantities = arrayOf(
        "0",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10"
    )

    val height_width_values = arrayOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14",
        "15",
        "20",
        "25",
        "50",
        "100"
    )

    val probabilities = arrayOf(
        "1%",
        "2%",
        "5%",
        "10%",
        "15%",
        "20%",
        "25%",
        "50%",
        "75%"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encounter_start)

        title = "Map generation settings"

        var height_input = "5"
        var width_input = "5"
        var trees_probability_input = "5%"
        var rocks_probability_input = "5%"
        var enemies_quantity_input = "1"


        var campfire_input = findViewById<CheckBox>(R.id.campfire_checkbox)
        var trees_input = findViewById<CheckBox>(R.id.trees_checkbox)
        var hills_input = findViewById<CheckBox>(R.id.hills_checkbox)
        var stream_input = findViewById<CheckBox>(R.id.stream_checkbox)
        var rocks_input = findViewById<CheckBox>(R.id.rocks_checkbox)

        // Class choosing Spinner
        height_option = findViewById(com.example.inittrack2.R.id.height_spinner)
        width_option = findViewById(com.example.inittrack2.R.id.width_spinner)
        trees_probability_option = findViewById(com.example.inittrack2.R.id.tree_probability_spinner)
        rocks_probability_option = findViewById(com.example.inittrack2.R.id.rock_probability_spinner)
        enemies_quantity_option = findViewById(com.example.inittrack2.R.id.enemies_quantity_spinner)




        height_option.adapter =
            ArrayAdapter<String>(this, R.layout.spinner_item, height_width_values)
        width_option.adapter =
            ArrayAdapter<String>(this, R.layout.spinner_item, height_width_values)
        trees_probability_option.adapter =
            ArrayAdapter<String>(this, R.layout.spinner_item, probabilities)
        rocks_probability_option.adapter =
            ArrayAdapter<String>(this, R.layout.spinner_item, probabilities)
        enemies_quantity_option.adapter =
            ArrayAdapter<String>(this, R.layout.spinner_item, quantities)




        height_option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                height_input = "5"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                height_input = height_width_values[position]

            }
        }

        width_option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                width_input = "5"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                width_input = height_width_values[position]

            }
        }

        height_option.setSelection(9)
        width_option.setSelection(9)

        trees_probability_option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                trees_probability_input = "5%"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                trees_probability_input = probabilities[position]

            }
        }

        rocks_probability_option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                rocks_probability_input = "5%"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                rocks_probability_input = probabilities[position]

            }
        }

        trees_probability_option.setSelection(3)
        rocks_probability_option.setSelection(3)

        enemies_quantity_option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                enemies_quantity_input = "1"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                enemies_quantity_input = quantities[position]

            }
        }

        enemies_quantity_option.setSelection(0)

        val encounter_start_btn_done = findViewById<FloatingActionButton>(com.example.inittrack2.R.id.encounter_start_done)
        encounter_start_btn_done.setOnClickListener {

            var height_result = height_input
            var width_result = width_input
            var trees_probability_result = trees_probability_input
            var rocks_probability_result = rocks_probability_input
            var enemies_quantity_result = enemies_quantity_input

            var campfire_result = if(campfire_input.isChecked) "1" else "0"
            var trees_result = if(trees_input.isChecked) "1" else "0"
            var hills_result = if(hills_input.isChecked) "1" else "0"
            var stream_result = if(stream_input.isChecked) "1" else "0"
            var rocks_result = if(rocks_input.isChecked) "1" else "0"

            val intent = Intent(this, EncounterGeneratorActivity::class.java)
            intent.putExtra("EXTRA_HEIGHT", height_result)
            intent.putExtra("EXTRA_WIDTH", width_result)
            intent.putExtra("EXTRA_TREES_PROBABILITY", trees_probability_result)
            intent.putExtra("EXTRA_CAMPFIRE", campfire_result)
            intent.putExtra("EXTRA_TREES", trees_result)
            intent.putExtra("EXTRA_HILLS", hills_result)
            intent.putExtra("EXTRA_STREAM", stream_result)
            intent.putExtra("EXTRA_ROCKS", rocks_result)
            intent.putExtra("EXTRA_ROCKS_PROBABILITY", rocks_probability_result)
            intent.putExtra("EXTRA_ENEMIES_QUANTITY", enemies_quantity_result)


            startActivity(intent)
        }
    }
}
