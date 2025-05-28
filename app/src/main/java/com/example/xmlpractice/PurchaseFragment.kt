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
import com.example.xmlpractice.adapters.PurchaseCardAdapter
import com.example.xmlpractice.databinding.FragmentPurchaseBinding
import com.example.xmlpractice.models.PurchaseCardModel

class PurchaseFragment : Fragment() {

    private var _binding: FragmentPurchaseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPurchaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerViewPurchase = view.findViewById<RecyclerView>(R.id.recyclerViewPurchase)
        recyclerViewPurchase.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val tools = listOf(
            PurchaseCardModel(R.drawable.f1,"Heart of Time"),
            PurchaseCardModel(R.drawable.f7,"Entrance Effects"),
        )
        recyclerViewPurchase.adapter = PurchaseCardAdapter(tools)

        binding.purchaseButton.setOnClickListener {
                findNavController().navigate(R.id.action_itemStoreFragment_to_enhanceEffectFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}