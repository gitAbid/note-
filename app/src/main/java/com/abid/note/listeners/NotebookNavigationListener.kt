package com.abid.note.listeners

import android.view.View

/**
 * Created by Abid Hasan on 6/10/19.
 * Copyright (c) 2019. All rights reserved.
 * @author Abid Hasan
 *
 */

interface NotebookNavigationListener {

    fun onAddNotebookClicked()
    fun onNotebookItemClicked(view: View, positon: Int)
}