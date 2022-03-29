package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.navigationcomponent.databinding.FragmentAboutAppBinding
import com.example.navigationcomponent.databinding.FragmentHomeBinding
import com.example.navigationcomponent.databinding.FragmentNotificationsBinding
import com.example.navigationcomponent.databinding.FragmentViewBalanceBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNotificationsBinding.bind(view)

        binding.lvNotifications.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, getNotifications())

    }

    private fun getNotifications(): List<String> {
        val notifications = mutableListOf<String>()
        for (i in 1..20){
            notifications.add("Notification # $i")
        }
        return notifications
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}