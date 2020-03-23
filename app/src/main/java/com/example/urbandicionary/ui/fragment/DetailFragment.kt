package com.example.urbandicionary.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.urbandicionary.R
import com.example.urbandicionary.databinding.FragmentDefinitionDetailBinding
import com.example.urbandicionary.ui.activity.MainActivity
import com.example.urbandicionary.utils.ApiResponse
import com.example.urbandicionary.viewmodel.DefinitionViewModel


class DetailFragment : Fragment() {

    private lateinit var definitionViewModel: DefinitionViewModel
    private lateinit var definitionDetailBinding: FragmentDefinitionDetailBinding

    private var position: Int? = 0

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        position = arguments.let { it?.getInt("position") }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        actionBarSettings()
        definitionDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_definition_detail, container, false)
        return definitionDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        definitionViewModel = ViewModelProviders.of(activity!!).get(DefinitionViewModel::class.java)
        definitionViewModel.getDefinitions().observe(viewLifecycleOwner, Observer {
            setDataOnView(it)
        })
    }


    private fun setDataOnView(data: ApiResponse) {

        val definition = data.let { it ->
            it.data.let { it ->
                it?.results?.let {
                    it[position!!]
                }
            }
        }


        definitionDetailBinding.apply {
            tvTerm.text = definition?.word
            tvDefinition.text = definition?.definition
            tvAutor.text = definition?.author
            tvExample.text = definition?.example
            thumbUpRate.text = definition?.thumbsUp.toString()
            thumbDowmRate.text = definition?.thumbsDown.toString()
        }


    }

    private fun actionBarSettings(){

        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
