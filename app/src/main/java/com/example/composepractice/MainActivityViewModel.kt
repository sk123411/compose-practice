package com.example.composepractice

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {




    fun showData(context: Context, msg:String){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
    }


}