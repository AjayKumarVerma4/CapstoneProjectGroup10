package com.hcl.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.capstone.entity.Menu;
import com.hcl.capstone.exception.MenuException;
import com.hcl.capstone.service.IMenuService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/menus")
public class MenuController {

	@Autowired
	private IMenuService iMenuService;

	@GetMapping("/menuList")
	public ResponseEntity<List<Menu>> displayAllMenu() {
		List<Menu> menuList = iMenuService.displayAllMenu();
		return new ResponseEntity<List<Menu>>(menuList, HttpStatus.OK);
	}

	@GetMapping("/getMenuByRestaurantId/{id}")
	public ResponseEntity<List<Menu>> getByRestaurantId(@PathVariable("id") long id) {
		List<Menu> menuList = iMenuService.getMenuByRestaurantId(id);
		log.info("menu===="+menuList);
		return new ResponseEntity<List<Menu>>(menuList, HttpStatus.OK);
	}

	@PostMapping("/addMenu")
	public ResponseEntity<Menu> addNewMenu(@RequestBody Menu menu) {
		Menu menu1 = iMenuService.addMenu(menu);
		return new ResponseEntity<Menu>(menu1, HttpStatus.OK);
	}

	@GetMapping("/getSingleMenu/{id}")
	public ResponseEntity<Menu> getSingleMenu(@PathVariable("id") long id) throws MenuException {
		Menu menu1 = iMenuService.getSingleMenuById(id);
		return new ResponseEntity<Menu>(menu1, HttpStatus.OK);
	}

	@PutMapping("/updateMenu")
	public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu) throws MenuException {
		Menu menu1 = iMenuService.updateMenu(menu);
		return new ResponseEntity<Menu>(menu1, HttpStatus.OK);
	}

	@DeleteMapping("/deleteMenu/{id}")
	public ResponseEntity<Object> deleteMenu(@PathVariable("id") long id) throws MenuException {
		iMenuService.deleteMenuById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
