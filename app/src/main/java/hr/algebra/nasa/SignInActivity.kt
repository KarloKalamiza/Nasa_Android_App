package hr.algebra.nasa

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import hr.algebra.nasa.databinding.ActivitySignInBinding
import hr.algebra.nasa.framework.startActivity
import hr.algebra.nasa.utils.ToastUtils

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var valueAnimator: ValueAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        setTextViewListeners()
        setButtonListeners()
    }

    private fun setTextViewListeners() {
        binding.signUpEt.setOnClickListener {
            startActivity<SignUpActivity>()
        }
    }

    private fun setButtonListeners() {
        binding.singInButton.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity<SplashScreenActivity>()
                    } else {
                        ToastUtils.show(this, it.exception.toString())
                    }
                }
            } else {
                ToastUtils.show(this, "Empty fields are not allowed")
            }
        }
    }
}