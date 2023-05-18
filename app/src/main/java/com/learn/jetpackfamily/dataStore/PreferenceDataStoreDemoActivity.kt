package com.learn.jetpackfamily.dataStore


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.learn.jetpackfamily.databinding.ActivityDataStoreDemoBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class PreferenceDataStoreDemoActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityDataStoreDemoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDataStoreDemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSave.setOnClickListener {
            saveData()
        }

        viewBinding.btnRead.setOnClickListener {
            readData()
        }

    }


    private fun saveData() {
        lifecycleScope.launch {
            saveName(this@PreferenceDataStoreDemoActivity, "Ajay Sing Rawat")
            saveAge(this@PreferenceDataStoreDemoActivity, 32)
            saveDob(this@PreferenceDataStoreDemoActivity, 11220090)
            saveIsBoy(this@PreferenceDataStoreDemoActivity, true)
        }
    }

    private fun readData() {
        lifecycleScope.launch {
            val preference = dataStore.data.first()

            val builder = StringBuilder("")
            builder.append(preference[NAME]).append("\n")
            builder.append(preference[AGE]).append("\n")
            builder.append(preference[DATE_OF_BIRTH]).append("\n")
            builder.append(preference[IS_BOY])

            viewBinding.tvValue.text = builder.toString()

        }
    }


}

