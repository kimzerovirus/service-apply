package apply.application.mail

import org.springframework.web.multipart.MultipartFile

interface MailSender {
    fun send(toAddress: String, subject: String, body: String)

    fun sendBCC(toAddresses: Array<String>, subject: String, body: String, files: Array<MultipartFile>)
}
