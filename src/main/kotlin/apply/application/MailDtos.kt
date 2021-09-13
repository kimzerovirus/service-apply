package apply.application

data class MailSendData(
    val subject: String,
    val content: String,
    // TODO: file upload type?
    val targetMails: List<String>

)
