object test
{
private var m=45
def display()
{
var obj1:test=new test
println("value in singleton object"+obj1.d)
}

}

class test
{
 import test._
 private var d=23
  def show( )
 { 
   println("value :"+m)
 }
}

object CompObjectEx
{
def main(args:Array[String])
{
var obj:test=new test
obj.show()
//here we can see that there is a method called by class name as we do in java with static method 
test.display()
}
}
