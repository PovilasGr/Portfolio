
class item:
    def __init__(self, item_id, item_name, item_brand, item_price):
        self.item_id = item_id
        self.item_name = item_name
        self.item_brand = item_brand
        self.item_price = item_price

    def getID(self):
        return self.item_id

    def getName(self):
        return self.item_name

    def getBrand(self):
        return self.item_brand

    def getPrice(self):
        return self.item_price

class customer:
    def __init__(self, customer_id, firstname, gmail, item_list):
        self.customer_id = customer_id
        self.firstname = firstname
        self.gmail = gmail
        self.item_list = item_list

    def getID(self):
        return self.customer_id
    
    def getFirstname(self):
        return self.firstname
    
    def getGmail(self):
        return self.gmail

    def getList(self):
        return self.item_list

class cart:
    def __init__(self, Customer_ID, Customer_Name, Customer_Gmail, Cart_Item_IDs, Item_Names, Cart_Total):
        self.Customer_ID = Customer_ID
        self.Customer_Name = Customer_Name
        self.Customer_Gmail = Customer_Gmail
        self.Cart_Item_IDs = Cart_Item_IDs
        self.Item_Names = Item_Names
        self.Cart_Total = Cart_Total
    
    def getCustomerID(self):
        return self.Customer_ID

    def getCustomerName(self):
        return self.Customer_Name

    def getGmail(self):
        return self.Customer_Gmail

    def getItemIDs(self):
        return self.Cart_Item_IDs

    def getItemNames(self):
        return self.Item_Names

    def getCartTotal(self):
        return self.Cart_Total

class items:
    def __init__(self):
        self.items = []

    def add_to_items(self, item):
        self.items.append(item)

    def clear_items(self):
        for item in self.items:
            self.items.remove(item)