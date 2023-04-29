package com.example.authenticationmethods.core

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.authenticationmethods.core.presentation.ui.theme.AuthenticationMethodsTheme
import com.example.authenticationmethods.facebook_authentication.presentation.FacebookSignInActivity
import com.example.authenticationmethods.google_authentication.presentation.GoogleSignInActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthenticationMethodsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(onClick = {
                            startActivity(Intent(baseContext, GoogleSignInActivity::class.java))
                        }) {
                            Text(text = "Google Login")
                        }

                        Button(onClick = {
                            startActivity(Intent(baseContext, FacebookSignInActivity::class.java))
                        }) {
                            Text(text = "Facebook Login")
                        }
                    }
                }
            }
        }
    }
}
