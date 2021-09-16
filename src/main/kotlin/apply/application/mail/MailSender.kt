package apply.application.mail

interface MailSender {
    fun send(toAddress: String, subject: String, body: String)

    fun sendBCC(toAddresses: Array<String>, subject: String, body: String)
}
