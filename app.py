from newsapi import NewsApiClient
import datetime as dt

newsapi = NewsApiClient(api_key="1fcf667ddcf54e5db3bb887e60be09a6")

data = newsapi.get_everything(q='jupyter lab', language='en', page_size=20)

articles = data['articles']

for x, y in enumerate(articles):
    print(f'{x}    {y["title"]}')
#for key, value in articles[0].items():
#    print(f"\{key.ljust(15)} {value}")