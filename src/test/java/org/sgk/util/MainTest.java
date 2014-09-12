package org.sgk.util;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainTest {

	private HashMap<String, String> map = new HashMap<>();
	
	public static void main(String[] args) {
		MainTest mainTest = new MainTest();
		mainTest.testConcurrentHashMap();
	}
	
	private void testConcurrentHashMap()
	{
		initMap();
		System.out.println("1lock="+map.get("lock"));
		new Thread(new Runnable() {
			public void run() {
				map.put("lock",Thread.currentThread().getName());
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				map.put("lock",Thread.currentThread().getName());
			}
		}).start();
		System.out.println("2lock="+map.get("lock"));
	}
	
	private void initMap()
	{
		map.put("lock", "no-thread");
		map.put("mode", "test");
	}

	private void testBetweenIFaceAndAbstract()
	{
		DateFormat format = new SimpleDateFormat("ddmmyyhhMMss");
		System.out.println("1st before time="+new Date().getTime());
		new TestAbstractClassImpl().sayHello("class");
		System.out.println("1st after  time="+new Date().getTime());
		
		System.out.println("2nd before time="+new Date().getTime());
		new TestInterfaceImpl().sayHello("class");
		System.out.println("2nd after  time="+new Date().getTime());
	}
}

class TestAbstractClassImpl extends TestAbstractClass
{
	public String sayHello(String name)
	{
		return "From TestAbstractClassImpl Hello " + name;
	}
}

class TestInterfaceImpl implements TestInterface
{
	public String sayHello(String name)
	{
		return "From TestInterfaceImpl Hello " + name;
	}
}




abstract class TestAbstractClass
{
	public abstract String sayHello(String name);
}

interface TestInterface
{
	public String sayHello(String name);
}