#!/usr/bin/env python
<<<<<<< HEAD
from fileinput import close
=======
from distutils.dep_util import newer_pairwise
>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282
import json
import sys

def reader(filename):
    with open(filename) as file:
        return (json.load(file))

def disc_perc(str):
    discount = discounts(discounts_json['christmas_discount'], discounts_json['easter_discount'], discounts_json['black_friday_discount'], discounts_json['PVM'])
    if str == 'pvm':
        return (100-discount.get_pvm()) / 100
    elif str == 'easter_discount':
        return (100-discount.get_ed()) / 100
    elif str == 'black_friday_discount':
        return (100-discount.get_bf()) / 100
    elif str == 'christmas_discount':
        return (100-discount.get_cd()) / 100

class customer:
<<<<<<< HEAD
    def __init__(self, customer_id, firstname, gmail, item_list, discount):
        self.customer_id = customer_id
        self.firstname = firstname
        self.gmail = gmail
        self.item_list = item_list
        self.discount = discount

class customer_list:
=======
>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282
    def __init__(self):
        self.customers = []

    def add_customer(self, customer):
        ids = []
        for i in self.customers: 
            ids.append(i['customer_id'])
        if customer['customer_id'] not in ids:
            self.customers.append(customer)
        else:
            sys.exit("ERROR: Customers can't have duplicate ids")

    def remove_customer(self, customer):
        if customer['customer_id'] == any(self.customers):
            self.customers.remove(customer)
        else:
            print('ERROR:',customer['customer_name'], 'Does not exist')
    
    def set_name(self, newname, id):
        for i in self.customers:
            if i['customer_id'] == id:
                    i['firstname'] = newname

    def get_name(self, id):
        for i in self.customers:
            if i['customer_id'] == id:
                return i['firstname']

class item:
<<<<<<< HEAD
    def __init__(self, item_id, item_name, item_brand, item_price):
        self.item_id = item_id
        self.item_name = item_name
        self.item_brand = item_brand
        self.item_price = item_price

class item_list:
=======
>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282
    def __init__(self):
        self.items = []

    def add_item(self, item):
        ids = []
        for i in self.items:
            ids.append(i['item_id'])
        if item['item_id'] not in ids:
            self.items.append(item)
        else:
            sys.exit("ERROR: Items can't have duplicate ids")

    def available_items(self):
        print("\nAvailable items:\nID  Name    Brand   Price")
        for x in self.items:
            print(x['item_id'], ' ', x['item_name'], ' ', x['item_brand'], ' ', x['item_price'])

    def get_item(self, id):
        for x in self.items:
            if x['item_id'] == id:
                return x

class cart:
    def __init__(self):
        self.cart = []

    def add_to_cart(self, item):
        self.cart.append(item)

    def remove_from_cart(self, item):
        if item in self.cart:
            self.cart.remove(item)
        else:
            print("No such item in the cart")

    def apply_discount(self, discount):
        for x in self.cart:
            result = x['item_price'] * (100-discount) / 100
            x['item_price'] = round(result, 2)

    def cart_info(self):
        print("\nCart:\nItem    Brand   Price")
        for x in self.cart:
            print(x['item_name'], ' ', x['item_brand'], ' ', x['item_price'])
            
    def get_cart_list(self):
        cart_list = []
        for x in self.cart:
            cart_list.append(x)
        return cart_list

    def cart_item_names(self):
        print("\nCart item names:")
        for x in self.cart:
            print(x['item_name'])

    def get_cart_total(self):
        sum = 0
        for x in self.cart:
            sum += x['item_price']
        return round(sum, 2)

    def print_cart_total(self):
        sum = 0
        print("\nCart Total:")
        for x in self.cart:
            sum += x['item_price']
        print(round(sum, 2))

class discounts:
    def __init__(self, christmas_discount, easter_discount, black_friday_discount, pvm):
        self.christmas_discount = christmas_discount
        self.easter_discount = easter_discount
        self.black_friday_discount = black_friday_discount
        self.pvm = pvm
    
    def get_cd(self):
        return self.christmas_discount

    def get_ed(self):
        return self.easter_discount

    def get_bf(self):
        return self.black_friday_discount

    def get_pvm(self):
        return self.pvm

    def set_cd(self, newvalue):
        self.christmas_discount = newvalue

    def set_ed(self, newvalue):
        self.easter_discount = newvalue

    def set_bf(self, newvalue):
        self.black_friday_discount = newvalue

    def set_pvm(self, newvalue):
        self.pvm = newvalue

    def get_discount_info(self):
        print('\nDiscount Rates:')
        for i, j in self.__dict__.items():
            print(i,': ', j)

    def __str__(self):
        return str(self.__dict__)

if __name__ == '__main__':
    sum = 0
    icart = cart()
<<<<<<< HEAD
    items = item_list()
    customers = customer_list()
=======
    items = item()
    customers = customer()
>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282
    item_json = reader('items.json')
    customer_json = reader('customers.json')
    discounts_json = reader('discounts.json')
    discount = discounts(discounts_json['christmas_discount'], discounts_json['easter_discount'], discounts_json['black_friday_discount'], discounts_json['PVM'])

    for x in item_json:
<<<<<<< HEAD
        sitem = item(x['item_id'], x['item_name'], x['item_brand'], x['item_price'])
        items.add_item(sitem.__dict__)

    for y in customer_json:
        scustomer = customer(y['customer_id'], y['firstname'], y['gmail'], y['item_list'], y['discount'])
        customers.add_customer(scustomer.__dict__)
=======
        items.add_item(x)

    for y in customer_json:
        customers.add_customer(y)
>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282

    #Shopping Cart Functionality Using Customer Json
    
    print('Available Items:')
    for i in items.items:
<<<<<<< HEAD
        result = "".join(f"{key}: {value};  " for key, value in i.items())
        print(result)
    print('\n')
    
=======
        result = " ".join(f"{key}: {value};  " for key, value in i.items())
        print(result)
    print('\n')
>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282
    for i in customers.customers:
        #result = " ".join(f"{key}: {value};   " for key, value in i.items())
        #print(result)
        print('Customer name:', i['firstname'], '\n    id of items in cart:', i['item_list'])
<<<<<<< HEAD
  
=======

>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282
    for i in customers.customers:
        list = i['item_list']
        for j in list:
            for x in items.items:
                if x['item_id'] == j:
                    #x['discount'] = i['discount']
                    x = {'item_id': x['item_id'], 'item_name': x['item_name'], 'item_brand': x['item_brand'], 'item_price': x['item_price'], 'discount': i['discount']}
                    icart.add_to_cart(x)
<<<<<<< HEAD
=======
                    
    print("\nAll items spread in carts:")
    icart.cart_info()
>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282

    print('\nCustomer Cart Details:')
    cart_list = icart.get_cart_list()
    sum = 0
<<<<<<< HEAD
    res_list = []
    for i in range(len(customers.customers)):
        total = len(customers.customers[i]['item_list'])
        ctotal = 0
        result = dict()
        res = dict()
        item_names , item_ids = [], []
        print("Shopping cart of:",  customers.customers[i]['firstname'] , "\n     gmail:" , customers.customers[i]['gmail'] ,"\n Name   Brand   Price")
        res['customer_id'], res['Name'], res['gmail'] = customers.customers[i]['customer_id'], customers.customers[i]['firstname'], customers.customers[i]['gmail']
        for j in range(total):
            if cart_list[sum]['discount'] != 'None':
                result = cart_list[sum]['item_price'] * disc_perc(cart_list[sum]['discount'])
                cart_list[sum]['item_price'] = round(result, 2)
            item_names.append(cart_list[sum]['item_name'])
            item_ids.append(cart_list[sum]['item_id'])
            print(cart_list[sum]['item_name'], ' ', cart_list[sum]['item_brand'], ' ', str(cart_list[sum]['item_price']), ' ')
            ctotal += cart_list[sum]['item_price']
            sum += 1
        res['item_ids'], res['item_names'] = item_ids, item_names
        res['cart_total'] = round(ctotal, 2)
        res_list.append(res)
        print('Cart Total:', round(ctotal, 2))
        print('\n')

    print("\nAll items spread in customer carts:")
    icart.cart_info()

    with open('Customer_Carts.json', 'w') as file:
        json.dump(res_list, file, indent = 4)
    file.close

    for i in cart_list:
        result = " ".join(str(value) for key, value in i.items())



=======
    for i in range(len(customers.customers)):
        total = len(customers.customers[i]['item_list'])
        ctotal = 0
        print('Shopping cart of:', customers.customers[i]['firstname'], '\n     gmail:', customers.customers[i]['gmail'], '\nName   Brand   Price')
        for i in range(total):
            if cart_list[sum]['discount'] != 'None':
                result = cart_list[sum]['item_price'] * disc_perc(cart_list[sum]['discount'])
                cart_list[sum]['item_price'] = round(result, 2)
            print(cart_list[sum]['item_name'], ' ', cart_list[sum]['item_brand'], ' ', cart_list[sum]['item_price'], ' ')
            ctotal += cart_list[sum]['item_price']
            sum += 1
        print('Cart Total:', round(ctotal, 2))
        print('\n')

>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282
    #UI Shopping
    '''
    items.available_items()
    if input("\nWould you like to see our discount rates? (Y/N): ") == "Y" :
        discount.get_discount_info()

    str = str(input("Would you like to add an item to your cart? (Y/N): "))
    if str == 'Y':
        while(str != 'N'):
            if sum != 0: 
                str = input("Would you like to add another item to your cart? (Y/N): ")
            if str == 'Y':
                id = int(input("Input the id of an item (one per time): "))

                for i in items.items:
                    if (i['item_id'] == id):
                        icart.add_to_cart(i)
                icart.cart_info()
                sum += 1
            else: 
                str = 'N'

        if (input("Would you like to apply a discount to your cart? (Y/N): ") == 'Y'):
            str = input("Which one? (cd / ed / bf / pvm): ")
            if str == 'cd':
                icart.apply_discount(discount.get_cd())
            elif str == 'ed':
                icart.apply_discount(discount.get_ed())
            elif str == 'bf':
                icart.apply_discount(discount.get_bf())
            elif str == 'pvm':
                icart.apply_discount(discount.get_pvm())
            else:
                print("No such discount available")
            
        print('\nFinal Cart Prices')
        icart.cart_info()
        icart.print_cart_total()
    else:
        print("Have a nice day")
    '''

<<<<<<< HEAD
    #Item/Cart Functionality
=======
  #Item/Cart Functionality
>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282

    '''
    items.available_items()
    discount.get_discount_info()

    id = [1, 2, 4]

    for i in items.items:
        for j in id:
            if i['item_id'] == j:
                icart.add_to_cart(i)
    icart.cart_info()
    remove_id = [2]

    for i in items.items:
        for j in remove_id:
            if i['item_id'] == j:
                icart.remove_from_cart(i)

    icart.cart_info()
    icart.apply_discount(discount.get_pvm())
    print('\nCart With applied discounts:')
    icart.cart_info()
    icart.cart_item_names()
    icart.print_cart_total()

    print('\n')
    item_3id = items.get_item(3)
    result = " ".join(str(value) for key, value in item_3id.items())

    print(result)
    '''