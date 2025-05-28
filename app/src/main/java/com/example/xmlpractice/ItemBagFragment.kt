package com.example.xmlpractice

import CardAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlpractice.databinding.FragmentItemBagBinding
import com.example.xmlpractice.models.ItemCardModel

class ItemBagFragment : Fragment() {

    private var _binding: FragmentItemBagBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemBagBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val recyclerViewItems = view.findViewById<RecyclerView>(R.id.recyclerViewItems)
        recyclerViewItems.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val recyclerViewEnhance = view.findViewById<RecyclerView>(R.id.recyclerViewEnhance)
        recyclerViewEnhance.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val tools = listOf(
            ItemCardModel("Heart of Time","8 Day", R.drawable.f1),
            ItemCardModel("Fantasy Star","15 Day",  R.drawable.f2),
            ItemCardModel("Audio Wave","120 Day",  R.drawable.f3),
            ItemCardModel("Fantasy Star","15 Day",  R.drawable.f4),
        )
        val myItems = listOf(
            ItemCardModel("Heart of Time","8 Day", R.drawable.f1),
            ItemCardModel("Fantasy Star","15 Day",  R.drawable.f4),
            ItemCardModel("Flower Grid","120 Day",  R.drawable.f5),
        )
        val enhanceEffects = listOf(
            ItemCardModel("Pegasus","15 Days", R.drawable.f2),
            ItemCardModel("Pegasus","65 Days",  R.drawable.f6),
        )
        binding.recyclerView.adapter = CardAdapter(tools)
        recyclerViewItems.adapter = CardAdapter(myItems)
        recyclerViewEnhance.adapter = CardAdapter(enhanceEffects)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_itemStoreFragment_to_avatarFrameDetailsFragment)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}