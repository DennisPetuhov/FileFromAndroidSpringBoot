package com.example.selfswcond

import com.example.selfswcond.servise.UploadFileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.multipart.MultipartResolver
import org.springframework.web.multipart.support.StandardServletMultipartResolver

@SpringBootApplication
class SelfSwcondApplication : CommandLineRunner {
    @Autowired
    lateinit var uploadFileService: UploadFileService

    override fun run(vararg args: String?) {
        uploadFileService.init()
            .onFailure { throw RuntimeException("System cannot start up because no uploads folder is set up") }
    }

    @Bean
    fun multipartResolver(): MultipartResolver? {
        return StandardServletMultipartResolver()
    }
}

fun main(args: Array<String>) {
    runApplication<SelfSwcondApplication>(*args)
}
