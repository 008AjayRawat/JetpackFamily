package com.learn.jetpackfamily.dataStore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.learn.jetpackfamily.databinding.ActivityProtoDataStoreDemoBinding
import kotlinx.coroutines.launch

class ProtoDataStoreDemoActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityProtoDataStoreDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityProtoDataStoreDemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        lifecycleScope.launch {
            protoDataStore.data.collect {
                val language = it.language
                viewBinding.radioGroup.check(
                    when (language) {
                        Language.ENGLISH -> viewBinding.rbEnglish.id
                        Language.GERMAN -> viewBinding.rbGerman.id
                        Language.SPANISH -> viewBinding.rbSpanish.id
                    }
                )
            }
        }


        viewBinding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                viewBinding.rbEnglish.id -> {
                    lifecycleScope.launch {
                        setLanguage(Language.ENGLISH)
                    }
                }
                viewBinding.rbGerman.id -> {
                    lifecycleScope.launch {
                        setLanguage(Language.GERMAN)
                    }
                }
                viewBinding.rbSpanish.id -> {
                    lifecycleScope.launch {
                        setLanguage(Language.SPANISH)
                    }
                }
            }
        }

    }


    private suspend fun setLanguage(language: Language) {
        protoDataStore.updateData {
            it.copy(language = language)
        }
    }

}