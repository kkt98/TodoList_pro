package com.kkt1019.todolist_pro.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.kkt1019.todolist_pro.databinding.FragmentTodoListBinding
import com.kkt1019.todolist_pro.model.TodoListModel
import com.kkt1019.todolist_pro.viewmodel.TodoListViewModel

class TodoListFragment : Fragment() {

    private val binding : FragmentTodoListBinding by lazy { FragmentTodoListBinding.inflate(layoutInflater) }
    private val todoListViewModel : TodoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.addButton.setOnClickListener{

            Toast.makeText(activity, "floatingbutton 테스트", Toast.LENGTH_SHORT).show()
            onFabClicked()

        }

        return binding.root
    }

    fun onFabClicked(){
        val todoListModel = TodoListModel(false, "테스트")
        todoListViewModel.addUser(todoListModel)
    } //TODO 여기서부터 다시

}