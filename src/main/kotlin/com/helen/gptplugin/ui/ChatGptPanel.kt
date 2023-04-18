package com.helen.gptplugin.ui

import com.helen.gptplugin.util.InterfacePropertyValueLoader
import java.awt.BorderLayout
import javax.swing.JPanel

abstract class ChatGptPanel() : JPanel(BorderLayout()), InterfacePropertyValueLoader {

    init {
        initProperties(this, InterfacePropertyValueLoader.properties)
    }
}
