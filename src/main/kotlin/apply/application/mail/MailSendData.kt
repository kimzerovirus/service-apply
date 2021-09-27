package apply.application.mail

data class MailSendData(
    val subject: String,
    val content: String,
    val targetMails: List<String>
)
