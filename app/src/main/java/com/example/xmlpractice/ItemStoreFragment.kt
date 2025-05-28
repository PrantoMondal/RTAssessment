package com.example.xmlpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.xmlpractice.databinding.FragmentItemStoreBinding
import com.google.android.material.tabs.TabLayoutMediator

class ItemStoreFragment : Fragment() {

    private var _binding: FragmentItemStoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPageAdapter(childFragmentManager, lifecycle)
        binding.viewPage.adapter = adapter
        binding.viewPage.isUserInputEnabled = false

        TabLayoutMediator(binding.tabLayout, binding.viewPage) { tab, position ->
            tab.text = when (position) {
                0 -> "Item Bag"
                1 -> "Purchase"
                else -> null
            }
        }.attach()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}