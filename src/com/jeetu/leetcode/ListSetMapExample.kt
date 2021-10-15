package com.jeetu.leetcode



// Collection<T> is the root of the collection hierarchy.
// This interface represents the common behavior of a read-only collection: retrieving size,
//  Collection inherits from the Iterable<T> interface.

// ...........List .........................
//List is an ordered collection with access to elements by indices –
// Elements can occur more than once in a list.
//it include null
//Two lists are considered equal if they have the same sizes and structurally equal elements at the same positions
// An example of a list is a telephone number:
// it's a group of digits, their order is important, and they can repeat.

//public interface List<out E> : Collection<E> (source)

fun main(){
    listExample1()
    outPutListExample()
    //genericListExample()
    //mutableListExample()
    //arrayListExample()
    // ..difference list and arraylist ..
    //As you see, in some aspects lists are very similar to arrays.
    // However, there is one important difference: an array's size is defined upon initialization and is never changed;
    // in turn, a list doesn't have a predefined size; a list's size can be changed as a result of write operations:
    // adding, updating, or removing elements.

    //..List Specific operation
    //Lists support all common operations for element retrieval
    //elementAt(), first(), last()
    // get() can throw exception if passed indices will not there so to avoid this these function used.
    // getOrElse() lets you provide the function for calculating the default value to return if the index isn't present in the collection.
    // getOrNull() returns null as the default value.

    // exampleListOperation()
    //retriveSubList()
    //findElementPosition()

    //binarySearchExample()
    //sortElementExample()

    //listRelatedOperation()



    //.....Set .....
    //setoFExample()
    //mutableSetExample()
    //mutablesetExample1()

    //.......Map ......
    // mapExample()
    // mutableMapExample()
    //...map related operation
    // mapRelatedExample()
    // mapFilterExample()
    //plusMinusExample()
    addAndUpdateMapExample()
}

fun listRelatedOperation() {

    //output

    val numbers = setOf("one", "two", "three")

    println(numbers union setOf("four", "five"))  //order of first function would list first then second function
    //println(setOf("four", "five") union numbers)

    //println(numbers intersect setOf("two", "one"))
    //println(numbers subtract setOf("three", "four"))
    //println(numbers subtract setOf("four", "three"))
}

fun addAndUpdateMapExample() {
    //Mutable maps offer map-specific write operations. These operations let you change the map content using the key-based access to the values.
    //There are certain rules that define write operations on maps:
    //Values can be updated. In turn, keys never change: once you add an entry, its key is constant.
    //For each key, there is always a single value associated with it. You can add and remove whole entries.
    // put to add new entry in mutable map

    val numbersMap = mutableMapOf("one" to 1, "two" to 2)
    numbersMap.put("three", 3)
    println(numbersMap)

    numbersMap.putAll(setOf("four" to 4, "five" to 5))
    println(numbersMap)

    val previousValue = numbersMap.put("one", 11)
    println("value associated with 'one', before: $previousValue, after: ${numbersMap["one"]}")
    println(numbersMap)

    numbersMap["three"] = 3     // +=
    numbersMap += mapOf("four" to 4, "five" to 5)
    println(numbersMap)

    //To remove an entry from a mutable map, use the remove() function. When calling remove(), you can pass either a key or a whole key-value-pair.
    // If you specify both the key and value, the element with this key will be removed only if its value matches the second argument.
    numbersMap.remove("one")
    println(numbersMap)
    numbersMap.remove("three", 4)            //doesn't remove anything
    println(numbersMap)

    numbersMap.keys.remove("two")
    println(numbersMap)
    numbersMap.values.remove(3)
    println(numbersMap)


    /* val numbersMap1 = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
     numbersMap1 -= "two"
     println(numbersMap1)
     numbersMap1 -= "five"
     println(numbersMap1)*/
}

fun plusMinusExample() {
    //Due to the key access to elements, plus (+) and minus (-) operators work for maps differently
    // than for other collections. plus returns a Map that contains elements of its both operands:
    // a Map on the left and a Pair or another Map on the right. When the right-hand side operand contains entries
    // with keys present in the left-hand side Map, the result map contains the entries from the right side.
    val numbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(numbersMap + Pair("four", 4))
    println(numbersMap + Pair("one", 10))
    println(numbersMap + mapOf("five" to 5, "one" to 11))

    //Output
    /* val numbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
     println(numbersMap - "one")
     println(numbersMap - listOf("two", "four"))*/
}

fun mapFilterExample() {
    // You can filter maps with the filter() function as well as other collections.
    // When calling filter() on a map, pass to it a predicate with a Pair as an argument.
    // This enables you to use both the key and the value in the filtering predicate.

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10}
    println(filteredMap)

    val filteredKeysMap = numbersMap.filterKeys { it.endsWith("1") }  // return new map with and its check to only keys
    val filteredValuesMap = numbersMap.filterValues { it < 10 } // return new map with and its check to only values
    //filterKeys() , filterValues()
    println(filteredKeysMap)
    println(filteredValuesMap)
}


fun mapRelatedExample() {
    // For retrieving a value from a map, you must provide its key as an argument of the get() function.
    // The shorthand [key] syntax is also supported. If the given key is not found, it returns null.
    // There is also the function getValue() which has slightly different behavior:
    // it throws an exception if the key is not found in the map. Additionally, you have two more options to handle the key absence:
    //getOrElse(), getOrDefault()
    val numbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(numbersMap.get("one"))
    println(numbersMap["one"])
    println(numbersMap.getOrDefault("four", 10))
    println(numbersMap["five"])
    //numbersMap.getValue("six")
    println(numbersMap.keys)
    println(numbersMap.values)
}

fun sortElementExample() {
    //sort(), sortDescending(), sortBy()-- shuffle() instead of shuffled().reverse() instead of reversed().

    val numbers = mutableListOf("one", "two", "three", "four")

    numbers.sort()
    println("Sort into ascending: $numbers")
    numbers.sortDescending()
    println("Sort into descending: $numbers")

    numbers.sortBy { it.length }
    println("Sort into ascending by length: $numbers")
    numbers.sortByDescending { it.last() }
    println("Sort into descending by the last letter: $numbers")

    numbers.sortWith(compareBy<String> { it.length }.thenBy { it })
    println("Sort by Comparator: $numbers")

    numbers.shuffle()
    println("Shuffle: $numbers")
}

fun binarySearchExample() {
    // There is one more way to search elements in lists – binary search -
    // it works faster then other built in search function
    // it require list is in sorted and ascending order
    // so if you want to search any element in list then call binarySearch and pass value as a argument
    // if such element is present it will return indices else return (- insertionPoint -1 )
    //insertionPoint is the index where this element should be inserted so that the list remains sorted
    //If there is more than one element with the given value, the search can return any of their indices.
    //You can also specify an index range to search in: in this case, the function searches only between two provided indices.

    val numbers = mutableListOf("one", "two", "three", "four")
    numbers.sort()
    println(numbers)
    println(numbers.binarySearch("four"))
    println(numbers.binarySearch("z"))
    println(numbers.binarySearch("two", 0, 2))
}

fun findElementPosition() {
    // indexOf(),lastIndexOf() - find first or last position else -1
    /* val numbers = listOf(1, 2, 3, 4, 2, 5)
     println(numbers.indexOf(8))
     println(numbers.lastIndexOf(2))*/

    //indexOfFirst(),indexOfLast()
    //returns the index of the first/last element matching the predicate or -1 if there are no such elements.

    val numbers1 = mutableListOf(1, 2, 0, 4,5,6)
    println(numbers1.indexOfFirst { it > 2})
    println(numbers1.indexOfLast { it % 2 == 1})
}

fun retriveSubList() {
    val numbers = (0..13).toList()
    println(numbers.subList(3, 6))
}

fun exampleListOperation() {
    val numbers = listOf(1, 2, 3, 4)
    println(numbers.get(0))
    println(numbers[0])
    //numbers.get(5)
    println(numbers.getOrNull(5))
    println(numbers.getOrElse(8, {it}))
}

fun mutableMapExample() {
    //MutableMap is a Map with map write operations,
    // for example, you can add a new key-value pair or update the value associated with the given key.
    //The default implementation of Map – LinkedHashMap –
    // preserves the order of elements insertion when iterating the map.
    // In turn, an alternative implementation – HashMap – says nothing about the elements order.

    val numbersMap = mutableMapOf("one" to 1, "two" to 2)
    numbersMap.put("three", 3)
    numbersMap["one"] = 11

    println(numbersMap)
}

fun mapExample() {
    //Map (or dictionary) is a set of key-value pairs. Keys are unique, and each of them maps to exactly one value.
    // The values can be duplicates. Maps are useful for storing logical connections between objects, for example,
    // an employee's ID and their position.
    //Map<K, V> is not an inheritor of the Collection interface; however, it's a Kotlin collection type as well.
    // A Map stores key-value pairs (or entries); keys are unique, but different keys can be paired with equal values.
    // The Map interface provides specific functions, such as access to value by key, searching keys and values, and so on.

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)

    println("All keys: ${numbersMap.keys}")
    println("All values: ${numbersMap.values}")
    if ("key2" in numbersMap) println("Value by key \"key2\": ${numbersMap["key2"]}")
    if (1 in numbersMap.values) println("The value 1 is in the map")
    if (numbersMap.containsValue(1)) println("The value 1 is in the map")

}

fun mutablesetExample1() {
    //The default implementation of Set – LinkedHashSet – preserves the order of elements insertion.
    //Hence, the functions that rely on the order, such as first() or last(), return predictable results on such sets.
    //An alternative implementation – HashSet – says nothing about the elements order, so calling such functions on it returns unpredictable results.
    //However, HashSet requires less memory to store the same number of elements.

    val numbers = setOf(1, 2, 3, 4)  // LinkedHashSet is the default implementation
    val numbersBackwards = setOf(4, 3, 2, 1)

    println(numbers.first() == numbersBackwards.first())
    println(numbers.first() == numbersBackwards.last())
}

fun mutableSetExample() {
    // Kotlin MutableSet interface is a generic unordered collection of elements.
    // MutableSet interface does not support duplicate elements.
    // This interface is mutable so its methods support read-write functionality supports adding and removing elements.
    //Set interface uses mutableSetOf() function to create the list of object of set interface which contains list of elements.
    //interface MutableSet<E> : Set<E>, MutableCollection<E> (source)

    val intmutableSet = mutableSetOf<Int>(2, 6, 4, 29, 4, 5)
    val anymutableSet: Set<Any> = setOf(2, 6, 4, 29, 4, 5, "Ajay", "Ashu", "Ajay")
    println("....intmutableSet....")
    for(element in intmutableSet){
        println(element)
    }
    println("....anymutableSet......")
    for(element in anymutableSet){
        println(element)
    }
}

fun setoFExample() {
    //Kotlin Set interface is a generic unordered collection of elements.
    // Set interface does not support duplicate elements.
    // This interface is immutable in nature its methods supports read-only functionality of the set.
    //  Set interface uses setOf() function to create the list of object of set interface which contains list of elements.
    //interface Set<out E> : Collection<E> (source)

    val intSet = setOf(2, 6, 4, 29, 4, 5)
    val mySet: Set<Any> = setOf(2, 6, 4, 29, 4, 5, "Ashu", "Ajay")
    println(".......print Int set.........")
    for (element in intSet) {
        println(element)
    }
    println(".......print Any set.........")
    for (element in mySet) {
        println(element)

    }

    //function ..
    //isEmpty(),isNotEmpty(),contains() and containsAll()
    //The drop() function returns all the element except the first n elements of collection.
    //elementAt() and elementAtOrNull()


}


fun outPutListExample() {
    val bob = Person("Bob", 31)
    val people = listOf(Person("Adam", 20), bob, bob)
    val people2 = listOf(Person("Adam", 20), Person("Bob", 31), bob)
    println(people == people2)  // output
    bob.age = 32
    println(people == people2)
}

data class Person(val name:String, var age:Int)

fun arrayListExample() {
    //ArrayList class is used to create a dynamic array
    //Which means the size of ArrayList class can be increased or decreased according to requirement.
    // ArrayList class provides both read and write functionalities.
    //Kotlin ArrayList class follows the sequence of insertion order.
    // ArrayList class is non synchronized and it may contains duplicate elements.
    // The elements of ArrayList class are accessed randomly as it works on index basis.
    // An arrayListOf() is a function of ArrayList class.
    // ArrayList is mutable which means it provides both read am write functionalities.
    // The arrayListOf() function returns an ArrayList type.

    var intArrayList: ArrayList<Int> = arrayListOf<Int>(1,2,3)
    var stringArrayList: ArrayList<String> = arrayListOf<String>("Ajay","Vijay","Prakash")
    var anyArrayList: ArrayList<Any> = arrayListOf<Any>(1,2,3,"Ajay","Vijay","Prakash")
    println("print int ArrayList")
    for(element in intArrayList){
        println(element)
    }
    println()
    println("print string ArrayList")
    for(element in stringArrayList){
        println(element)
    }
    println()
    println("print any ArrayList")
    for(element in anyArrayList){
        println(element)
    }
}

fun mutableListExample() {
    //MutableList interface supports both read and write functionalities.
    //mutableListOf() or mutableListOf<E>().
    //interface MutableList<E> : List<E>, MutableCollection<E> (source)

    //output
    val numbers = mutableListOf(1, 2, 3, 4)
    numbers.add(5)
    numbers.removeAt(1)
    numbers[0] = 0
    numbers.shuffle()
    println(numbers)
}

fun genericListExample() {
    var intList: List<Int> = listOf<Int>(1,2,3)
    var stringList: List<String> = listOf<String>("Ajay","Vijay","Prakash")
    var anyList: List<Any> = listOf<Any>(1,2,3,"Ajay","Vijay","Prakash")
    println("print int list")
    for(element in intList){
        println(element)
    }
    println()
    println("print string list")
    for(element in stringList){
        println(element)
    }
    println()
    println("print any list")
    for(element in anyList){
        println(element)
    }
}

fun listExample1() {
    var list = listOf("Ajay","Vijay","Prakash")//read only, fix-size
    for(element in list){
        println(element)
    }
}

fun printAll(strings: Collection<String>) {
    for(s in strings) print("$s ")
    println()
}