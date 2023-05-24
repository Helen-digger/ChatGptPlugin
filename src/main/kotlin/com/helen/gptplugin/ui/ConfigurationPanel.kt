package com.helen.gptplugin.ui

import javax.swing.JComponent

interface ConfigurationPanel<T> {
    fun isModified(settings : T): Boolean
}