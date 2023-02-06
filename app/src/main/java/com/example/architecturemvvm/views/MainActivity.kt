package com.example.architecturemvvm.views


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.architecturemvvm.R
import androidx.databinding.BindingAdapter
import android.widget.Toast
import com.example.architecturemvvm.databinding.ActivityMainBinding
import com.example.architecturemvvm.viewsmodels.LoginViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        activityMainBinding.viewsModel = LoginViewModel()
        activityMainBinding.executePendingBindings()
    }

    companion object {

        @BindingAdapter("toastMessage")
        fun runMe(view: View, message: String?) {
            if (message != null) Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
        }
    }
}