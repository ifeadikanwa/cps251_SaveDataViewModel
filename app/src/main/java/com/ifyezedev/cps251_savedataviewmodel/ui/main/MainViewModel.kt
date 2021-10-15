package com.ifyezedev.cps251_savedataviewmodel.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var names = mutableListOf<String>()

    fun getAllNames() : String {
        if(names.isEmpty()) {
            return "No names to display"
        }
        else {
            var allNames = ""
            for(name in names) {
                allNames += "$name\n"
            }
            return allNames
        }
    }

    fun addName(name: String) {
        names.add(name)
    }
}