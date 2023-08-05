package com.accenture.kmmpoc.presentation.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.accenture.kmmpoc.domain.auth.SignInUseCase
import com.accenture.kmmpoc.domain.auth.entity.SignInData
import com.accenture.kmmpoc.domain.auth.entity.UserSession
import com.accenture.kmmpoc.domain.base.DomainResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.DIAware
import org.kodein.di.android.x.closestDI
import org.kodein.di.instance

class LoginViewModel(app: Application) : AndroidViewModel(app), DIAware {

    override val di by closestDI()

    private val signInUseCase by instance<SignInUseCase>()

    private val _userSessionLiveData = MutableLiveData<DomainResponse<UserSession>>()
    val userSessionLiveData: LiveData<DomainResponse<UserSession>>
        get() = _userSessionLiveData

    fun signIn(signInData: SignInData) {
        _userSessionLiveData.value = DomainResponse.Loading
        viewModelScope.launch(Dispatchers.IO) {
            _userSessionLiveData.postValue(signInUseCase.execute(signInData))
        }
    }
}