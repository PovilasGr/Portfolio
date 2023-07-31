import task2
import unittest

class Tests(unittest.TestCase):
    def test_duplicate_item_id_addition(self):
<<<<<<< HEAD
        it = task2.item_list()
=======
        sum = 0
        it = task2.item()
>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282
        it.add_item({'item_id': 1, 'item_name': 'Loptop', 'item_brand': 'Lenovo', 'item_price': 799.99})
        with self.assertRaises(SystemExit):
            it.add_item({'item_id': 1, 'item_name': 'iPhone 13', 'item_brand': 'Apple', 'item_price': 899.99})

    def test_discount_addition(self):
        tcart = task2.cart()
        discount = task2.discounts(25, 10, 30, 21)
<<<<<<< HEAD
        result = 1449.99 * 79 / 100
=======
>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282
        tcart.add_to_cart({'item_id': 4, 'item_name': 'TV', 'item_brand': 'Samsung', 'item_price': 1449.99})
        tcart.apply_discount(discount.pvm)
        for i, j in tcart.__dict__.items():
            for z in j:
<<<<<<< HEAD
                self.assertEqual(z['item_price'], round(result, 2))
=======
                self.assertEqual(z['item_price'], 1145.49)
>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282
    
    def test_removal_from_cart(self):
        item1 = {'item_id': 5, 'item_name': 'Watch', 'item_brand': 'Rolex', 'item_price': 2139.49}
        item2 = {'item_id': 3, 'item_name': 'Monitor', 'item_brand': 'AOC', 'item_price': 345.99}
        tcart = task2.cart()
        tcart.add_to_cart(item1)
        tcart.add_to_cart(item2)
        tcart.remove_from_cart(item1)
        for i, j in tcart.__dict__.items():
            self.assertNotIn(item1, j)

    def test_cart_total(self):
        tcart = task2.cart()
        tcart.add_to_cart({'item_id': 1, 'item_name': 'Loptop', 'item_brand': 'Lenovo', 'item_price': 450})
        tcart.add_to_cart({'item_id': 2, 'item_name': 'iPhone 13', 'item_brand': 'Apple', 'item_price': 300})
        tcart.add_to_cart({'item_id': 3, 'item_name': 'Monitor', 'item_brand': 'AOC', 'item_price': 250})
        self.assertEqual(tcart.get_cart_total(), 1000)
        
    def test_customer_name_setter(self):
<<<<<<< HEAD
        customers = task2.customer_list()
=======
        customers = task2.customer()
>>>>>>> ff092f3855d5ed11c4fae8f9ae4b708dbfd14282
        new_name = 'Andrius'
        customers.add_customer({'customer_id': 24, 'firstname': 'Povilas', 'gmail': 'povilas.grigas@mif.vu.stud.lt', 'item_list': [2, 3]})
        customers.set_name('Andrius', 24)
        self.assertEqual(customers.get_name(24), new_name)
    
if __name__ == '__main__':
    unittest.main()