package com.example.selfswcond.data

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "ответ")
data class Response(var message:String)