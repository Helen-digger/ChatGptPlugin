package com.helen.gptplugin.ui

import com.intellij.ui.components.JBTabbedPane
import java.awt.BorderLayout
import javax.swing.JPanel

class ChatGptSettingsPanel : JPanel(BorderLayout()) {

    private val dialog: JPanel = JPanel(BorderLayout())
    private val propertiesChatGpt: PropertiesChatGptSettingsPanel = PropertiesChatGptSettingsPanel()

    init {
        val tabs = JBTabbedPane()

        tabs.insertTab("Props", null, propertiesChatGpt, "", 0)
        tabs.insertTab("Dialog", null, dialog, "", 1)

        add(tabs, BorderLayout.CENTER)
    }
}