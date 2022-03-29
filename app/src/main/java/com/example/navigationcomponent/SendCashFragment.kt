package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponent.databinding.FragmentHomeBinding
import com.example.navigationcomponent.databinding.FragmentSendCashBinding


class SendCashFragment : Fragment() {

    private var _binding: FragmentSendCashBinding? = null
    private val binding get() = _binding!!

    private val args : SendCashFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_cash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSendCashBinding.bind(view)

        binding.etAmount.setText(SampleData.defaultAmount.value.toString())
        SampleData.defaultAmount.observe(viewLifecycleOwner){
            binding.etAmount.setText(it.toString())
        }

        val receiverName = args.receiverName

        binding.tvReceiver.text = "Send cash to $receiverName"

        binding.btnSend.setOnClickListener {

            if(binding.etAmount.text.toString().isEmpty()) {
                Toast.makeText(requireContext(), "Enter some amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = binding.etAmount.text.toString().toLong()
            val action = SendCashFragmentDirections
                .actionSendCashFragmentToConfirmDialogFragment(receiverName, amount)
            findNavController().navigate(action)
        }

        binding.btnDone.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
            findNavController().navigate(action)
        }

        binding.btnCancel.setOnClickListener{
            findNavController().popBackStack(R.id.homeFragment, true)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}