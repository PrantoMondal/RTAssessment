import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.xmlpractice.R
import com.example.xmlpractice.databinding.FragmentPurchaseConfirmationDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PurchaseConfirmationDialogFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentPurchaseConfirmationDialogBinding? = null
    private val binding get() = _binding!!
    private var selectedValidityDays = 7
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPurchaseConfirmationDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val title = arguments?.getString(ARG_TITLE) ?: "Default Title"
        val price = arguments?.getString(ARG_PRICE) ?: "0"
        val imageResId = arguments?.getInt(ARG_IMAGE_RES_ID) ?: R.drawable.f1

        binding.tvTitle.text = title
        binding.tvPrice.text = price.split("/")[0]
        binding.ivAvatarImage.setImageResource(imageResId)

        binding.chipGroup.check(R.id.btn7Days)
        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            selectedValidityDays = when (checkedId) {
                R.id.btn7Days -> 7
                R.id.btn15Days -> 15
                R.id.btn30Days -> 30
                else -> 7
            }
        }

        binding.btnCancel.setOnClickListener { dismiss() }
        binding.btnConfirm.setOnClickListener { onConfirmClicked() }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    private fun onValiditySelected(days: Int) {
        binding.btn7Days.isSelected = days == 7
        binding.btn15Days.isSelected = days == 15
        binding.btn30Days.isSelected = days == 30
    }


    private var listener: OnPurchaseConfirmedListener? = null

    fun setOnPurchaseConfirmedListener(listener: OnPurchaseConfirmedListener) {
        this.listener = listener
    }

    interface OnPurchaseConfirmedListener {
        fun onPurchaseConfirmed(imageResId: Int, tvPrice: String)
    }

    private fun onConfirmClicked() {
        val imageResId = arguments?.getInt(ARG_IMAGE_RES_ID) ?: R.drawable.f1
        val tvPrice = arguments?.getString(ARG_PRICE) ?: "0"

        listener?.onPurchaseConfirmed(imageResId, tvPrice)
        dismiss()
    }
    companion object {
        private const val ARG_TITLE = "title"
        private const val ARG_PRICE = "price"
        private const val ARG_IMAGE_RES_ID = "image_res_id"

        fun newInstance(title: String, price: String, imageResId: Int): PurchaseConfirmationDialogFragment {
            val fragment = PurchaseConfirmationDialogFragment()
            val args = Bundle().apply {
                putString(ARG_TITLE, title)
                putString(ARG_PRICE, price)
                putInt(ARG_IMAGE_RES_ID, imageResId)
            }
            fragment.arguments = args
            return fragment
        }
    }

}