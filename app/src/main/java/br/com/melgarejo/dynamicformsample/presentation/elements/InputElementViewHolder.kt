package br.com.melgarejo.dynamicformsample.presentation.elements

import android.content.Context
import android.support.design.widget.TextInputLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import br.com.melgarejo.dynamicformsample.R
import br.com.melgarejo.dynamicformsample.domain.entity.ElementErrorType
import br.com.melgarejo.dynamicformsample.domain.entity.ElementInputError
import br.com.melgarejo.dynamicformsample.domain.entity.InputValue

abstract class InputElementViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    protected val context: Context get() = itemView.context

    private lateinit var baseViewModel: InputElementViewModel


    open fun setViewModel(viewModel: InputElementViewModel, value: InputValue?, position: Int) {
        baseViewModel = viewModel
        baseViewModel.disposables.clear()
    }

    protected fun subscribeError(textInputLayout: TextInputLayout) {
        val errorDisposable = this.baseViewModel.errorSubject.subscribe(
                { setError(textInputLayout, it) },
                { /**/ }
        )
        this.baseViewModel.disposables.add(errorDisposable!!)
    }

    protected fun setError(textInputLayout: TextInputLayout, error: ElementInputError) {
        if (error.elementInputError != ElementErrorType.NOT_AN_ERROR) {
            textInputLayout.error = getErrorString(error)
        } else {
            textInputLayout.error = null
            textInputLayout.editText?.error = null
        }
    }

    fun getErrorString(error: ElementInputError) = when (error.elementInputError) {
        ElementErrorType.EMPTY -> context.getString(R.string.validation_empty_element)
        ElementErrorType.INVALID_VALUE -> context.getString(R.string.validation_invalid_value)
        else -> throw RuntimeException("Unknown errorSubject message for errorSubject type ${error.elementInputError}")
    }
}
