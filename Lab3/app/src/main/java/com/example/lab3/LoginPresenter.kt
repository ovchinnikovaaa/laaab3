package com.example.lab3

class LoginPresenter(var loginView: LoginActivity, val loginInteractor: LoginInteractor) :
    LoginInteractor.OnLoginFinishedListener {

    fun validateCredentials(username: String, password: String) {
        loginView?.showProgress()
        loginInteractor.login(username, password, this)
    }

    fun onDestroy() {
        loginView = null
    }

    override fun onUsernameError() {
        loginView?.apply {
            setUsernameError()
            hideProgress()
        }
    }

    override fun onPasswordError() {
        loginView?.apply {
            setPasswordError()
            hideProgress()
        }
    }

    override fun onSuccess() {
        loginView?.navigateToHome()
    }
}