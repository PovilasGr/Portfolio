import requests
from bs4 import BeautifulSoup
import json
from threading import Thread
from datetime import datetime
from classes import item, customer, cart, items
from functions import reader, read_customer_list_from_json, URL_lists, Scrape_From_URL, make_customer_cart_list, writer, start, end

MAIN_URL = 'https://www.varle.lt'
SCRAPE_URL = 'https://www.varle.lt/kompiuterine-technika/'

MAX_ITEMS_PER_CATEGORY = 15
MAX_CATEGORIES_USED = 4
START_ID = 100

if __name__ == '__main__':

    main_req = requests.get(SCRAPE_URL)
    main_soup = BeautifulSoup(main_req.text, 'lxml')


    customer_json = reader('customers.json')
    customer_list = read_customer_list_from_json(customer_json, customer_list = [])
    URLS = URL_lists(main_soup, URLS = [])

    #MUTLITHREADING
    print('\nMulti Threading:')
    
    started = start()
    i_list_thread = items()
    id = START_ID

    threads = []
    for Single_URL in URLS:
        thread = Thread(target = Scrape_From_URL, args = (Single_URL, id, i_list_thread))
        thread.start()
        threads.append(thread)
        id += MAX_ITEMS_PER_CATEGORY

    for thread in threads:
        thread.join()
    
    time_taken_multi = end(started)

    print('\nMultithreading Scraping Took:', time_taken_multi)

    thread_customer_cart_list = make_customer_cart_list(customer_list, i_list_thread)
    writer('Customer_Carts_Multithreading.json', thread_customer_cart_list)

    #SINGLETHREADING
    print("\nSingle Threading:")

    started = start()
    i_list = items()
    id = START_ID

    for Single_URL in URLS:
        Scrape_From_URL(Single_URL, id, i_list)
        id += MAX_ITEMS_PER_CATEGORY

    time_taken_single = end(started)

    print('\nSingle Threading Scraping Took:', time_taken_single)

    print('\nMULTITHREAD SCRAPING WAS FASTER BY:', time_taken_single - time_taken_multi, '\n')
    
    customer_cart_list = make_customer_cart_list(customer_list, i_list)
    writer('Customer_Carts.json', customer_cart_list)
 
    writer('Scraped_Items.json', i_list_thread.items)