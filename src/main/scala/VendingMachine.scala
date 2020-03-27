object Main{
  def main(args: Array[String]):Unit= {
    val machine = new VendingMachine
    machine.chocolateBar += 2
    machine.granolaBar += 1

    println(machine.buy("chocolate", 1.5))
    println(machine.buy("chocolate", 1.5))
    println(machine.buy("chocolate", 1.5))
  }
}

class VendingMachine {

  var chocolateBar = 0
  var granolaBar = 0

  var totalMoney = 0.0


  def buy(product: String, money: Double): String = {
    if(!isProductAvailabe(product)){
      "Sorry, product " + product + " not available"
    }else if(!isMoneyEnough(product, money)){
      "Please, insert more money!"
    }else{
      completeRequest(product, money)
    }
  }

  def isProductAvailabe(product: String): Boolean = {
    val productQuantity = {
      if(product == "chocolate") chocolateBar
      else if(product == "granola") granolaBar
      else 0
    }

    productQuantity > 0
  }

  def isMoneyEnough(product: String, money: Double): Boolean = {
    val cost = if(product == "chocolate") 1.5 else 1

    money >= cost
  }

  def completeRequest(product: String, money: Double): String = {
    collectMoney(money)
    releaseProduct(product)
    "There you go! Have a " + product + " bar"
  }

  def collectMoney(money: Double): Unit = {
    totalMoney += money
  }

  def releaseProduct(product: String): Unit = {
    if(product == "chocolate") chocolateBar -= 1
    else granolaBar -= 1
  }
}
