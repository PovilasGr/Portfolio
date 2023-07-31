from flask import Flask, render_template, url_for, request, redirect
from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
from wtforms.validators import Length, InputRequired
from flask_sqlalchemy import SQLAlchemy
from datetime import datetime
from sqlalchemy import or_
from functions import reader

app = Flask(__name__)
app.config['SECRET_KEY'] = 'SECRET_KEY'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///items.db'

db = SQLAlchemy(app)

def appendToDB(json):
    for item in json:
            new_item = Item(name = item['item_name'], 
                brand = item['item_brand'], price = item['item_price'])
            db.session.add(new_item)
            db.session.commit()


class Item(db.Model):
    __tablename__ = "items"  
    id = db.Column(db.Integer, primary_key = True)
    name = db.Column(db.String(1000), unique=False, nullable = False)
    brand = db.Column(db.String(100), unique=False, nullable = False)
    price = db.Column(db.Integer, nullable = False)
    date = db.Column(db.DateTime, default = datetime.now())

    def __repr__(self):
        return f"Item('{self.name}', '{self.brand}', '{self.price}\n'"

class searchForm(FlaskForm):
    search = StringField('Search', validators=[InputRequired(), Length(min=1, max=30)])
    submit = SubmitField('Search')

@app.route('/')
def home():
    return render_template('home.html')

@app.route('/items')
def available():
    form = searchForm()
    items = Item.query.all()
    return render_template('items.html', items=items, form=form)

@app.route('/items/create' , methods = ['GET','POST'])
def create():
    if request.method == 'GET':
        return render_template('create.html')
 
    if request.method == 'POST':
        name = request.form['name']
        brand = request.form['brand']
        price = request.form['price']
        new_item = Item(name = name, brand = brand, price = price)
        db.session.add(new_item)
        db.session.commit()
        return redirect('/items')

@app.route('/items/<int:id>')
def getsingleitem(id):
    item = Item.query.filter_by(id=id).first()
    if item:
        return render_template('viewitem.html', item = item)
    return f"Item with id = {id} Doenst exist"

@app.route('/items/<int:id>/edit',methods = ['GET','POST'])
def update(id):
    item = Item.query.filter_by(id=id).first()
    if request.method == 'POST':
        if item:
            db.session.delete(item)
            db.session.commit()
 
            name = request.form['name']
            brand = request.form['brand']
            price = request.form['price']
            item = Item(name = name, brand = brand, price = price)
 
            db.session.add(item)
            db.session.commit()
            return redirect(f'/items')
        return f"Item with id = {id} Does nit exist"
 
    return render_template('update.html', item = item)

@app.route('/items/<int:id>/delete', methods=['GET','POST'])
def delete(id):
    item = Item.query.filter_by(id=id).first()
    if request.method == 'POST':
        if item:
            db.session.delete(item)
            db.session.commit()
            return redirect('/items')
 
    return render_template('delete.html')


@app.route('/searchResults', methods=['POST', 'GET'])
def search():
    form = searchForm()
    if request.method == "POST" and form.validate_on_submit():
        result_on_search = db.session.query(Item).filter(or_(Item.name.contains(form.search.data), Item.brand == form.search.data))
        if result_on_search != None:
            return render_template("searchResults.html", items=result_on_search,  form = form)
    else:
        return redirect(url_for('available'))

if __name__ == '__main__':
    #db.create_all()
    json = reader('Items.json')
    #appendToDB(json)

    app.run(debug=True)