package apply.ui.api

import apply.application.MailSendData
import apply.application.mail.MailService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/mail")
class MailRestController(private val mailService: MailService) {

    @PostMapping
    fun sendMail(@RequestBody request: MailSendData): ResponseEntity<Unit> {
        mailService.sendMails(request)
        return ResponseEntity.noContent().build()
    }
}
