using System;
using System.Collections.Generic;
using System.Linq;
using Newtonsoft.Json;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Globalization;

namespace API
{
    public class Method
    {

        private static readonly string base_URL = "https://api.coincap.io/v2/";

        public static List<string> GetCoins()
        {
            List<string> coin_list = new List<string>();

            using (HttpClient Client = new HttpClient())
            {

                string response = Client.GetStringAsync(base_URL + "assets").Result;
                var list = JsonConvert.DeserializeObject<Coins>(response);

                foreach (var item in list.data)
                {
                    coin_list.Add(item.id);
                }

                return coin_list;
            }
        }

        public static List<string> GetExchanges(string coin_name)
        {
            List<string> exchange_list = new List<string>();

            using (HttpClient Client = new HttpClient())
            {
                string response = Client.GetStringAsync(base_URL + "assets/" + coin_name + "/markets").Result;
                var list = JsonConvert.DeserializeObject<Exchanges>(response);

                foreach (var item in list.data)
                {
                    if (exchange_list.Contains(item.exchangeId)) continue;
                    exchange_list.Add(item.exchangeId);
                }

                return exchange_list;
            }
        }

        public static string GetPrice(string coin_name, string exchange_name)
        {
            using (HttpClient Client = new HttpClient())
            {

                string response = Client.GetStringAsync(base_URL + "assets/" + coin_name + "/markets").Result;
                Exchanges list = JsonConvert.DeserializeObject<Exchanges>(response);

                foreach (var item in list.data)
                {
                    if (item.exchangeId == exchange_name)
                    {
                        return item.priceUsd;
                    }

                }
                return "No Price Found";
            }

        }

        public static Dictionary<string, string> GetBestExchange(string coin_name)
        {
            var result = new Dictionary<string, string>();

            double min = double.MaxValue;
            string exchange_name = "";

            using (HttpClient Client = new HttpClient())
            {
                string response = Client.GetStringAsync(base_URL + "assets/" + coin_name + "/markets").Result;
                var list = JsonConvert.DeserializeObject<Exchanges>(response);

                foreach (var item in list.data)
                {
                    var current = Convert.ToDouble(item.priceUsd.Replace(".", ",").Substring(0, 15));
                    if (current < min)
                    {
                        min = Convert.ToDouble(item.priceUsd.Replace(".", ",").Substring(0, 15)); 
                        exchange_name = item.exchangeId;
                    }
                }
                result.Add(exchange_name, min.ToString());

                return result;
            }
        }

    }
}
