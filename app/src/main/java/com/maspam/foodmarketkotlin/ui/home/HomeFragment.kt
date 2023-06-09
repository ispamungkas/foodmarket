package com.maspam.foodmarketkotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maspam.foodmarketkotlin.databinding.FragmentHomeBinding
import com.maspam.foodmarketkotlin.model.dummy.HomeModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var datas : ArrayList<HomeModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onResume() {
        super.onResume()

        startRecycleView()

        startPagerAdapter()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun dataDummy() : ArrayList<HomeModel> {
        datas = ArrayList()
        datas.add(HomeModel("Kacang", "", 4f))
        datas.add(HomeModel("Kacang", "", 4f))
        datas.add(HomeModel("Kacang", "", 4f))
        datas.add(HomeModel("Kacang", "", 4f))
        return datas
    }

    private fun startRecycleView(){
        binding.rvHorizontal.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = HomeAdapter(dataDummy()){dataHomeModel, position ->
                Toast.makeText(context, "Contoh Toast", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startPagerAdapter() {
        binding.apply {
            val adapter = SectionPagerAdapter(
                childFragmentManager
            )

            viewPager.adapter = adapter
            tabLayout.setupWithViewPager(viewPager)
        }
    }

}