package com.example.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponent.databinding.FragmentConfirmDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ConfirmDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentConfirmDialogBinding? = null
    private val binding get() = _binding!!

    private val args:ConfirmDialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentConfirmDialogBinding.bind(view)

        val receiverName = args.receiverName
        val amount = args.amount

        binding.tvMessage.text = "Do you want to send ₨$amount to $receiverName?"

        binding.btnYes.setOnClickListener {
            Toast.makeText(requireContext(), "$amount has been sent to $receiverName", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.btnNo.setOnClickListener {
            dismiss()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}