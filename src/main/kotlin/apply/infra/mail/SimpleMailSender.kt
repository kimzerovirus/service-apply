package apply.infra.mail

import apply.application.mail.MailSender
import org.apache.commons.io.IOUtils
import org.springframework.boot.autoconfigure.mail.MailProperties
import org.springframework.core.io.ByteArrayResource
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class SimpleMailSender(
    private val mailProperties: MailProperties,
    private val mailSender: JavaMailSender
) : MailSender {
    override fun send(toAddress: String, subject: String, body: String) {
        val message = mailSender.createMimeMessage()
        MimeMessageHelper(message).apply {
            setFrom(mailProperties.username)
            setTo(toAddress)
            setSubject(subject)
            setText(body, true)
        }
        mailSender.send(message)
    }

    override fun sendBCC(
        toAddresses: Array<String>,
        subject: String,
        body: String,
        files: Array<MultipartFile>
    ) {
        val message = mailSender.createMimeMessage()
        val mimeMessageHelper = MimeMessageHelper(message, true).apply {
            setFrom(mailProperties.username)
            setBcc(toAddresses)
            setSubject(subject)
            setText(body, true)
        }
        for (multiPartFile in files) {
            mimeMessageHelper.addAttachment(
                multiPartFile.originalFilename!!,
                ByteArrayResource(IOUtils.toByteArray(multiPartFile.inputStream))
            )
        }
        mailSender.send(message)
    }
}
