package com.example.viewpagertut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.view.marginEnd
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagertut.databinding.ActivityMainBinding
import com.example.viewpagertut.databinding.VplayoutBinding

class MainActivity : AppCompatActivity() {
    private var binding : VplayoutBinding? = null
    private  var viewPager2: ViewPager2? = null
    private  val pager2Callback = object :ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            if (position == TextListObj.textSlide.size - 1){
                binding?.nextBtn?.text    = "Get Started"
                binding?.previousBtn?.setOnClickListener{
                    viewPager2?.currentItem = position - 1

                }

            }
            else if  (position == 0){
                binding?.previousBtn?.isVisible = false
//                binding?.controllerBtn?.layo

                binding?.nextBtn?.setOnClickListener{
                    viewPager2?.currentItem = position+ 1

                }
                binding?.previousBtn?.setOnClickListener{
                    viewPager2?.currentItem = position - 1

                }

            }
            else {
                binding?.previousBtn?.isVisible = true

                binding?.nextBtn?.text    = "Next"
                binding?.nextBtn?.setOnClickListener{
                    viewPager2?.currentItem = position+ 1

                }
                binding?.previousBtn?.setOnClickListener{
                    viewPager2?.currentItem = position - 1

                }

            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  VplayoutBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupViewPager(binding!!)

    }

    private fun setupViewPager (binding: VplayoutBinding){
        val adapter = TextDataAdapter(TextListObj.textSlide)
        viewPager2 = binding.pager
        viewPager2?.adapter = adapter
        viewPager2?.registerOnPageChangeCallback(pager2Callback)
        binding.dotsIndicator.setViewPager2(viewPager2!!)

    }

    override fun onDestroy() {
        super.onDestroy()
        viewPager2?.unregisterOnPageChangeCallback(pager2Callback)



    }





}