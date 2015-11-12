package controllers

import play.api._
import play.api.mvc._
import org.joda.time.DateTime
import play.api.mvc.{ Action, Controller, Request }
import play.api.libs.json.{Writes, Json, JsValue,JsArray, JsObject}

import models.MovementFormats._
import models.UserFormats._
import models.ProductFormats._
import models.Product
import models.User
import models.Movement

class Application extends Controller {
    

  var mov1 = new Movement(1,2,500.34,"Retiro",new DateTime().toString())
  var mov2 = new Movement(2,3,500,"Pago cuota",new DateTime().toString())
  var mov3 = new Movement(3,2,5500,"Reverso",new DateTime().toString())
  var mov4 = new Movement(4,2,500,"Avance",new DateTime().toString())
  var mov5 = new Movement(5,3,500,"Pago cuota",new DateTime().toString())
  var mov6 = new Movement(6,1,5500,"Abono",new DateTime().toString())
  var mov7 = new Movement(7,1,500,"Abono",new DateTime().toString())
  var mov8 = new Movement(8,4,500,"Pago interes",new DateTime().toString())
  var mov9 = new Movement(9,5,500,"Apertura",new DateTime().toString())
  var mov10 = new Movement(10,6,500,"Desembolso",new DateTime().toString())
    
  var movements = List(mov1,mov2,mov3,mov4,mov5,mov6,mov7,mov8,mov9,mov10)
    
  var producto1 = new Product(1,"cc",123,"Ahorro","CDT",200.25)
  var producto2 = new Product(2,"cc",123,"Debito","Cuenta corriente",2000000)
  var producto3 = new Product(3,"ce",456,"Credito","Vivienda",1500000)
  var producto4 = new Product(4,"ce",456,"Credito","Vehiculo",1500000)
  var producto5 = new Product(5,"ce",456,"Ahorro","CDT",200.25)
  var producto6 = new Product(6,"cc",123,"Credito","Credito gerencia",1500000)
  
  var products = List (producto1,producto2,producto3,producto4,producto5,producto6)
  
  var user1 = new User("cc",123,"Alexis","Rodriguez")
  var user2 = new User("ce",456,"Emmanuel","Velez")

    
  val error : JsValue = Json.parse("""{"error":404, " description": "not found"}""")    

  def index = Action {
    Ok(views.html.index("spinner-bank-api-internal"))
  }

  def findMovementById(idProduct:Int) = Action{
      // val pr = usuarios.filter(usuario =>  usuario.documentType == typeDocument && usuario.documentNumber == idUser)
      val result = movements.filter(movement =>movement.idProduct ==idProduct)
        if(result.size ==0) {
          Ok(error)
        }else {
          Ok(Json.toJson(result)).withHeaders("Access-Control-Allow-Origin" -> "*")
        }
      
  }
  
  def findProductsClient(documentType:String,documentNumber:Int) = Action{
      
      val result =products.filter(product => product.clientIdType == documentType && product.clientIdNumber == documentNumber)
      
      if(result.size ==0) {
          Ok(error)
        }else {
          Ok(Json.toJson(result)).withHeaders("Access-Control-Allow-Origin" -> "*")
        }
      
  }
    
  
  
}