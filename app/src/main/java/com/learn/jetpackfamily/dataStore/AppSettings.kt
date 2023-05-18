package com.learn.jetpackfamily.dataStore

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@kotlinx.serialization.Serializable
data class AppSettings(
    val language: Language = Language.ENGLISH,
    val knownLocations: PersistentList<Location> = persistentListOf()
)

@kotlinx.serialization.Serializable
data class Location(
    val lat: Double,
    val lng: Double
)

enum class Language {
    ENGLISH, GERMAN, SPANISH
}