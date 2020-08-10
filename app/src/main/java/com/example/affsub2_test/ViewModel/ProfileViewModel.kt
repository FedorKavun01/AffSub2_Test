package com.example.affsub2_test.ViewModel

import androidx.lifecycle.ViewModel
import com.example.affsub2_test.Model.NetworkService
import com.example.affsub2_test.Model.Profile
import com.example.affsub2_test.Model.ProfileRepository
import kotlinx.coroutines.*
import java.io.Serializable
import kotlin.coroutines.CoroutineContext

class ProfileViewModel : ViewModel(), Serializable {
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)
    private val repository = ProfileRepository(NetworkService.getSevice())

    private fun fillProfilesList(): Unit {
        for (i in 1..20) {
            var profile: Profile? = null
            runBlocking {
                scope.async {
                    profile = repository.getProfile()
                }.await()
            }
            profiles.add(profile!!)
        }
    }

    fun getProfilesList(): ArrayList<Profile> {
        if(profiles.isEmpty()) {
            fillProfilesList()
        }
        return profiles
    }

    fun getProfile(id: Int) = profiles.get(id)

    companion object {
        val profiles: ArrayList<Profile> = ArrayList()
    }
}