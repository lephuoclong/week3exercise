package com.example.secondexercise.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.secondexercise.models.User
import com.example.secondexercise.utils.DataStore

class RegisterViewModel : ViewModel() {

    private var _showPass :MutableLiveData<Boolean> = MutableLiveData(false)
    private var _errorToast:MutableLiveData<String> = MutableLiveData("Vui lòng nhập đủ thông tin")

    val errorToast:LiveData<String>
    get() = _errorToast


    val showPass :LiveData<Boolean>
    get() = _showPass

    fun doSignUp(user: User):Boolean{
        if(user.fullname.isEmpty()){
            _errorToast.postValue("Fullname không được để trống")
            return false
        }
        if (user.password.isEmpty()){
            _errorToast.postValue("Password không được để trống")
            return false
        }
        if(user.email.isEmpty()){
            _errorToast.postValue("Email không được để trống")
            return false
        }
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(user.email).matches()){
            _errorToast.postValue("Email không đúng định dạng")
            return false
        }
        DataStore.listUser.add(user)
        return true
    }

    fun doShowHidePassword(){
        if(_showPass.value == false){
            _showPass.postValue(true)
        }else{
            _showPass.postValue(false)
        }
    }
}