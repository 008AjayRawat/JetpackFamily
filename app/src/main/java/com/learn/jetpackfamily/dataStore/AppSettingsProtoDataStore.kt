package com.learn.jetpackfamily.dataStore

import android.content.Context
import androidx.datastore.dataStore

val Context.protoDataStore by dataStore("app-settings.json", serializer = AppSettingsSerializer)