package apply.ui.api

import apply.application.mail.MailSendData
import apply.application.mail.MailService
import org.apache.commons.io.IOUtils
import org.springframework.core.io.ByteArrayResource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/mail")
class MailRestController(
    private val mailService: MailService
) {
    @PostMapping
    fun sendMail(
        @RequestPart(value = "request") request: MailSendData,
        @RequestPart(value = "files") files: Array<MultipartFile>,
    ): ResponseEntity<Unit> {
        val inputStreamFiles =
            files.associate { (it.originalFilename!! to ByteArrayResource(IOUtils.toByteArray(it.inputStream))) }
        mailService.sendMailsByBCC(request, inputStreamFiles)
        return ResponseEntity.noContent().build()
    }
}
