package com.mss.inventory.controller;

import com.mss.inventory.model.Inventory;
import com.mss.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createInventory(@RequestBody Inventory inventory) {
        this.inventoryService.addInventory(inventory);
        return "Successfully created inventory";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> getAllInventory() {
        return this.inventoryService.getAllInventory();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return this.inventoryService.isInStock(skuCode, quantity);
    }

}
