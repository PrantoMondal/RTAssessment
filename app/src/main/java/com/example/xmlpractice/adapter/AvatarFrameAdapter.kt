import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlpractice.R
import com.example.xmlpractice.models.AvatarFrameModel

class AvatarFrameAdapter(
    private val frameList: List<AvatarFrameModel>,
    private val onItemClick: (AvatarFrameModel) -> Unit,

    ) :
    RecyclerView.Adapter<AvatarFrameAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.cvAvatarImage)
        val title: TextView = itemView.findViewById(R.id.tvAvatarTitle)
        val subtitle: TextView = itemView.findViewById(R.id.tvAvatarSubtitle)

        fun bind(item: AvatarFrameModel) {
            image.setImageResource(item.imageResId)
            title.text = item.title
            subtitle.text = item.subtitle
            itemView.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.avatar_frame_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val frameModel = frameList[position]
        holder.bind(frameModel)
    }


    override fun getItemCount(): Int = frameList.size
}
