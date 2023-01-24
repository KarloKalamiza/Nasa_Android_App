package hr.algebra.nasa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.algebra.nasa.databinding.ActivitySplashScreenBinding
import hr.algebra.nasa.framework.*

private const val DELAY = 2750L
const val DATA_IMPORTED = "hr.algebra.nasa.data_imported"

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        redirect()
    }

    private fun redirect() {

        if (getBooleanPreference(DATA_IMPORTED)) {
            callDelayed(DELAY) { startActivity<HostActivity>() }

        } else {
            if (isOnline()) {
                NasaService.enqueue(this)
            } else {
                callDelayed(DELAY) { finish() }
            }
        }
    }
}