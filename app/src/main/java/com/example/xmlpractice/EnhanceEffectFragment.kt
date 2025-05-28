package com.example.xmlpractice

import AvatarFrameAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlpractice.models.AvatarFrameModel

class EnhanceEffectFragment : Fragment() {


    private val enhanceEffectList = listOf(
        AvatarFrameModel("Invincible Fighter","15000/10d",R.drawable.e1,false),
        AvatarFrameModel("Ferrari 458","12000/15d",R.drawable.f2,false),
        AvatarFrameModel("Cool Sports Car","8000/7d",R.drawable.e3,false),
        AvatarFrameModel("Eagle Artiler","25000/15d",R.drawable.e4,false),
        AvatarFrameModel("Butterfly Jewelry","45000/30d",R.drawable.f6,false),
        AvatarFrameModel("Helicopter Ride","32000/30d",R.drawable.e5,false),

        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_enhance_effect, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val image: ImageView = view.findViewById(R.id.ivSelectedImage)
        val recyclerView: RecyclerView = view.findViewById(R.id.rvEnhanceEffect)
        val tvValidity: TextView = view.findViewById(R.id.tvValidity)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = AvatarFrameAdapter(enhanceEffectList) { selectedItem ->
            image.setImageResource(selectedItem.imageResId)
            tvPrice.text = selectedItem.subtitle.split("/")[0]
            tvValidity.text = selectedItem.subtitle.split("/")[1].replace("d"," Days")
        }
    }
}