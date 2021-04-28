package com.jitusolution.todoapp_160718035.view

import android.view.View
import android.widget.CompoundButton
import com.jitusolution.todoapp_160718035.model.Todo

interface TodoCheckedChangeListener {
    fun onTodoCheckChange(cb: CompoundButton, isChecked:Boolean, obj: Todo)
}
interface TodoEditClickListener {
    fun onTodoEditClick(v: View)
}

interface RadioClickListener {
    fun onRadioClick(v:View, obj:Todo)
}

interface TodoSaveChangesClickListener {
    fun onTodoSaveChangesClick(v: View, obj: Todo)
}

