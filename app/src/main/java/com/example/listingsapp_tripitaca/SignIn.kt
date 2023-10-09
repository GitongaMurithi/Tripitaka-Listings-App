package com.example.listingsapp_tripitaca

import android.app.Activity
import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.listingsapp_tripitaca.databinding.ActivitySignInBinding
import com.example.listingsapp_tripitaca.signIn.GoogleClient
import com.google.android.gms.auth.api.identity.Identity.getSignInClient
import kotlinx.coroutines.launch

class SignIn : AppCompatActivity() {
    private lateinit var googleClient: GoogleClient

    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        googleClient = GoogleClient(this, getSignInClient(applicationContext))

        binding.signIn.setOnClickListener {
            lifecycleScope.launch {
                startGoogleSignIn()
            }
        }
    }

    private suspend fun startGoogleSignIn() {
        val intent = Intent()

        val intentSender: IntentSender? = googleClient.signIn(intent)

        if (intentSender != null) {
            try {
                startIntentSenderForResult(intentSender, 1, null, 0, 0, 0)
            } catch (e: IntentSender.SendIntentException) {
                e.printStackTrace()
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                lifecycleScope.launch {
                    val signInResult = googleClient.signInWithIntent(data!!)

                    if (signInResult.data != null) {
                        val intent = Intent(this@SignIn, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        val errorMessage = signInResult.errorMessage
                        if (errorMessage != null) {
                            Toast.makeText(this@SignIn,"$errorMessage", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Oops! Something went wrong", Toast.LENGTH_LONG).show()
            }
        }
    }
}