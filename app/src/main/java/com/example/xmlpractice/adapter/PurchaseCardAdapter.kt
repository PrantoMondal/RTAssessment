package com.example.xmlpractice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlpractice.R
import com.example.xmlpractice.models.PurchaseCardModel

class PurchaseCardAdapter(private val purchaseList: List<PurchaseCardModel>) :
    RecyclerView.Adapter<PurchaseCardAdapter.PurchaseCardViewHolder>() {

    class PurchaseCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.purchaseCardImage)
        val title: TextView = itemView.findViewById(R.id.purchaseCardTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseCardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.purchase_card, parent, false)
        return PurchaseCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: PurchaseCardViewHolder, position: Int) {
        val item = purchaseList[position]
        holder.image.setImageResource(item.imageResId)
        holder.title.text = item.title
    }

    override fun getItemCount(): Int = purchaseList.size
}
