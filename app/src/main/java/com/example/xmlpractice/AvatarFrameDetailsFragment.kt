package com.example.xmlpractice

import AvatarFrameAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlpractice.models.AvatarFrameModel


class AvatarFrameDetailsFragment : Fragment() {

    private val frameList = listOf(
        AvatarFrameModel("Heart of Time","10000/7d",R.drawable.f1,false),
        AvatarFrameModel("Diamond of Love","12000/30d",R.drawable.f8,false),
        AvatarFrameModel("Azure Wings","8000/7d",R.drawable.f9,false),
        AvatarFrameModel("Flower Crown","25000/15d",R.drawable.f10,false),
        AvatarFrameModel("Fantasy Star","45000/30d",R.drawable.f4,false),
        AvatarFrameModel("Dragon Ball","32000/30d",R.drawable.f11,false),

    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_avatar_frame_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ivFrame: ImageView = view.findViewById(R.id.ivFrame)
        val tvValidity: TextView = view.findViewById(R.id.tvValidity)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)


        val recyclerView: RecyclerView = view.findViewById(R.id.rvFrameAvatar)

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = AvatarFrameAdapter(frameList) { selectedItem ->
            val dialog = PurchaseConfirmationDialogFragment.newInstance(
                title = selectedItem.title,
                price = selectedItem.subtitle,
                imageResId = selectedItem.imageResId
            )
            dialog.setOnPurchaseConfirmedListener(object : PurchaseConfirmationDialogFragment.OnPurchaseConfirmedListener {
                override fun onPurchaseConfirmed(imageResId: Int, validityDays: Int) {
                    ivFrame.setImageResource(imageResId)


                }
            })
            dialog.show(parentFragmentManager, "PurchaseConfirmationDialogFragment")
        }

    }

}
