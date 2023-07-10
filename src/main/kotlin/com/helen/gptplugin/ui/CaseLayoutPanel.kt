package com.helen.gptplugin.ui

import javax.swing.JLabel
import javax.swing.JList
import javax.swing.JPanel
import javax.swing.JSplitPane
import javax.swing.event.ListSelectionEvent
import javax.swing.event.ListSelectionListener


class CaseLayoutPanel<T> : JPanel(), ListSelectionListener {

    private lateinit var configPane: JLabel
    private lateinit var list: JList<String>
    private lateinit var splitPane: JSplitPane


    /*lateinit var list: JList<String>
    private var headerPanel: JPanel? = null
    private var header: JLabel? = null
    init {
        layout = BorderLayout()
        list = JList<String>()
        headerPanel = JPanel()
        headerPanel!!.layout = BorderLayout()
        headerPanel!!.border = BorderFactory.createEtchedBorder()
        val scroll = JScrollPane(list)
        add(scroll, BorderLayout.CENTER)
        header = JLabel("Header", JLabel.CENTER)
        headerPanel!!.add(header)
        add(headerPanel, BorderLayout.NORTH)
    }

    fun setListData(vect: Vector<String>?) {
        list.setListData(vect)
    }*/
    override fun valueChanged(e: ListSelectionEvent?) {
        TODO("Not yet implemented")
    }
}