package com.helen.gptplugin.util

import java.util.*

interface InterfacePropertyValueLoader {

    fun <T> initProperties(obj: T, properties : Properties) {
        val fields = obj!!::class.java.declaredFields
        for (field in fields) {
            val annotation = field.getAnnotation(PropertyValue::class.java)
            if (annotation != null) {
                field.isAccessible = true
                val typesProperties = TypeUtils.inferType(properties.getProperty(annotation.key))
                field.set(obj, typesProperties)
            }
        }
    }

    companion object {
        val properties = ChatGptPropertiesReader.loadProperties("chatgpt-idea.properties")
    }
}