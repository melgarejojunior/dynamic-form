package br.com.melgarejo.dynamicformsample.domain.entity


class InputElement(
        val id: String,
        val name: String,
        val type: Any,
        val required: Boolean = true,
        val enabled: Boolean = true
) {

    object Id {
        const val HEADER = "header"
        const val SELECTOR = "selector"
        const val TITLE = "title"
        const val BUTTON = "button"
        const val DESCRIPTION = "description"
        const val END_DATE = "end_date"
        const val ADD_MEMBER = "add_member"
        const val LINKS = "links"
        const val PHOTOS = "photos"
        const val CITY = "city"
    }


    class TypeDate(val description: String) {
        companion object {
            const val DATE_MASK = "##/##/####"
            const val COMPLETE_DATE_FORMAT = "EEEE dd/MMM/yyyy"
            const val UI_DATE_FORMAT = "dd/MM/yyyy"
            const val API_DATE_FORMAT = "yyyy-MM-dd"
        }
    }

    class TypePhoneNumber(val description: String) {
        companion object {
            const val PHONE_MASK_9_DIGITS = "(##) #####-####"
            const val PHONE_MASK_8_DIGITS = "(##) ####-####"
        }
    }

    class TypeText(val description: String, val inputType: String = TextType.NORMAL) {
        object TextType {
            const val TITLE = "title"
            const val NORMAL = "text"
            const val EMAIL = "email"
            const val CPF = "cpf"
            const val PASSWORD = "password"
            const val PASSWORD_CONFIRMATION = "password_confirmation"
        }
    }

    class TypeSelector(val values: List<EnumValue>)

    class TypeElementAdder(val description: String?, var values: List<Any>, val itemTypes: Int) {
        object Types {
            const val MEMBERS = 0
        }
    }

    class TypeTextList(val description: String?, val values: List<String>)

    class TypePhotoList(val description: String?)

    class TypeTaskDetailsHeader

    class TypeButton

    class TypeTitle

    class TypeExpandableText(val description: String?, val maxLines: Int?)

    class TypeSwitchButton(val description: String?)

    class TypeAutoComplete(val values: List<EnumValue>)

    class TypeAvatarImage

    class TypeContactProfile

}
