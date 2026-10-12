# Java Generics Practice

## About
This folder contains my Java Generics practice exercises.
I created these examples to understand how generic classes and methods work.
## Topics Covered
- Generic Classes
- Generic Methods
- Multiple Type Parameters
- Type Inference
- Static and Non-Static Methods
- Comparing Object Values
- Bounded Type Parameters
- Comparable Interface and compareTo()
- Generic Algorithms

## Exercises
- 01-generic-class : I created Kutu and Main classes. Kutu is a generic class. I used Kutu in Main. In Main I created a Kutu object and I changed a stored value, and printed the results. I also learned that I can create multiple objects from the same generic class using different data types.
- 02-generic-method : I created Yardimci and Main classes. Yardimci is a non-generic class that contains generic methods. But in Yardimci class I wrote generic methods. I practiced calling static and non-static methods using different data types.
- 03-multiple-type-parameters : I created a generic Pair class with two type parameters: K and V. In Main, I created a product object called urun and printed its key and value.
- 04-generic-comparison : I created a generic compare method in the Util class. In Main, I created three Pair objects and compared their keys and values using this method.
- 05 - Generic Find Max : I created a generic `findMax()` method to find the largest element in an array. I used `Comparable<T>` and `compareTo()` to compare different data types. I also created an `Urun` class that implements `Comparable<Urun>` to compare products by their prices.

## What I Learned
- I learned how to create and use generic classes and methods in Java.
- I learned the difference between generic classes and generic methods.
- I practiced calling static and non-static methods.
- I learned how to use multiple type parameters like `<K, V>`.
- I learned that two different objects can have the same values.
- I learned how to restrict generic types using `extends`.
- I learned how to use `Comparable<T>` and `compareTo()` to compare objects.
- I learned that `Number` does not implement `Comparable<Number>`, but classes like `Integer` and `Double` implement `Comparable` for their own types.
- I learned that I can change how objects are compared without changing the generic algorithm.