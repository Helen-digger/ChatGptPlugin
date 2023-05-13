package com.helen.gptplugin.ui

import javax.swing.JComponent

interface ConfigurationPanel<T> {
    fun getComponents(): ArrayList<JComponent>
    fun load(settings: T) : Map<String, String>
}