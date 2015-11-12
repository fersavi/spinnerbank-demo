package models

import play.api.libs.json.Json
import org.joda.time.DateTime

case class User( documentType: String , documentNumber: Int,  name: String, lastName: String)

object UserFormats{
    
    implicit val UserFormat = Json.format[User]
}