package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationcomponent.databinding.FragmentHomeBinding
import com.example.navigationcomponent.databinding.FragmentViewBalanceBinding

class ViewBalanceFragment : Fragment() {

    private var _binding: FragmentViewBalanceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_balance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentViewBalanceBinding.bind(view)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}