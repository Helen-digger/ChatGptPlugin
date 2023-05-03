package com.helen.gptplugin.ui

import javax.swing.JComponent

interface ConfigurationPanel<T> {
    fun getComponent(): JComponent?

    fun isModified(settings: T): Boolean

    fun save(settings: T)

    fun load(settings: T)
}