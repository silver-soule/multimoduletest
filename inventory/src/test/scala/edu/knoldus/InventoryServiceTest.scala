package edu.knoldus

import org.scalatest.AsyncFunSuite

/**
  * Created by Neelaksh on 16/8/17.
  */
class InventoryServiceTest extends AsyncFunSuite {
  test("get by category"){
    InventoryService.getItemsByCategory("potato").map{
      items=>
        assert(items.head.name == "potatoblender")
    }
  }

  test("get sorted items price high to low"){
    InventoryService.sortItems(InventoryService.priceHighToLow).map{
      items=>
        assert(items.head.name == "potatoblender")
    }
  }

  test("get sorted items price low to high"){
    InventoryService.sortItems(InventoryService.priceLowToHigh).map{
      items=>
        assert(items.head.name == "blender")
    }
  }

  test("get sorted items ratings high to low"){
    InventoryService.sortItems(InventoryService.ratingHighToLow).map{
      items=>
        assert(items.head.name == "blender")
    }
  }
  test("get sorted items ratings low to high"){
    InventoryService.sortItems("randomString").map{
      items=>
        assert(items.head.name == "potatoblender")
    }
  }
}
