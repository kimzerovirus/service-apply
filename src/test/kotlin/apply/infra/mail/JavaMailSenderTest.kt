package apply.infra.mail

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import support.test.IntegrationTest

@Disabled
@IntegrationTest
class JavaMailSenderTest(private val javaMailSender: SimpleMailSender) {

    @Test
    fun `성공적인 전송`() {
        javaMailSender.send("target@mail.com", "subject", "body")
    }

    @Test
    fun `BCC 전송`() {
        javaMailSender.sendBCC(arrayOf("target1@mail.com", "target2@mail.com"), "subject", "body")
    }
}
