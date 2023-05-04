package com.example.authenticationmethods.facebook_authentication.presentation

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import com.facebook.Profile
import com.facebook.ProfileTracker
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel() {

    private val profileTracker =
        object : ProfileTracker() {
            override fun onCurrentProfileChanged(oldProfile: Profile?, currentProfile: Profile?) {
                if (currentProfile != null) this@LoginViewModel.updateProfile(currentProfile)
                else this@LoginViewModel.resetProfile()
            }
        }
    private val _profileViewState = MutableStateFlow(ProfileViewState(Profile.getCurrentProfile()))

    val profileViewState = _profileViewState.asStateFlow()

    override fun onCleared() {
        profileTracker.stopTracking()
        super.onCleared()
    }

    private fun updateProfile(profile: Profile) {
        _profileViewState.update {
            it.copy(
                profile = profile
            )
        }
    }

    private fun resetProfile() {
        _profileViewState.update {
            it.copy(
                profile = null
            )
        }
    }
}

@Immutable
data class ProfileViewState(
    val profile: Profile? = null
)