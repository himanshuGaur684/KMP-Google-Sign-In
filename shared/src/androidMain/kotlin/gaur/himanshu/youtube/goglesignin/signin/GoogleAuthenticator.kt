package gaur.himanshu.youtube.goglesignin.signin

import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import androidx.credentials.exceptions.NoCredentialException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await

class GoogleAuthenticator(
    private val context: Context,
    private val credentialManager: CredentialManager
) {

    suspend fun login(): String {
        try {
            val googleIdOption = GetGoogleIdOption.Builder()
                .setServerClientId("458352816759-ls7libfra52161m07hrf4r1b5bn7pt54.apps.googleusercontent.com")
                .setAutoSelectEnabled(false)
                .setFilterByAuthorizedAccounts(false)
                .build()
            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            val result = credentialManager.getCredential(context, request)
            val credential = result.credential
            if (credential is CustomCredential && credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                val idToken = googleIdTokenCredential.idToken
                val authCredential = GoogleAuthProvider.getCredential(idToken, null)
                val fireBase = FirebaseAuth.getInstance()
                val user = fireBase.signInWithCredential(authCredential).await().user
                return user?.displayName.toString()
            }
            return "SOmething went wrong"
        } catch (e: NoCredentialException) {
            return "No email found in your device"
        } catch (e: GetCredentialException) {
            return "GetCredentialException"
        } catch (e: Exception) {
            return e.message.toString()
        }


    }

    fun logout() {
        FirebaseAuth.getInstance().signOut()
    }

}