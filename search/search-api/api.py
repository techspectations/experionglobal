from flask import Flask,jsonify
from flask_restful import Resource, Api
from flask_restful import reqparse

import api as data
from flask import render_template

app = Flask(__name__)
api = Api(app)

# Rest API to get data for personalized search
@app.route("/neo4jdata")
def getData():
    try:
        d = data.fetch_data()
        #return jsonify({'StatusCode':'200','msg':data.select})
        return d[0]["title"]
    except Exception as e:
        return jsonify({'error': str(e)})

if __name__ == '__main__':
      
    app.run(host='0.0.0.0',port=4000,debug=True)