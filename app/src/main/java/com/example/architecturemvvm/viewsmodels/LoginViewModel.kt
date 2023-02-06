package com.example.architecturemvvm.viewsmodels

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.architecturemvvm.model.User


class LoginViewModel : BaseObservable() {

    private val user: User

    private val successMessage = "Login successful"
    private val errorMessage = "Email or Password is not valid"


    @Bindable
    var toastMessage: String? = null
        private set

    private fun setToastMessage(toastMessage: String) {
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }


    @get:Bindable
    var userEmail: String?
        get() = user.email
        set(email) {
            if (email != null) {
                user.email = email
            }
            notifyPropertyChanged(BR.userEmail)
        }


    @get:Bindable
    var userPassword: String?
        get() = user.password
        set(password) {
            user.password = password
            notifyPropertyChanged(BR.userPassword)
        }


    init {

        user = User("", "")
    }


    fun onButtonClicked() {
        if (isValid) setToastMessage(successMessage) else setToastMessage(errorMessage)
    }


    val isValid: Boolean
        get() = (!TextUtils.isEmpty(userEmail) &&
                Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()
                && userPassword!!.length > 5)
}