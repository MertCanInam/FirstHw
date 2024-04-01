package com.mertinam.firsthw

open class Item (var name : String, var price : Double)
class Food (  name : String , price : Double ,val weight : Double) : Item(name , price)
class Cloth (  name : String , price : Double ,val type : String) : Item( name , price )

class ShoppingList {

var items = ArrayList<Item>()

fun addItem(item : Item) {
   items.add(item)
    println("${item.name} is added !")
}

fun displayItems() {
    if(items.size == 0)
    {
        println("There is no product ! ")
    }
    else
        println("Thats your shopping list :")
        for(item in items)
        {
            if( item is Food)
            {
                println("${item.name} ${item.price}$ ${item.weight}Kg ")
            }
            else if ( item is Cloth)
            {
                println("${item.name} ${item.price}$ ${item.type} ")
            }
            else
                println("${item.name} ${item.price}")
        }

}
fun deleteItem(deleteItem : Item)
{
    if (items.isEmpty())
    {
        println("Already there is no product !")
    }
    else {3
        items.remove(deleteItem)
        println("${deleteItem.name} is deleted !")
    }
}


}

fun main() {
    val shoppingList = ShoppingList()


    do {
        println("Menu:")
        println("1. Add Item")
        println("2. Display Items")
        println("3. Delete Item")
        println("4. Exit")
        var option = readln().toInt()
        while (option < 1 || option > 4 )
        {
            println("İnvalid option . Please again enter your choice ")
            option = readln().toInt()
        }

        when (option) {
            1 -> {
                println("Please enter your item type( 1 for food 2 for cloth) ")
                var itemType : Int = readln().toInt()
                while(itemType !in 1..2)
                {
                    println("Invalid item type. Please enter 1 for food or 2 for cloth:")
                    itemType = readln().toInt()
                }
                if(itemType == 1)
                {
                    print("Please enter the name : ")
                    var foodName = readln().toString()
                    print("Please enter the price : ")
                    var foodPrice = readln().toDoubleOrNull()
                    while (foodName == null )
                    {
                        println("Please enter valid food name:")
                        foodName = readln().toString()
                    }
                    while ( foodPrice == null)
                    {
                        println("Please enter valid price! : ")
                        foodPrice = readln().toDoubleOrNull()
                    }
                    print("Please enter the weight : ")
                    var foodWeight = readln().toDoubleOrNull()
                    while (foodWeight == null) {
                        println("Please enter valid weight! : ")
                        foodWeight = readln().toDoubleOrNull()
                    }
                    val foodItem = Food(foodName,foodPrice,foodWeight)
                    shoppingList.addItem(foodItem)


                }else{
                    print("Please enter the name : ")
                    var clothName = readln().toString()
                    while (clothName == null)
                    {
                        println("Please enter valid cloth name:")
                        clothName = readln().toString()
                    }
                    print("Please enter the price : ")
                    var clothPrice = readln().toDoubleOrNull()
                    while (clothPrice == null) {
                    println("Please enter valid price! : ")
                    clothPrice = readln().toDoubleOrNull()
                    }
                    print("Please enter the type : ")
                    val clothType = readln().toString()
                    val clothItem = Cloth(clothName, clothPrice, clothType)
                    shoppingList.addItem(clothItem)
                }
            }
            2->shoppingList.displayItems()
            3-> {
                    println("Please enter name of the item to delete")
                     val deleteItem = readln().toString()
                    val trueItem = shoppingList.items.find { it.name == deleteItem }
                    if (trueItem != null)
                    {
                     shoppingList.deleteItem(trueItem)
                     println("Item '${trueItem.name}' deleted from the list.")
                     }else
                    println("Item '$deleteItem' not found in the list.")


            }
            4-> {
                println("Shutting down")

            }

        }

    }while (option != 4)
}




