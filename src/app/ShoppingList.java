package app;

import java.awt.*;
import java.util.*;
import javax.swing.*;


public class ShoppingList extends JFrame  {
	
	
	//initialize jframe components
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	GridLayout grid = new GridLayout(3,0);
	GridLayout grid1 = new GridLayout(6,2,4,5);
	GridLayout grid2 = new GridLayout(4,2,6,15);
	
	//main section
	JLabel month = new JLabel("Select Month: ");
	JLabel item = new JLabel("Select Item: ");
	JButton newItemBtn = new JButton("Enter New Item Name");
	JTextField newItemInput =new JTextField(10);
	JLabel price = new JLabel("Enter Price: ");
	JTextField priceInput =new JTextField(10);
	JButton addBtn =new JButton("Add Item");
	JButton displayBtn =new JButton("Show All Items");
	JButton updateBtn =new JButton("Update Item");
	JButton deleteBtn =new JButton("Delete Item");
	JButton returnBtn2 =new JButton("HIDE");
	
	//update section
	JLabel month2 = new JLabel("Select Month: ");
	JLabel item2 = new JLabel("Select Item: ");
	JLabel updatePrice = new JLabel("Update Price: ");
	JTextField updateItemPrice =new JTextField(10);
	JButton submitBtn =new JButton("Update!");
	JButton returnBtn1 =new JButton("HIDE");
	
	//delete section
	JLabel month3 = new JLabel("Select Month: ");
	JLabel item3 = new JLabel("Select Item: ");
	JButton removeBtn =new JButton("Delete Item!");
	JButton removeAllBtn =new JButton("Delete All Items!");
	JButton returnBtn3 =new JButton("HIDE");
	
	//label for error messages
	JLabel errorMessage =new JLabel("");
	
	
	//string to hold all items
	String output="";
	
	//text area to hold string output
	JTextArea allItems =new JTextArea();
	
	
	public ShoppingList() {
		this.initFrame();
	}

	private void initFrame() {
		ArrayList<String> months= new ArrayList<>();
		months.add("JANUARY");
		months.add("FEBRUARY");
		months.add("MARCH");
		months.add("APRIL");
		months.add("MAY");
		months.add("JUNE");
		months.add("JULY");
		months.add("AUGUST");
		months.add("SEPTEMBER");
		months.add("OCTOBER");
		months.add("NOVEMBER");
		months.add("DECEMBER");
		
		//dropdown for the months in different sections
		JComboBox<String> monthCombo = new JComboBox<>();
		for(int i = 0; i < months.size(); i++) {
		monthCombo.addItem(months.get(i));
		monthCombo.setSelectedItem(null);
		}
		JComboBox<String> updateMonthCombo = new JComboBox<>();
		for(int i = 0; i < months.size(); i++) {
		updateMonthCombo.addItem(months.get(i));
		updateMonthCombo.setSelectedItem(null);
		}
		JComboBox<String> deleteMonthCombo = new JComboBox<>();
		for(int i = 0; i < months.size(); i++) {
		deleteMonthCombo.addItem(months.get(i));
		deleteMonthCombo.setSelectedItem(null);
		}
		
		//arraylist holding the items
		ArrayList<String> items= new ArrayList<>();
		items.add("COFFEE");
		items.add("MILK");
		items.add("WINE");
		items.add("SHAMPOO");
		items.add("WATER");
		
		//dropdown for the items in different sections
		JComboBox<String> itemsCombo = new JComboBox<>();
		for(int i = 0; i < items.size(); i++) {
		itemsCombo.addItem(items.get(i));
		itemsCombo.setSelectedItem(null);
		}
		JComboBox<String> updateItemsCombo = new JComboBox<>();
		for(int i = 0; i < items.size(); i++) {
		updateItemsCombo.addItem(items.get(i));
		updateItemsCombo.setSelectedItem(null);
		}
		JComboBox<String> deleteItemsCombo = new JComboBox<>();
		for(int i = 0; i < items.size(); i++) {
		deleteItemsCombo.addItem(items.get(i));
		deleteItemsCombo.setSelectedItem(null);
		}
		
		//arraylists for item prices
		ArrayList<Double> coffeePrice= new ArrayList<>();
		coffeePrice.add(13.5);
		coffeePrice.add(13.0);
		coffeePrice.add(13.0);
		coffeePrice.add(15.8);
		coffeePrice.add(14.4);
		
		ArrayList<Double> milkPrice= new ArrayList<>();
		milkPrice.add(18.5);
		milkPrice.add(19.5);
		milkPrice.add(20.0);
		milkPrice.add(19.5);
		milkPrice.add(19.0);
		
		ArrayList<Double> winePrice= new ArrayList<>();
		winePrice.add(45.0);
		winePrice.add(47.0);
		winePrice.add(45.5);
		winePrice.add(46.0);
		winePrice.add(48.5);
		
		ArrayList<Double> shampooPrice= new ArrayList<>();
		shampooPrice.add(35.0);
		shampooPrice.add(37.0);
		shampooPrice.add(38.5);
		shampooPrice.add(37.2);
		shampooPrice.add(38.0);
		
		ArrayList<Double> waterPrice= new ArrayList<>();
		waterPrice.add(12.0);
		waterPrice.add(12.0);
		waterPrice.add(12.0);
		waterPrice.add(12.0);
		waterPrice.add(12.0);
		
		
		//hashmaps (value) to hold prices for the corresponding months for each item
		HashMap<String,Double> coffeeValue=new HashMap<>();
		for(int i =0; i<coffeePrice.size();i++) {
			coffeeValue.put(months.get(i), coffeePrice.get(i));
		}
		HashMap<String,Double> milkValue=new HashMap<>();
		for(int i =0; i<milkPrice.size();i++) {
			milkValue.put(months.get(i), milkPrice.get(i));
		}
		HashMap<String,Double> wineValue=new HashMap<>();
		for(int i =0; i<winePrice.size();i++) {
			wineValue.put(months.get(i), winePrice.get(i));
		}
		HashMap<String,Double> shampooValue=new HashMap<>();
		for(int i =0; i<shampooPrice.size();i++) {
			shampooValue.put(months.get(i), shampooPrice.get(i));
		}
		HashMap<String,Double> waterValue=new HashMap<>();
		for(int i =0; i<waterPrice.size();i++) {
			waterValue.put(months.get(i), waterPrice.get(i));
		}
		ArrayList<HashMap<String,Double>> tempValue =new ArrayList<>();
		
		
		
		//hashmap to hold each item with corresponding value
		HashMap<String,HashMap<String, Double>> list=new HashMap<>();
		list.put(items.get(0), coffeeValue);
		list.put(items.get(1), milkValue);
		list.put(items.get(2), wineValue);
		list.put(items.get(3), shampooValue);
		list.put(items.get(4), waterValue);
		
		
		//add jpanels to jframe
		this.add(p1);
		this.add(p2);
		this.add(p3);
		
		//add items to first panel
		p1.add(item);
		p1.add(itemsCombo);
		p1.add(month);
		p1.add(monthCombo);
		p1.add(newItemInput);
		p1.add(newItemBtn);
		p1.add(price);
		p1.add(priceInput);
		p1.add(addBtn);
		p1.add(displayBtn);
		p1.add(updateBtn);
		p1.add(deleteBtn);
		p1.setLayout(grid1);
		
		
		p2.setVisible(false);
		p3.setVisible(false);
		allItems.setEditable(false);
		
		
		//action listener to display all items
		displayBtn.addActionListener(e->{
			if(list.size()>0) {
				p3.setVisible(false);
				p2.setVisible(false);
				p3.removeAll();
				p3.setVisible(true);
				p1.setVisible(false);
				output="";
				for (String i : list.keySet()) {
				  output = output.concat( i + ", PRICE : " + list.get(i)+"\n");
				}
				allItems.setText(output);
				p3.add(allItems);
				p3.add(returnBtn2);
				
			}else {
			p3.setVisible(false);
			p3.removeAll();
			errorMessage.setText("Shopping List is Empty, add items.");
			p3.add(errorMessage);
			p3.add(returnBtn2);
			p3.setVisible(true);
			}
		});
		
		//action listener to display update menu
		updateBtn.addActionListener(e->{
			p2.setVisible(false);
			p2.removeAll();
			p2.add(item2);
			p2.add(updateItemsCombo);
			p2.add(month2);
			p2.add(updateMonthCombo);
			p2.add(updatePrice);
			p2.add(updateItemPrice);
			p2.add(returnBtn1);
			p2.add(submitBtn);
			p2.setLayout(grid2);
			p1.setVisible(false);
			p3.setVisible(false);
			p2.setVisible(true);
		});
		
		//action listener to display delete menu
		deleteBtn.addActionListener(e->{
			p2.setVisible(false);
			p2.removeAll();
			p2.add(item3);
			p2.add(deleteItemsCombo);
			p2.add(removeAllBtn);
			p2.add(removeBtn);
			p2.add(returnBtn3);
			p2.setLayout(grid2);
			p1.setVisible(false);
			p3.setVisible(false);
			p2.setVisible(true);
		});
		
		//return buttons 
		returnBtn1.addActionListener(e->{
			p2.setVisible(false);
			p1.setVisible(true);
			p3.setVisible(false);
		});
		returnBtn2.addActionListener(e->{
			p2.setVisible(false);
			p1.setVisible(true);
			p3.setVisible(false);
			output = "";
		});
		returnBtn3.addActionListener(e->{
			p2.setVisible(false);
			p1.setVisible(true);
			p3.setVisible(false);
		});
		
		//action listener to add new item name
		newItemBtn.addActionListener (e->{
			//if new item name textfield is empty, give error
			if (newItemInput.getText().isBlank()) {
				errorMessage.setText("Enter new item name!!!");
				p2.removeAll();
				p2.add(errorMessage);
				p2.setVisible(true);
				p3.setVisible(false);
			}//else add new item name to items arraylist
			else {items.add(newItemInput.getText().toUpperCase());
			//update the comboboxes with the newly added item
			for(int i = items.size()-1; i < items.size(); i++) {
				itemsCombo.addItem(items.get(i));
				itemsCombo.setSelectedItem(items.get(i));}
			newItemInput.setText("");
			//close jpanel p2 incase there was an error displayed
				p2.setVisible(false);
			}
		});
		
		//action listener to add item to the shopping list
		addBtn.addActionListener (e->{
			Scanner check = new Scanner(priceInput.getText());
			//checking if month and item is selected
			if(monthCombo.getSelectedItem()==null || itemsCombo.getSelectedItem()==null){
				errorMessage.setText("Select Item and Month!!! ");
				p3.removeAll();
				p3.add(errorMessage);
				p3.setVisible(true);
			}else //using scanner to check if price is inputed in number/double 
				if (!check.hasNextDouble()) {
					errorMessage.setText("Enter item price in number!!! ");
				p3.removeAll();
				p3.add(errorMessage);
				p3.setVisible(true);
			}else {
				p2.setVisible(false);
				p3.setVisible(false);
				p3.removeAll();
				String selectedMonth = monthCombo.getSelectedItem().toString().toUpperCase();
				String selectedItem = itemsCombo.getSelectedItem().toString().toUpperCase();
				int selectedItemIndex = itemsCombo.getSelectedIndex();
				double itemPrice= Double.valueOf(priceInput.getText());
				try {
					//checking if the item was on the shopping list
					//if yes, update the value
					if(selectedItemIndex<list.size()) {
						list.get(selectedItem).put(selectedMonth, itemPrice);
					list.put(items.get(selectedItemIndex),list.get(selectedItem));
				}else {
					//if item is newly added, create a new value
					HashMap<String,Double> tempValue2=new HashMap<>();
					tempValue2.put(selectedMonth, itemPrice);
					int j = 0;
					for(int i=0; i<1;i++) {
						tempValue.add(tempValue2);
						j++;
						list.put(items.get(selectedItemIndex),tempValue.get(j-1));
						updateItemsCombo.addItem(selectedItem);
						updateItemsCombo.setSelectedItem(null);
						deleteItemsCombo.addItem(selectedItem);
						deleteItemsCombo.setSelectedItem(null);
						
					}
				}
				}catch(Exception err) {
					System.out.println("Error occurred!!!");
					err.printStackTrace();
				}
				p1.setVisible(false);
				itemsCombo.setSelectedItem(null);
				monthCombo.setSelectedItem(null);
				output="";
				//loop through the shopping list hashmap and save the content inside string (output)
				for (String i : list.keySet()) {
				  output = output.concat( i + ", PRICE : " + list.get(i)+"\n");
				}
				allItems.setText(output);
				//clear the temporary value holder arraylist
				tempValue.clear();
				p3.add(allItems);
				p3.add(returnBtn2);
				priceInput.setText("");
				p3.setVisible(true);
			}
		});
		
		//action listener to execute update command
		submitBtn.addActionListener(e->{
			
			Scanner check = new Scanner(updateItemPrice.getText());
			if(updateMonthCombo.getSelectedItem()==null || updateItemsCombo.getSelectedItem()==null){
				errorMessage.setText("Select Item and Month!!! ");
				p3.removeAll();
				p3.add(errorMessage);
				p3.setVisible(true);
				
			}else if (!check.hasNextDouble()) {
				errorMessage.setText("Enter item's new price in number!!! ");
				p3.removeAll();
				p3.add(errorMessage);
				p3.setVisible(true);
			}
			else {
				p3.removeAll();
				String selectedMonthUpdate = updateMonthCombo.getSelectedItem().toString().toUpperCase();
				String selectedItemUpdate = updateItemsCombo.getSelectedItem().toString().toUpperCase();
				int selectedItemUpdateIndex = updateItemsCombo.getSelectedIndex();
				double itemNewPrice= Double.valueOf(updateItemPrice.getText());
				list.get(selectedItemUpdate).put(selectedMonthUpdate, itemNewPrice);
				list.put(items.get(selectedItemUpdateIndex),list.get(selectedItemUpdate));
				p2.setVisible(false);
				updateItemsCombo.setSelectedItem(null);
				output="";
				//loop through the shopping list hashmap and save the content inside string (output)
				for (String i : list.keySet()) {
				  output = output.concat( i + ", PRICE : " + list.get(i)+"\n");
				}
				allItems.setText(output);
				p3.add(allItems);
				p3.add(returnBtn1);
				updateItemPrice.setText("");
				p3.setVisible(true);
			}
		});
		
		//action listener to execute single item delete command
		removeBtn.addActionListener(e->{
			if( deleteItemsCombo.getSelectedItem()==null){
				errorMessage.setText("Select Item to Delete!!! ");
				p3.removeAll();
				p3.add(errorMessage);
				p3.setVisible(true);
				
			}else {
				p3.removeAll();
				String selectedItem = deleteItemsCombo.getSelectedItem().toString().toUpperCase();
				list.remove(selectedItem);
				updateItemsCombo.removeItem(selectedItem);
				deleteItemsCombo.removeItem(selectedItem);
				p2.setVisible(false);
				deleteItemsCombo.setSelectedItem(null);
				output="";
				//loop through the shopping list hashmap and save the content inside string (output)
				for (String i : list.keySet()) {
				  output = output.concat( i + ", PRICE : " + list.get(i)+"\n");
				}
				allItems.setText(output);
				p3.add(allItems);
				p3.add(returnBtn3);
				p3.setVisible(true);
				if(output.isBlank()) {
					p2.setVisible(false);
					p1.setVisible(true);
					p3.setVisible(false);
					updateItemsCombo.removeAllItems();
					deleteItemsCombo.removeAllItems();
					p3.removeAll();
					errorMessage.setText("All Items Deleted, Shopping List is Empty, add items.");
					p3.add(errorMessage);
					p3.add(returnBtn2);
					p3.setVisible(true);
				}
			}
				
			
		});
		
		//action listener to delete all items
		removeAllBtn.addActionListener(e->{
			p2.setVisible(false);
			p1.setVisible(true);
			p3.setVisible(false);
			list.clear();
			output="";
			updateItemsCombo.removeAllItems();
			deleteItemsCombo.removeAllItems();
			p3.removeAll();
			errorMessage.setText("All Items Deleted, Shopping List is Empty, add items.");
			p3.add(errorMessage);
			p3.add(returnBtn2);
			p3.setVisible(true);
		});
		
		this.setTitle("Shopping List");
		this.getContentPane();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(grid);
		this.setSize(600,700);
		this.setVisible(true);
		p1.setBackground(Color.decode("#DADFF7"));
		p2.setBackground(Color.decode("#DADFF7"));
		p3.setBackground(Color.decode("#DADFF7"));
		itemsCombo.setBackground(Color.decode("#A0C1D1"));
		monthCombo.setBackground(Color.decode("#A0C1D1"));
		updateItemsCombo.setBackground(Color.decode("#A0C1D1"));
		updateMonthCombo.setBackground(Color.decode("#A0C1D1"));
		deleteItemsCombo.setBackground(Color.decode("#A0C1D1"));
		newItemInput.setBackground(Color.decode("#A0C1D1"));
		priceInput.setBackground(Color.decode("#A0C1D1"));
		updateItemPrice.setBackground(Color.decode("#A0C1D1"));
		allItems.setBackground(Color.LIGHT_GRAY);
		errorMessage.setForeground(Color.red);
		newItemBtn.setBackground(Color.decode("#232C33"));
		addBtn.setBackground(Color.decode("#232C33"));
		displayBtn.setBackground(Color.decode("#232C33"));
		deleteBtn.setBackground(Color.decode("#232C33"));
		returnBtn2.setBackground(Color.decode("#232C33"));
		submitBtn.setBackground(Color.decode("#232C33"));
		returnBtn1.setBackground(Color.decode("#232C33"));
		removeBtn.setBackground(Color.decode("#232C33"));
		removeAllBtn.setBackground(Color.decode("#232C33"));
		returnBtn3.setBackground(Color.decode("#232C33"));
		updateBtn.setBackground(Color.decode("#232C33"));
		newItemBtn.setForeground(Color.decode("#FFFFFF"));
		addBtn.setForeground(Color.decode("#FFFFFF"));
		displayBtn.setForeground(Color.decode("#FFFFFF"));
		deleteBtn.setForeground(Color.decode("#FFFFFF"));
		returnBtn2.setForeground(Color.decode("#FFFFFF"));
		submitBtn.setForeground(Color.decode("#FFFFFF"));
		returnBtn1.setForeground(Color.decode("#FFFFFF"));
		removeBtn.setForeground(Color.decode("#FFFFFF"));
		removeAllBtn.setForeground(Color.decode("#FFFFFF"));
		returnBtn3.setForeground(Color.decode("#FFFFFF"));
		updateBtn.setForeground(Color.decode("#FFFFFF"));

	}



	public static void main(String[] args) {
		
		new ShoppingList();

	}



}
