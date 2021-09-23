package apply.application.mail

import org.springframework.core.io.ByteArrayResource

interface MailSender {
    fun send(toAddress: String, subject: String, body: String)

    fun sendBCC(toAddresses: Array<String>, subject: String, body: String, files: List<Pair<String, ByteArrayResource>>)
}
