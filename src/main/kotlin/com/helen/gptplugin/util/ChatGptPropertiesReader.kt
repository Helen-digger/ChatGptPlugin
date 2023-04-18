package com.helen.gptplugin.util

import java.io.InputStream
import java.util.*

//todo read about kotlinx-serialization-properties
object ChatGptPropertiesReader {
    fun loadProperties(resourceFileName: String?): Properties {
        val configuration = Properties()
        val inputStream: InputStream? = ChatGptPropertiesReader::class.java
            .classLoader
            .getResourceAsStream(resourceFileName)
        configuration.load(inputStream)
        inputStream?.close()
        return configuration
    }
}