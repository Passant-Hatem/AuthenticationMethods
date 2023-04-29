package com.example.authenticationmethods.facebook_authentication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.facebook.CallbackManager
import com.facebook.login.LoginManager
import com.facebook.login.widget.LoginButton

class FacebookSignInActivity : ComponentActivity() {

    private val login = {
        LoginManager.getInstance().logIn(this, CallbackManager.Factory.create(), listOf("email"))
    }

    private val logout = {
        LoginManager.getInstance().logOut()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<LoginViewModel>()
            val profileViewState by viewModel.profileViewState.collectAsStateWithLifecycle()
            SampleView(profileViewState)
        }
    }

    @Composable
    fun SampleView(profileViewState: ProfileViewState) {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            AndroidView(
                factory = { context -> LoginButton(context) }
            )
        }
    }
}
