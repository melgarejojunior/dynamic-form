package br.com.melgarejo.dynamicformsample.domain.entity


enum class ElementErrorType(val value: String) {
    EMPTY("Campo obrigatório"),
    INVALID_VALUE("Valor Inválido"),
    /** Thanks to RxJava which doesn't allow to call onNext(null) with a PublishSubject **/
    NOT_AN_ERROR("Não é um erro")
}
