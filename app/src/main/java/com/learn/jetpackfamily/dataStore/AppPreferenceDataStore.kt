package com.learn.jetpackfamily.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")


val NAME = stringPreferencesKey("key")
val AGE = intPreferencesKey("age")
val DATE_OF_BIRTH = longPreferencesKey("dob")
val IS_BOY = booleanPreferencesKey("isBoy")


suspend fun saveName(context: Context, name: String) {
    context.dataStore.edit { user ->
        user[NAME] = name
    }
}

suspend fun saveAge(context: Context, age: Int) {
    context.dataStore.edit { user ->
        user[AGE] = age
    }
}

suspend fun saveDob(context: Context, dob: Long) {
    context.dataStore.edit { user ->
        user[DATE_OF_BIRTH] = dob
    }
}

suspend fun saveIsBoy(context: Context, isBoy: Boolean) {
    context.dataStore.edit { user ->
        user[IS_BOY] = isBoy
    }
}