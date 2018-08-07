package br.com.melgarejo.dynamicformsample.presentation.elements

import br.com.melgarejo.dynamicformsample.domain.entity.ElementInputError
import br.com.melgarejo.dynamicformsample.domain.entity.InputElement
import br.com.melgarejo.dynamicformsample.domain.entity.InputValue
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject


abstract class InputElementViewModel(val element: InputElement) {
    abstract val selectedValue: InputValue?

    var errorSubject: PublishSubject<ElementInputError> = PublishSubject.create()
    var disposables = CompositeDisposable()

    fun setError(error: ElementInputError) {
        errorSubject.onNext(error)
    }

    abstract fun setSelectedValue(inputValue: InputValue?)
}
