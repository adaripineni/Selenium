/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.github.amulya.SeleniumAutomation;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTest {
	
	WebDriver d;

	@BeforeTest
	public void setUp() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		// TODO Auto-generated method stub
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		d.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		Thread.sleep(5000);
	} 
	
	@Test
	public void selectDropdown() throws InterruptedException {
		WebElement dropDown= d.findElement(By.tagName("select"));
		Select menu = new Select(dropDown);
		List<WebElement> options = menu.getOptions();
		for( WebElement option:options) {
			if(option.getText().startsWith("B")){
				menu.selectByVisibleText(option.getText());
				Thread.sleep(1000);
			}
		}
//		menu.selectByIndex(options.size()-1);
//		System.out.println(menu.getFirstSelectedOption().getText());
//		Thread.sleep(2000);
	}
	
	@AfterTest
	public void testDown() {
		d.quit();
	}
	
	
}
	
	