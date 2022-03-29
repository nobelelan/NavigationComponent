package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.databinding.FragmentChooseReceiverBinding
import com.example.navigationcomponent.databinding.FragmentHomeBinding

class ChooseReceiverFragment : Fragment() {

    private var _binding: FragmentChooseReceiverBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentChooseReceiverBinding.bind(view)

        binding.btnNext.setOnClickListener {
            val receiverName = binding.etReceiverName.text.toString()

            val action = ChooseReceiverFragmentDirections
                .actionChooseReceiverFragmentToSendCashFragment(receiverName)
            findNavController().navigate(action)

        }
        binding.btnCancel.setOnClickListener{
            findNavController().popBackStack()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}