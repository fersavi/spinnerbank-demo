package models

import play.api.libs.json.Json
import org.joda.time.DateTime

case class Movement (id: Int,idProduct:Int,valueMovement: Double, description: String, dateMovement:String)

object MovementFormats{
    
    implicit val MovementFormat = Json.format[Movement]
}