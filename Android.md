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

这里我们不能直接写 "Tom" 而是必须要用一个逻辑表达式（看上去反而代码量变多了？）

