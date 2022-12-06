package com.example.lab3

interface MainView {
    abstract val onItemClicked: (String) -> Unit

    fun showProgress()
    fun hideProgress()
    fun setItems(items: List<String>)
    fun showMessage(message: String)
}