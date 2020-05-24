# Android

## Kotlin

### Variable

- var（variable）：可变变量，类型由 Kotlin 自动推导
- val（value）：常量，相当于 final

``` kotlin
//显式声明
var a : Int
//显式声明并赋值
var a : Int = 10
```

> Tips:
>
> 日常开发应主要用 val 声明变量，会使代码更加健壮。
>
> kotlin 中不再使用分号作为语句的结尾，不过貌似也没有像 python 那样严格缩进呢，这点挺神奇的。

### Function

``` kotlin
fun getMax(a: Int, b: Int): Int{
    return max(a, b)
}
```

- fun：声明函数
- getMax：函数名
- a：变量名
- a: Int：a 的类型是 Int
- 括号后的 :Int：方法返回值，可选

**lambda 表达式**

> ```kotlin
> fun getMax(a: Int, b: Int): Int = max(a, b)
> ```

### Logic Control

#### if else

类似三目运算符

``` kotlin
fun getMax(a: Int, b: Int): Int = if(a > b) a else b
```

> 可读性还蛮好的

#### when

kotlin 中的 when 类似于 switch，不过它更加强大，简洁

**值匹配**

``` kotlin
fun getScore(name: String) = when (name){
    "Tom" -> 64
    "Jim" -> 77
    "Mike" -> 48
    else -> 0
}
```

- when：传入一个参数，用这个去匹配其中的值

- "Tom" ：相当于其中一个 case
- ->{}：执行匹配到的语句，如果只有一句可以省略 {}
- 最后需要 else，来返回未匹配成功的 case

**类型匹配**

除了直接匹配值以外，还可以匹配类型

``` kotlin
fun checkNumber(num: Number) = when(num){
    is Int -> println("num is Int")
    is Double -> println("num is double")
    else -> print("wrong type")
}
```

**is**

可以用 `object is XXType` 来该判断是否是某个类型（子类型）

**无参情况**

这也算是一种语法糖了，我们有时候可以省略参数达到更加简洁的效果

``` kotlin
fun getScore(name: String) = when{
  name == "Tom" -> 86
  name == "Jim" -> 77
  else -> 0
}
```

这里我们不能直接写 "Tom" 而是必须要用一个逻辑表达式（看上去反而代码量变多了？）这样的灵活性倒是也高了一些。

### Loop

#### **Range**

在 Kotlin 中可以使用 `1..10` 来表示 [1, 10] 的闭区间，在 for 循环中我们通常可以这样使用

``` kotlin
    for(i in 0..10){
        println(i)
    }
```

看上去蛮简洁的，而且可阅读性很好，我爱了。

#### **左闭右开区间**

``` kotlin
var range = 0 until 10
```

这样我们可以创造一个 [0, 10) 的左闭右开区间，平常用的还蛮多的。

#### **更加复杂的情况**

**步长**

如果我们想要控制步长，那么可以在 `for` 中间使用 `step` 关键字

``` kotlin
    for(i in 0..10 step 2){
        println(i)
    }
```

**降序**

如果我们想要降序访问一个 range 那么可以使用 `downTo` 关键字

``` kotlin
    for(i in 10 downTo 1 step 2){
        println(i)
    }
```

### Kotlin 面向对象编程

#### 继承

Kotlin 中，普通的类无法直接被继承，如果我们想要一个类能够被继承，那么需要用 open 手动打开

``` kotlin
open class Person{}
```

然后要继承至这个类，需要使用  `class CurClass : ClassName(){}`  来继承，`extend` 关键字被替换成了 `:`

> 抽象类与 Java 一致

为什么被继承的类还需要一对括号呢 ？

#### 主构造函数 与 次构造函数

主构造函数

``` kotlin

class Student(var sno: String, var grade: Int) : Person(){}
```

Init 函数

``` kotlin
class Student(var sno: String, var grade: Int) : Person(){
    init {
        print(sno+grade.toString())
    }
}
```

可以在 init 中间执行一些初始化逻辑

好了，那么这个主函数与 Person 的那对括号有什么区别呢

继承规定：子类在进行初始化的时候必须调用父类型的构造函数，所以这里我们是确定要调用父类的哪个构造函数

我们现在改造 Person

``` kotlin
open class Person(var name: String, var age: Int){
//    val name = "Brian"
//    val age = 0

    fun eat(){
        println(name + "is eating. He is "+age+" years old")
    }
}
```

> 这里我们在主构造函数中定义了 name 和 age，就不能在成员中再次声明了，否则会冲突

> 另外一点是，在声明成员的时候必须指定类型

然后我们来看看继承的类应该如何调用该构造函数

``` kotlin
class Student(var sno: String, var grade: Int, name: String, age: Int) : Person(name, age){
    init {
        print(sno+grade.toString())
    }
}
```

首先，子类必须在构造时传入两个参数，不过这两个参数不是 `var / val`  新定义的，而是直接传入

⚠️注意：这里 name 前面没有声明关键字），然后传给 Person。

创建一个 Student

``` kotlin
val s = Student("01", 5, "Brian", 22)
```

需要连着父类的构造函数一起传

#### 次构造函数

可以通过 `constructor` 重载构造函数，可以创建多个构造方式

 ```kotlin
class Student(var sno: String, var grade: Int, name: String, age: Int) : Person(name, age){
    
    init {
        println("sno:" + sno + "grade" 
                + grade.toString()+"name:" + name + "age:" + age.toString())
    }

    constructor(name :String, age: Int) : this("00",0,name,age){}

    constructor():this("00", 0){}
}
 ```

通过 `this` 可以调用已有的构造器

``` kotlin
		val s1 = Student("01", 5, "Brian", 22)
    val s2 = Student("02", 22)
    val s3 = Student()
```

像这样，我们可以通过三个构造函数初始化对象。

> 特殊情况：
>
> 如果一个类没有定义**主构造函数**吗，但是定义了次构造函数，那么它就是没有主构造函数的。
>
> ``` kotlin
> class Student : Person{
>   constructor(name: String, age: Int) : super(name, age){}
> }
> ```
>
> 这里看到，我们继承的时候不再需要 `Person()` 的括号了，因为我们没有主构造函数，所以调用父类的构造函数，被放在了 `constructor` 中直接调用 `super`。

#### 接口

接口和 Java 基本一致。

``` kotlin
interface Study{
    fun readBook()
    fun doHomeWork()
}
```

然后在 Student 中进行实现

``` kotlin

class Student(
  var sno: String, var grade: Int, name: String, age: Int) 
: Person(name, age), Study{

    override fun readBook() {
        println("readBook")
    }

    override fun doHomeWork() {
        println("readBook")
    }
}
```

这样我们可以在接口中进行统一实现，这也是多态的一部分

``` kotlin
fun doStudy(study: Study){
    study.doHomeWork()
    study.readBook()
}
```

> 接口中的方法可以有默认实现
>
> ``` kotlin
> interface Study{
>     fun readBook()
>     fun doHomeWork(){
>         println("doHomeWork")
>     }
> }
> ```
>
> 这样实现 Study 的类可以仅实现 readBook，而 doHomeWork 用默认实现

##### 函数可见性修饰符

| 修饰符    | 含义                       |
| --------- | -------------------------- |
| public    | 外部可访问（默认）         |
| private   | 当前类内部可见             |
| protected | 当前类，子类，同一包下可见 |
| internal  | 当前模块下的类可见         |
|           |                            |

#### 数据类与单例类

##### 数据类：data 关键字

> 数据类通常需要重写 `equals`、`hashCode`、`toString` 方法，重写了`equals`必须重写`hashCode`，否则会导致 HashMap，HashSet 等 hash 方法无法正常工作。

``` kotlin
data class CellPhone(val brand: String, val price: Double)
```

在 kotlin 中使用 data 声明这个类，就会自动为您完成 `equals`、`hashCode`、`toString` 等固定实际逻辑无意义的方法会自动生成。

##### 单例类：object 关键字

该关键字会为我们实现懒汉模式的单例类，以后拿这个类就可以通过**类名**直接获得**该类的单例对象**

``` kotlin
object Singleton{
  fun test(){}
}

fun main(){
  val s = Singleton
  s.test()
}
```

> 点评：真香

#### Lambda 编程

