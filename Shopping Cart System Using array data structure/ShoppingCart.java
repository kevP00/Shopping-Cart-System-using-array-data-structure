import java.util.Scanner;

public class ShoppingCart {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of cart: ");
        int size = input.nextInt();
        
        CartFunctions cartFunctions = new CartFunctions(size);
        
        System.out.println("0- Exit");
	System.out.println("1- InsertAll");
	System.out.println("2- InsertStart");
	System.out.println("3- InsertMid");
	System.out.println("4- InsertEnd");
	System.out.println("5- ItemReplace");
	System.out.println("6- DeleteStart");
	System.out.println("7- DeleteMid");
	System.out.println("8- DeleteEnd");
	System.out.println("9- DeleteByName");
	System.out.println("10- SearchByName");
	System.out.println("11- SearchByPrice");
	System.out.println("12- SearchByQuantity");
	System.out.println("13- ShowAllItems");
	System.out.println("14- TotalBill");
        
        System.out.println("\nSelect options value:[0 to exit]");
		int options = input.nextInt();
		
		while(options!=0) {
			switch(options) {
                                case 1:
                                    cartFunctions.insert();
                                    break;
				case 2:
                                    cartFunctions.insertStart();
                                    break;
                                case 3:
                                    System.out.println("Enter index value: ");
                                    int indexvalue = input.nextInt();
                                    cartFunctions.insertMid(indexvalue);
                                    break;
                                case 4:
                                    cartFunctions.insertEnd();
                                    break;
                                case 5:
                                    System.out.println("Enter index value: ");
                                    int indexValuee = input.nextInt();
                                    cartFunctions.replace(indexValuee);
                                    break;
                                case 6:
                                    cartFunctions.deleteStart();
                                    System.out.println("item has been deleted at the start index point...");
                                    break;
                                case 7:
                                    System.out.println("Enter index value which item you want to delete: ");
                                    int indexVal = input.nextInt();
                                    cartFunctions.deleteMid(indexVal);
                                    break;
                                case 8:
                                    cartFunctions.deleteEnd();
                                    System.out.println("item has been deleted at the last index point...");
                                    break;
                                case 9:
                                    cartFunctions.deleteByName();
									System.out.println("item has been deleted...");
                                    break;
                                case 10:
                                    cartFunctions.searchByName();
                                    break;
                                case 11:
                                    cartFunctions.searchByPrice();
                                    break;
                                case 12:
                                    cartFunctions.searchByQuantity();
                                    break;
                                case 13:
                                    cartFunctions.itemDisplay();
                                    break;
                                case 14:
                                    cartFunctions.billCount();
                                    break;
								case 15:
									cartFunctions.returnPayment();
									break;
				default:
				System.out.println("You entered incorrect options value, try again...!");
			}
                    System.out.println("\nSelect options value: [0 to exit]");
                    options = input.nextInt();
		}
   }
    
}


// second class

class CartFunctions {
    Scanner input = new Scanner(System.in); 
    
    String itemName[];
    String itemDiscription[];
    int itemQuantity[];
    int itemPrice[];
	long sum = 0;
    
    int indexSize;
    int lastIndex = -1;
    
    // constructor
    public CartFunctions(int indexSize) {
        this.indexSize = indexSize;
        
        itemName = new String[indexSize];
        itemDiscription = new String[indexSize];
        itemQuantity = new int[indexSize];
        itemPrice = new int[indexSize];
    }
    
    // insert back to back
    void insert() {
        for(int i=lastIndex; i<indexSize-1; i++) {
            System.out.println("Insert Item at "+ (i+1) +" index: ");
            System.out.print("Enter item Name: ");
            itemName[i+1] = input.nextLine();
            System.out.print("Enter item Discription: ");
            itemDiscription[i+1] = input.nextLine();
            System.out.print("Enter item Quantity: ");
            itemQuantity[i+1] = input.nextInt();
            System.out.print("Enter item Price: ");
            itemPrice[i+1] = input.nextInt();
            input.nextLine();
            lastIndex++;
            System.out.println("-----------------------------------");
        }
    }
    
    // insert at Start index
    void insertStart() {
        if(!isFull()) {
            lastIndex++;
            for(int i=lastIndex; i>0; i--) {
                itemName[i] = itemName[i-1];
                itemDiscription[i] = itemDiscription[i-1];
                itemQuantity[i] = itemQuantity[i-1];
                itemPrice[i] = itemPrice[i-1];
            }
            System.out.println("Insert Item at start point");
            System.out.print("Enter item Name: ");
            itemName[0] = input.nextLine();
            System.out.print("Enter item Discription: ");
            itemDiscription[0] = input.nextLine();
            System.out.print("Enter item Quantity: ");
            itemQuantity[0] = input.nextInt();
            System.out.print("Enter item Price: ");
            itemPrice[0] = input.nextInt();
            input.nextLine();
            
        }
        else
            System.out.println("Cart size is full..");
    }
    
    // insert at Mid index
    void insertMid(int index) {
        if(!isFull()) {
            if(index>0 || index<=indexSize-1) {
				if(lastIndex > 1) {
					lastIndex++;
					for(int i=lastIndex; i>index; i--) {
						itemName[i] = itemName[i-1];
						itemDiscription[i] = itemDiscription[i-1];
						itemQuantity[i] = itemQuantity[i-1];
						itemPrice[i] = itemPrice[i-1];
					}
					System.out.println("Insert Item at Mid point");
					System.out.print("Enter item Name: ");
					itemName[index] = input.nextLine();
					System.out.print("Enter item Discription: ");
					itemDiscription[index] = input.nextLine();
					System.out.print("Enter item Quantity: ");
					itemQuantity[index] = input.nextInt();
					System.out.print("Enter item Price: ");
					itemPrice[index] = input.nextInt();
					input.nextLine();
				}
				else {
					System.out.println("Mid Point not found");
				}
            }
            else
                System.out.println("Index Error");
        }
        else
            System.out.println("Cart size is full..");
    }
    
    // insert at End index
    void insertEnd() {
        if(!isFull()) {
            lastIndex++;
            System.out.println("Insert Item at end point");
            System.out.print("Enter item Name: ");
            itemName[lastIndex] = input.nextLine();
            System.out.print("Enter item Discription: ");
            itemDiscription[lastIndex] = input.nextLine();
            System.out.print("Enter item Quantity: ");
            itemQuantity[lastIndex] = input.nextInt();
            System.out.print("Enter item Price: ");
            itemPrice[lastIndex] = input.nextInt();
            input.nextLine();
            
        }
        else
            System.out.println("Cart size is full..");
    }
    
    void replace(int index) {
        if(!isEmpty()) {
            if(index>=0 || index<=lastIndex) {
                System.out.println("Insert Item at given index: ");
                System.out.print("Enter item Name: ");
                itemName[index] = input.nextLine();
                System.out.print("Enter item Discription: ");
                itemDiscription[index] = input.nextLine();
                System.out.print("Enter item Quantity: ");
                itemQuantity[index] = input.nextInt();
                System.out.print("Enter item Price: ");
                itemPrice[index] = input.nextInt();
                input.nextLine();
            }
            else
                System.out.println("Index error...");
        }
        else
            System.out.println("Index is empty...");
    }
    
    // delete item at start index
    void deleteStart() {
        if(!isEmpty()) {
            for(int i = 0 ; i<lastIndex; i++ ) {
                itemName[i] = itemName[i+1];
                itemDiscription[i] = itemDiscription[i+1];
                itemQuantity[i] = itemQuantity[i+1];
                itemPrice[i] = itemPrice[i+1];
            }
            lastIndex--;
        }
        else
            System.out.println("cart is empty...");
    }
    
    // delete item at mid index
    void deleteMid(int index) {
        if(!isEmpty()) {
            if(index>0 || index<=indexSize-1) {
                    for(int i=index; i<=lastIndex; i++) {
                        itemName[i] = itemName[i+1];
                        itemDiscription[i] = itemDiscription[i+1];
                        itemQuantity[i] = itemQuantity[i+1];
                        itemPrice[i] = itemPrice[i+1];
                    }
                    lastIndex--;
					System.out.println("item has been deleted at the index point...");
            }
            else
                System.out.println("index error...");
        }
    }
    
    // delete item at end index
    void deleteEnd() {
        if (!isEmpty()) {
            lastIndex--;
        }
    }
    
    // delete by name
    
    void deleteByName() {
        if(!isEmpty()) {
            System.out.println("Enter item name for delete: ");
            String deleteValue = input.nextLine();      
            for(int i=0; i<=lastIndex; i++) {
                if(deleteValue.equals(itemName[i])) {
                    itemName[i] = itemName[i+1];
                    itemDiscription[i] = itemDiscription[i+1];
                    itemQuantity[i] = itemQuantity[i+1];
                    itemPrice[i] = itemPrice[i+1];
                }
				else {
					
				}
            }
            lastIndex--;
        }
    }
	

    // search by name
    void searchByName() {
        if(!isEmpty()) {
            System.out.print("Enter item name which you want to search: ");
            String value = input.nextLine();
            for(int i=0; i<=lastIndex; i++) {
                if(value.equals(itemName[i])){
					searchFound(i);
                }
            }
        }
    }
    
    // search by price
    void searchByPrice() {
        if(!isEmpty()) {
            System.out.print("Enter item price which you want to search: ");
            int value = input.nextInt();
            for(int i=0; i<=lastIndex; i++) {
                if(value == (itemPrice[i])){
					searchFound(i);
                }
            }
        }
    }

	
    // search by quantity
    void searchByQuantity() {
        if(!isEmpty()) {
            System.out.print("Enter item quantity which you want to search: ");
            int value = input.nextInt();
            for(int i=0; i<=lastIndex; i++) {
                if(value == (itemQuantity[i])){
					searchFound(i);
                }
            }
        }
    }
    
	void searchFound(int i) {
		System.out.println("search item at index: " + i);
		System.out.print("\nIndex\tName\t\t\tPrice\tQuantity\tDiscription\tBill");
		System.out.print("\t"+itemName[i]);
		System.out.print("\t\t\t"+itemPrice[i]);
		System.out.print("\t"+itemQuantity[i]);
		System.out.print("\t\t"+itemDiscription[i]);
		System.out.print("\tRS: "+(itemPrice[i]*itemQuantity[i]) + "/-");
	}
	
    void billCount() {
        if(!isEmpty()) {
			int sum = 0;
            for(int i=0; i<=lastIndex; i++) {
                this.sum = sum + (itemPrice[i] * itemQuantity[i]);
            }
            System.out.println("Total bill price is: RS: " + this.sum + "/-");
        }
        else
            System.out.println("Cart is empty...");
    }
    
    void itemDisplay() {
            System.out.print("cart items :");
			System.out.print("\nIndex\tName\t\t\tPrice\tQuantity\tDiscription\tBill");
		for(int i=0; i<=lastIndex; i++) {
                    System.out.println("");
                    System.out.print(i);
                    System.out.print("\t"+itemName[i]);
                    System.out.print("\t\t\t"+itemPrice[i]);
                    System.out.print("\t"+itemQuantity[i]);
                    System.out.print("\t\t"+itemDiscription[i]);
                    System.out.print("\tRS: "+(itemPrice[i]*itemQuantity[i]) + "/-");
                }
    }
	
	void returnPayment() {
		
		System.out.println("------ Calculator ------");
		System.out.print("Enter customer Pay Amount : ");
		int customerAmount = input.nextInt();
		
		long returnPayment = customerAmount - sum;
		System.out.print("Return Payment is: " + returnPayment + "/-");
		
	}

    boolean isFull() {
        if(lastIndex == indexSize-1) {
            return true;
        }
        else
            return false;
    }

    boolean isEmpty() {
        if(lastIndex<0) {
            return true;
        }
        else
            return false;
    }
}