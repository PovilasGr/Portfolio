
def reader(filename):
    with open(filename) as file:
        return (json.load(file))

def read_customer_list_from_json(customer_json, customer_list):
    for single_customer in customer_json:
            one_customer = customer(single_customer['customer_id'], single_customer['firstname'], 
                single_customer['gmail'], single_customer['item_list'])
            customer_list.append(one_customer)
    return customer_list

def URL_lists(main_soup, URLS):
    category = main_soup.find('div', class_ = 'CATEGORY_THUMBS')
    for link in category.find_all('li'):
        URLS.append(MAIN_URL + link.a.get('href'))
        if len(URLS) == MAX_CATEGORIES_USED: break
    return URLS

def Scrape_From_URL(Single_URL, id, list):
    skip = bool
    req = requests.get(Single_URL)
    soup = BeautifulSoup(req.text, 'lxml')

    max_page = soup.find_all('li', class_ = 'number')[-1]

    for page in range(1, int(max_page.text)):
        req = requests.get(Single_URL + '?p=' + str(page))
        soup = BeautifulSoup(req.text, 'lxml')
        item_count = 0

        if skip == True:
            skip = False
            break

        for it in soup.find_all('div', class_ = 'GRID_ITEM'):
            if item_count == MAX_ITEMS_PER_CATEGORY: 
                skip = True
                break

            name = it.find('div', class_ = 'product-title')
            price = it.find('span', class_ = 'price-value')
            
            details = it.find_all('li')
            for li in details:
                if 'Gamintojas' in li.text:
                    item_brand = li.span.text

            one_item = item(id, name.a.text, item_brand, float(price.text[:len(price.text)-2]))
            list.add_to_items(one_item)

            item_count += 1
            id += 1

def make_customer_cart_list(customer_list, item_list):
    customer_cart_list = []
    for single_customer in customer_list:
        names_list = []
        total = 0
        for id in single_customer.item_list:
            for single_item in item_list.items:
                if id == single_item.getID():
                    total += single_item.getPrice()
                    names_list.append(single_item.getName())
        customer_cart = cart(single_customer.getID(), single_customer.getFirstname(), single_customer.getGmail(), single_customer.getList(), names_list, round(total, 2))
        customer_cart_list.append(customer_cart)
    return customer_cart_list


def writer(filename, list):
    with open(filename, 'w', encoding="utf-8") as file:
        res_list = []
        for cust_cart in list:
            res_list.append(cust_cart.__dict__)
        json.dump(res_list, file, indent = 4, ensure_ascii=False)
    file.close

def start():
    start = datetime.now()
    print('Started:', start)
    return start

def end(started):
    end = datetime.now()
    print('Ended:', end)
    return end - started

from classes import item, customer, cart, items
import json
from main import MAX_CATEGORIES_USED, MAIN_URL, MAX_ITEMS_PER_CATEGORY
from datetime import datetime
import requests
from bs4 import BeautifulSoup
