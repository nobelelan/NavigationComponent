package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponent.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        val navController = findNavController()

        binding.btnViewBalance.setOnClickListener {
            val navOption = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()

            navController.navigate(R.id.viewBalanceFragment,null,navOption)
        }

        binding.btnTransactions.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewTransactionsFragment()
            navController.navigate(action)
        }

        binding.btnSendMoney.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToChooseReceiverFragment()
            navController.navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}