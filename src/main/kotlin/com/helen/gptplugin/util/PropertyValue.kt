package com.helen.gptplugin.util

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class PropertyValue(val key : String)
