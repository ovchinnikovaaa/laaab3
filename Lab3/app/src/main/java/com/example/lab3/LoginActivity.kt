package com.example.lab3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val presenter = LoginPresenter(this, LoginInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener { validateCredentials() }
    }

    private fun validateCredentials() {
        val username: EditText = findViewById(R.id.username)
        val password: EditText = findViewById(R.id.password)
        presenter.validateCredentials(username.text.toString(), password.text.toString())
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    fun showProgress() {
        val progress: ProgressBar = findViewById(R.id.progress)
        progress.visibility = View.VISIBLE
    }

    fun hideProgress() {
        val progress: ProgressBar = findViewById(R.id.progress)
        progress.visibility = View.GONE
    }

    fun setUsernameError() {
        val username: EditText = findViewById(R.id.username)
        username.error = getString(R.string.username_error)
    }

    fun setPasswordError() {
        val password: EditText = findViewById(R.id.password)
        password.error = getString(R.string.password_error)
    }

    fun navigateToHome() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}