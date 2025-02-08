package gaur.himanshu.youtube.goglesignin.signin

import cocoapods.FirebaseAuth.FIRAuth
import cocoapods.FirebaseAuth.FIRGoogleAuthProvider
import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIApplication
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GoogleAuthenticator {

    @OptIn(ExperimentalForeignApi::class)
    suspend fun login() = suspendCoroutine<String?> { continuation ->

        val rootUiView = UIApplication.sharedApplication
            .keyWindow?.rootViewController

        if (rootUiView == null) {
            continuation.resume(null)
        } else {
            GIDSignIn.sharedInstance
                .signInWithPresentingViewController(rootUiView) { gidSignInResult, nsError ->
                    if (nsError != null) {
                        println("Something went wrong during signInWithPresentingViewController $nsError")
                    } else {
                        val idToken = gidSignInResult?.user?.idToken
                        val profile = gidSignInResult?.user?.profile
                        if (idToken != null) {
                            registerUserOnFirebase(
                                idToken.tokenString,
                                accessToken = gidSignInResult?.user?.accessToken?.tokenString.toString(),
                                continuation
                            )
                        } else {
                            continuation.resume(null)
                        }
                    }
                }
        }

    }

    @OptIn(ExperimentalForeignApi::class)
    fun registerUserOnFirebase(
        idToken: String,
        accessToken: String,
        continuation: Continuation<String?>
    ) {
        val firebaseAuth = FIRAuth.auth()

        val googleAuthProvider = FIRGoogleAuthProvider.credentialWithIDToken(idToken, accessToken)
        firebaseAuth.signInWithCredential(googleAuthProvider) { firAuthDataResult, nsError ->
            if (nsError != null) {
                println("something went wrong signInWithCredential -> ${nsError}")
            } else {
                val user = firAuthDataResult?.user()
                val displayName = user?.displayName()
                continuation.resumeWith(Result.success(displayName))
            }
        }
    }

}