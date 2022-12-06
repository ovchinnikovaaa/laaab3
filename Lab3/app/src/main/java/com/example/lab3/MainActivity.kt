package com.example.lab3

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this, FindItemsInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgress() {
        val progress: ProgressBar = findViewById(R.id.progress)
        val list: ListView = findViewById(R.id.list)
        progress.visibility = View.VISIBLE
        list.visibility = View.GONE
    }

    override fun hideProgress() {
        val progress: ProgressBar = findViewById(R.id.progress)
        val list: ListView = findViewById(R.id.list)
        progress.visibility = View.GONE
        list.visibility = View.VISIBLE
    }

    override fun setItems(items: List<String>) {
        val list: ListView = findViewById(R.id.list)
        list.adapter = MainAdapter(items, presenter::onItemClicked)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}