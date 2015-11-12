package models

import play.api.libs.json.Json
import org.joda.time.DateTime

case class Product(id:Int,clientIdType: String ,clientId:Int, productType: String,productName: String,  productBalance: Double)

object ProductFormats{
    
    implicit val ProductFormat = Json.format[Product]
}