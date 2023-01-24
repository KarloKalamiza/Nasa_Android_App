package hr.algebra.nasa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.algebra.nasa.adapter.ItemPagerAdapter
import hr.algebra.nasa.databinding.ActivityItemPagerBinding
import hr.algebra.nasa.framework.fetchItems
import hr.algebra.nasa.model.Item

const val POSITION = "hr.algebra.nasa"

class ItemPagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemPagerBinding
    private lateinit var items : MutableList<Item>
    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intiPager()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun intiPager() {
        items = fetchItems()
        position = intent.getIntExtra(POSITION, position)
        binding.viewPager.adapter = ItemPagerAdapter(this, items)
        binding.viewPager.currentItem = position
    }
}