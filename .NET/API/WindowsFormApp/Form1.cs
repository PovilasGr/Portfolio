using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.VisualStyles;
using API;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace WindowsFormApp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        public string FirstToUpper(string str)
        {
            return char.ToUpper(str[0]) + str.Substring(1);
        }

        private void fill_listbox1(object sender, EventArgs e)
        {
            var coin_list = Method.GetCoins();
            foreach(var item in coin_list)
            {
                listBox1.Items.Add(FirstToUpper(item));
            }
        }

        private void listBox1_DoubleClick(object sender, EventArgs e)
        {
            listBox2.Items.Clear();
            if (listBox1.SelectedItem != null)
            {
                string coin_name = listBox1.SelectedItem.ToString().ToLower();
                var exchange_list = Method.GetExchanges(coin_name);
                
                foreach (var item in exchange_list)
                {
                    listBox2.Items.Add(FirstToUpper(item));
                } 
            }
        }

        private void listBox2_DoubleClick(object sender, EventArgs e)
        {
            if (listBox2.Items.Count != 0) textBox1.Clear();
            string coin_name = listBox1.SelectedItem.ToString().ToLower();
            string exchange_name = listBox2.SelectedItem.ToString();
            var price = Method.GetPrice(coin_name, exchange_name);
            textBox1.Text = price;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedItem != null)
            {
                string coin_name = listBox1.SelectedItem.ToString().ToLower();
                var exchange_list = Method.GetExchanges(coin_name);

                foreach (var item in exchange_list)
                {
                    listBox2.Items.Add(FirstToUpper(item));
                }
            }
            else
                MessageBox.Show("Please select a coin first");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (listBox2.SelectedItem != null)
            {
                if(listBox2.Items.Count != 0) textBox1.Clear();
                string coin_name = listBox1.SelectedItem.ToString().ToLower();
                string exchange_name = listBox2.SelectedItem.ToString();
                var price = Method.GetPrice(coin_name, exchange_name);
                textBox1.Text = price;
            }
            else if (listBox2.Items.Count == 0) MessageBox.Show("Please choose a coin first");
            else
                MessageBox.Show("Please select an exchange");


        }

        private void Clear_Click(object sender, EventArgs e)
        {
            if (listBox2.Items.Count == 0 && textBox1.Text == "" && textBox2.Text == "" && textBox3.Text == "") MessageBox.Show("Nothing to clear");
            else
            {
                if (listBox2.Items.Count != 0) listBox2.Items.Clear();
                if (textBox1.Text != "") textBox1.Clear();
                if (textBox2.Text != "") textBox2.Clear();
                if (textBox3.Text != "") textBox3.Clear();
                if (listBox1.SelectedItem != null) listBox1.ClearSelected();
    
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedItem != null)
            {
                string coin_name = listBox1.SelectedItem.ToString().ToLower();
                var best = Method.GetBestExchange(coin_name);

                foreach ( var item in best ) 
                { 
                    textBox2.Text = item.Key;
                    textBox3.Text = item.Value;
                }
            }
            else
                MessageBox.Show("Please select a coin first");
        }
    }
}
