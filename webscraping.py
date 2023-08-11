from newsapi import NewsApiClient
from flask import Flask,render_template
import datetime as dt


newsapi = NewsApiClient(api_key="1fcf667ddcf54e5db3bb887e60be09a6")

data = newsapi.get_everything(q='jupyter lab', language='en', page_size=20)

articles = data['articles']

for x, y in enumerate(articles):
    print(f'{x}    {y["title"]}')


app = Flask(__name__)

@app.route("/")
@app.route("/index")
def index():
    return render_template("index.html")