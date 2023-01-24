package hr.algebra.nasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import hr.algebra.nasa.databinding.ActivitySignUpBinding
import hr.algebra.nasa.framework.startActivity
import hr.algebra.nasa.utils.ToastUtils

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        setButtonListeners()
    }

    private fun setButtonListeners() {
        binding.singUpButton.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passEt.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity<SignInActivity>()
                        } else {
                            ToastUtils.show(this, it.exception.toString())
                        }
                    }
                } else {
                    ToastUtils.show(this, "Password is not matching")
                }
            } else {
                ToastUtils.show(this, "Empty Fields Are not Allowed !!")
            }
        }
    }
}