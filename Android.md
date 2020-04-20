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









