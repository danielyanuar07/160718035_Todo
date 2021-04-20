package com.jitusolution.todoapp_160718035.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jitusolution.todoapp_160718035.R
import com.jitusolution.todoapp_160718035.viewmodel.DetailTodoViewModel
import kotlinx.android.synthetic.main.fragment_create_todo.*


class EditTodoFragment : Fragment() {
    private lateinit var viewModel: DetailTodoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailTodoViewModel::class.java)

        val uuid = EditTodoFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)

        txtJudulTodo.text = "Edit Todo"
        btnCreateTodo.text = "Save Changes"

        btnCreateTodo.setOnClickListener {
            val radio = view.findViewById<RadioButton>(radioGroupPriority.checkedRadioButtonId)
            viewModel.update(txtTitle.text.toString(),txtNotes.text.toString(),radio.tag.toString().toInt(),uuid)
            Toast.makeText(view.context,"TODO UPDATED",Toast.LENGTH_SHORT).show()
        }


        observeViewModel()

    }
    fun observeViewModel() {
        viewModel.todoLD.observe(viewLifecycleOwner, Observer {
            txtTitle.setText(it.title)
            txtNotes.setText(it.notes)

            when (it.priority) {
                1 -> radioLow.isChecked = true
                2 -> radioMedium.isChecked = true
                else -> radioHigh.isChecked = true
            }

        })
    }

}