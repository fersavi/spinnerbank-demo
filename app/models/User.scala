package models

import play.api.libs.json.Json
import org.joda.time.DateTime
import models.ProductFormats._

case class User( documentType: String , documentNumber: Int,  name: String, lastName: String, products:List[Product]){
   



  def toJson() = Json.obj(
    "documentType" -> this.documentType,
    "documentNumber" -> this.documentNumber,
    "name" -> this.name,
    "lastName" -> this.lastName,
    "products" -> Json.toJson(Json.toJson(products))
  )
}

object UserFormats{
    
    implicit val UserFormat = Json.format[User]
}

