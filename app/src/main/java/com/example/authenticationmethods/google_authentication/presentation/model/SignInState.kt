package com.example.authenticationmethods.google_authentication.presentation.model

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)
