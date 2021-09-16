package apply.application.mail

import com.sun.istack.NotNull

data class MailSendData(
    @field:NotNull
    val subject: String,
    @field:NotNull
    val content: String,
    // TODO: file upload type?
    @field:NotNull
    val targetMails: List<String>
)
