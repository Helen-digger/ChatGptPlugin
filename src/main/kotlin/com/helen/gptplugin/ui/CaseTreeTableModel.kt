package com.helen.gptplugin.ui

import com.intellij.ui.treeStructure.treetable.TreeTable
import com.intellij.ui.treeStructure.treetable.TreeTableModel
import com.intellij.ui.treeStructure.treetable.TreeTableTree
import javax.annotation.Nullable
import javax.swing.JTree
import javax.swing.table.AbstractTableModel
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeModel

class CaseTreeTableModel : DefaultTreeModel(DefaultMutableTreeNode()), TreeTableModel{

    lateinit var treeTable: TreeTable
    override fun getColumnCount(): Int {
        return 1
    }

    override fun getColumnName(column: Int): String {
        return ""
    }

    override fun getColumnClass(column: Int): Class<*> {
        return TreeTableModel::class.java
    }

    @Nullable
    override fun getValueAt(node: Any?, column: Int): Any? {
        return null
    }

    override fun isCellEditable(node: Any?, column: Int): Boolean {
        return false
    }

    override fun setValueAt(aValue: Any?, node: Any?, column: Int) {
        (treeTable.model as AbstractTableModel).fireTableDataChanged()
    }

    override fun setTree(tree: JTree?) {
        treeTable = (tree as TreeTableTree).treeTable
    }
}