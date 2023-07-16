package com.helen.gptplugin.ui

import com.intellij.ide.plugins.PluginManagerConfigurable
import com.intellij.openapi.ui.Divider
import com.intellij.openapi.ui.Splitter
import com.intellij.ui.OnePixelSplitter
import com.intellij.ui.components.JBScrollPane
import com.intellij.util.ui.JBUI
import java.awt.Color
import java.awt.Font
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.ListSelectionModel
import javax.swing.event.ListSelectionEvent
import javax.swing.event.ListSelectionListener


class CaseLayoutPanel : JPanel(), ListSelectionListener {

    private var list: JList<String>
    var splitPane: Splitter

    private val imageNames = arrayOf(
        "Bird", "Cat", "Dog", "Rabbit", "Pig", "dukeWaveRed",
        "kathyCosmo", "lainesTongue", "left", "middle", "right", "stickerface"
    )
    init {
        list = JList(imageNames)
        list.selectionMode = ListSelectionModel.SINGLE_SELECTION
        list.selectedIndex = 0
        list.addListSelectionListener(this)
        val listScrollPane = JBScrollPane(list)
        listScrollPane.border = JBUI.Borders.empty()

        val prop = ChatGptPropsPanel()
        prop.border = BorderFactory.createEmptyBorder(0, 20, 0, 0)

        splitPane = object : OnePixelSplitter(false, 0.25f) {
            override fun createDivider(): Divider {
                val divider = super.createDivider()
                divider.background = PluginManagerConfigurable.SEARCH_FIELD_BORDER_COLOR
                divider.isVisible = false
                return divider
            }
        }
        splitPane.firstComponent = listScrollPane
        splitPane.secondComponent = prop

    }

    override fun valueChanged(e: ListSelectionEvent) {
        val list = e.source as JList<String>
    }
}