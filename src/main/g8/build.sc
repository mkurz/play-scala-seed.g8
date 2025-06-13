import mill._
import \$ivy.`com.lihaoyi::mill-contrib-playlib:`,  mill.playlib._

object $name;format="camel"$ extends RootModule with PlayModule {
    
  def scalaVersion = "2.13.15"
  def playVersion = "3.0.6"
  def twirlVersion = "2.0.7"

  object test extends PlayTests
}
