package com.example.starwarsapi.feature.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.starwarsapi.core.base.BaseFragment
import com.example.starwarsapi.core.extantions.Log
import com.example.starwarsapi.databinding.FragmentDetailsPeopleBinding

class DetailsPeopleFragment : BaseFragment<FragmentDetailsPeopleBinding>() {
    override fun initBinding(inflater: LayoutInflater)= FragmentDetailsPeopleBinding.inflate(inflater)

    private val people by navArgs<DetailsPeopleFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log(people.url)
    }
}